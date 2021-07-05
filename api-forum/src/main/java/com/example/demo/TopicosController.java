package com.example.demo;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	/*busca todos
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(){
		List<Topico> topicos = topicoRepository.findAll();
		return TopicoDto.converter(topicos);
	}*/
	
	//busca pelo atributo CURSO - que tem relacionamento com TOPICO, mais especificamente o atributo NOME a classe CURSO\
	//Assim, devemos passar o parametro CURSO, e criar um metodo especifico de FindBy....
	//BUSCA TODOS OU PASSANDO O PARAMETRO:nomeCurso - PELA URL... EXEMPLO: /topicos?nomeCurso=Spring
	@GetMapping //dto dados que saem da api
	public List<TopicoDto> lista(String nomeCurso){
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else 
		{                                      //Classe:CURSO/Atributo:Nome - pode ser separado desta forma:findByCurso_Nome(nomeCurso)
		List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
		return TopicoDto.converter(topicos);
		}
	}
	
	/*
	 * 	@RequestMapping("/topicos")
	public List<TopicoDto> lista(){
		//criando topico em memoria
		Topico topico = new Topico("Duvida", "Problema com maven", new Curso ("Spring", "Backend"));
		//CONVERTER DTO EM DTO - trazendo uma Lista do objeto - Topico
		return TopicoDto.converter(Arrays.asList(topico));
	}
	 */
	
	@PostMapping //com @RequestBody pega o parematro do corpo da requisao - JSON, sem esta anotacao ele pega pela URL//Form dados que vem do cliente
	public ResponseEntity<TopicoDto> cadastrar (@RequestBody @Valid TopicoFormDto form, UriComponentsBuilder uriBuilder ) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
		/*
		 * O ideal seria que devolvêssemos 201, pois é o caso mais apropriado. Para devolver o código 201 no Controllerdo Spring, o método não pode ser void. Ele tem que ter outro retorno. E aí o Spring tem uma classe chamada ResponseEntity<> que recebe um generic. Esse generic é o tipo de objeto que vou devolver no corpo da resposta, que no caso, seria o topico. Mas lembre-se, nós não devolvemos a entidade, as classes de domínio, então na verdade vai ser um topicoDto (vamos devolver no corpo da resposta um DTO representando um recurso que acabou de ser criado).
		 * No return, teremos ResponseEntity.created() que devolve o 201. Só que esse método created() recebe um parâmetro uri e que eu preciso passar para ele.
		 * Isso acontece porque toda vez que devolvo 201 para o cliente, além de devolver o código, tenho que devolver mais duas coisas: uma delas é um cabeçalho HTTP, chamado "Location", com a URL desse novo recurso que acabou de ser criado; a segunda coisa é que, no corpo da resposta, eu tenho que devolver uma representação desse recurso que acabei de criar. Então, quando eu chamo o método created(), ele fica esperando a uri do recurso que criamos para adicioná-la no cabeçalho Location.
		 * Esse uri que ele recebe é a classe URI do Java (vem do pacote java.net). Mas na hora em que crio um objeto uri, tenho que passar o caminho completo dessa uri: "http://localhost:8080/topico/id do tópico". Para não ter que passar esse endereço completo - até porque quando eu colocar o sistema em produção não vai ser mais localhost: 8080 - o Spring vai nos ajudar novamente.
		 * ós vamos usar o uriBuilder. depois de URI uri = . Existem alguns métodos para ele criar um objeto uri. O método que vamos chamar é o path(). E aqui está o segredo: não vou passar o caminho completo, o caminho do servidor. Só vou passar o caminho do recurso.
		 * O caminho do recurso será "/topicos/". Mas, se eu passar só "/tópicos", é a lista de tópicos, sendo que aqui, na verdade, criei só um único tópico. No geral, costumamos adicionar um id, que é dinâmico - é o id do tópico que acabei de criar. Coloco ele entre chaves para dizer que é um parâmetro dinâmico {id}.
		 * Por último .buildAndExpand(), método que temos que chamar, passando como parâmetro um valor a ser substituído no espaço do {id}, que é dinâmico. No caso, vou puxar o id do tópico que acabei de criar no banco de dados e ele vai substituir esse {id} e jogar na uri.
		 * No final, tem um método .toUri(), que converte e transforma na URL completa, com endereço do servidor e com valores dinâmicos que posso passar como parâmetro no buildAndExpand.
		 * No método cadastrar(), estou recebendo o form e posso colocar uma vírgula e depois uma classe do Spring chamada UriComponentsBuilder. Seguindo, vou chamar esse parâmetro de uriBuilder. É só declarar o UriComponentsBuilder como parâmetro que o Spring vai injetar no método para você.
		 * Dessa maneira criamos o uri. É o uri que vou passar quando for chamar o método created(). Na sequência, .body(body), porque tenho que passar o corpo - com o 201, além de devolver a uri, preciso devolver um "body", corpo, na resposta. A ideia é criarmos um DTO, então, (new TopicoDto(topico). Lembrando que quando dou um new no TopicoDto() posso passar o topico como parâmetro. Dentro dele tem todas as informações que o DTO precisa. Feito isso, terminamos. return ResposeEntity.created(uri), com a uri do recurso que acabei de criar "/topicos/{id}" seguido do corpo da reposta com TopicoDto().
		 * 
		 */
		
		//RETORNA TUDO: return ResponseEntity.status(HttpStatus.OK).body(topicoRepository.save(topico));
	}
	
	//Vai chegar a requisição, o id do TopicoDto, preciso carregar todos os dados do tópico do banco de dados e transformar em um DTO para devolver como resposta. Para carregar do banco de dados, usamos o topicoRepository.
    //Como buscar por id é uma ação comum, já tem um método no Spring chamado getOne(id), em que você passa um id e ele te devolve o objeto tópico que é nossa entidade. Vou selecionar getOne(id)com o comando "Ctrl + 1" e, em seguida, apertar "Assign statement to new local variable" para que ele guarde isso numa variável que vou chamar de Topico. Esse getOne() não precisamos delcarar no nosso Repository, ele já vem da interface que nós herdamos, JPARepository.
	@GetMapping("/{id}")
	public TopicoDto buscaId (@PathVariable Long id) {
		
		Topico topico = topicoRepository.getOne(id);
		
		//return new TopicoDto(topico). Lembrando que na hora em que dou new no TopicoDto posso passar um tópico como parâmetro, e ele converte para um DTO. E pronto, ele vai compilar tudo certinho.
		return new TopicoDto(topico);
	
	}
	/*
	 * Só que nesse método atualizar(), além do id, vou precisar dos dados do tópico que quero atualizar. Ou seja, vou precisar receber um DTO com os dados, parecido com o que fizemos no cadastrar(). Só que no cadastrar() não estávamos usando o padrão de nomenclatura DTO e, sim, o padrão Form. No atualizar() também preciso receber oTopicoForm form, ele vem no corpo da requisição, e tem que ter validação, porque não posso atualizar com algo inválido. Então, vou copiar o TopicoForm form que vem do método cadastrar().
	 * No geral, o ideal seria ter outra classe Form que representa a atualização. Vou criar outra classe, por exemplo, AtualizacaoTopicoForm, e nele só estarão os dados que quero fazer a atualização.
	 * Nessa lógica, tenho que fazer o seguinte: está chegando como parâmetro o id do tópico que quero atualizar, então preciso carregá-lo do banco de dados. Depois preciso sobrescrever com as informações que foram enviadas pelo usuário, pelo cliente no AtualizacaoTopicoForm. Para não ficar com essa lógica no Controller, vou encapsular essa lógica dentro da classe Form. Eu vou chamar de form.atualizar().
	 * Vou ter um método em que passo as informações que não consigo ter dentro do Form, por exemplo, o id, que vai chegar no Controller. Vou precisar também do topicoRepository, porque no Form não consigo fazer injeção de dependência, e o método form.atualizar() vai atualizar e vai me devolver o topico como parâmetro, como resposta. Sendo que o tópico que vai ser devolvido é o tópico com as informações atualizadas.
	 * Para buscar um tópico pelo id, já vimos como fazer, topicoRepository.getOne(id), passo o id, que chegou como parâmetro do método. Pego o tópico, que veio do banco de dados com as informações desatualizadas. Agora vou sobrescrever tudo que eu quiser sobrescrever topico.setTitulo(), e passo o this.titulo, que é o que veio no JSON que o usuário enviou. Mesma coisa com a mensagem, topico.setmensagem(this.mensagem). E aí eu retorno o tópico que foi atualizado return topico.
	 * No caso RETURN, vou usar a classe ResponseEntity para montar uma resposta. Eu não estou criando um novo recurso, então não vou chamar o método created(), vou chamar só o ok(), e aí passo como parâmetro um new TopicoDto(topico), com esse tópico que foi atualizado. Esse parâmetro do ok() é o corpo que vai ser devolvido como resposta pelo servidor.
	 * 
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
	    Topico topico = form.atualizar(id, topicoRepository);

	        return ResponseEntity.ok(new TopicoDto(topico));        
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
	    topicoRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	}
	
	
}
