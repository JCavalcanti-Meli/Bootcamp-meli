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
		 * O ideal seria que devolv??ssemos 201, pois ?? o caso mais apropriado. Para devolver o c??digo 201 no Controllerdo Spring, o m??todo n??o pode ser void. Ele tem que ter outro retorno. E a?? o Spring tem uma classe chamada ResponseEntity<> que recebe um generic. Esse generic ?? o tipo de objeto que vou devolver no corpo da resposta, que no caso, seria o topico. Mas lembre-se, n??s n??o devolvemos a entidade, as classes de dom??nio, ent??o na verdade vai ser um topicoDto (vamos devolver no corpo da resposta um DTO representando um recurso que acabou de ser criado).
		 * No return, teremos ResponseEntity.created() que devolve o 201. S?? que esse m??todo created() recebe um par??metro uri e que eu preciso passar para ele.
		 * Isso acontece porque toda vez que devolvo 201 para o cliente, al??m de devolver o c??digo, tenho que devolver mais duas coisas: uma delas ?? um cabe??alho HTTP, chamado "Location", com a URL desse novo recurso que acabou de ser criado; a segunda coisa ?? que, no corpo da resposta, eu tenho que devolver uma representa????o desse recurso que acabei de criar. Ent??o, quando eu chamo o m??todo created(), ele fica esperando a uri do recurso que criamos para adicion??-la no cabe??alho Location.
		 * Esse uri que ele recebe ?? a classe URI do Java (vem do pacote java.net). Mas na hora em que crio um objeto uri, tenho que passar o caminho completo dessa uri: "http://localhost:8080/topico/id do t??pico". Para n??o ter que passar esse endere??o completo - at?? porque quando eu colocar o sistema em produ????o n??o vai ser mais localhost: 8080 - o Spring vai nos ajudar novamente.
		 * ??s vamos usar o uriBuilder. depois de URI uri = . Existem alguns m??todos para ele criar um objeto uri. O m??todo que vamos chamar ?? o path(). E aqui est?? o segredo: n??o vou passar o caminho completo, o caminho do servidor. S?? vou passar o caminho do recurso.
		 * O caminho do recurso ser?? "/topicos/". Mas, se eu passar s?? "/t??picos", ?? a lista de t??picos, sendo que aqui, na verdade, criei s?? um ??nico t??pico. No geral, costumamos adicionar um id, que ?? din??mico - ?? o id do t??pico que acabei de criar. Coloco ele entre chaves para dizer que ?? um par??metro din??mico {id}.
		 * Por ??ltimo .buildAndExpand(), m??todo que temos que chamar, passando como par??metro um valor a ser substitu??do no espa??o do {id}, que ?? din??mico. No caso, vou puxar o id do t??pico que acabei de criar no banco de dados e ele vai substituir esse {id} e jogar na uri.
		 * No final, tem um m??todo .toUri(), que converte e transforma na URL completa, com endere??o do servidor e com valores din??micos que posso passar como par??metro no buildAndExpand.
		 * No m??todo cadastrar(), estou recebendo o form e posso colocar uma v??rgula e depois uma classe do Spring chamada UriComponentsBuilder. Seguindo, vou chamar esse par??metro de uriBuilder. ?? s?? declarar o UriComponentsBuilder como par??metro que o Spring vai injetar no m??todo para voc??.
		 * Dessa maneira criamos o uri. ?? o uri que vou passar quando for chamar o m??todo created(). Na sequ??ncia, .body(body), porque tenho que passar o corpo - com o 201, al??m de devolver a uri, preciso devolver um "body", corpo, na resposta. A ideia ?? criarmos um DTO, ent??o, (new TopicoDto(topico). Lembrando que quando dou um new no TopicoDto() posso passar o topico como par??metro. Dentro dele tem todas as informa????es que o DTO precisa. Feito isso, terminamos. return ResposeEntity.created(uri), com a uri do recurso que acabei de criar "/topicos/{id}" seguido do corpo da reposta com TopicoDto().
		 * 
		 */
		
		//RETORNA TUDO: return ResponseEntity.status(HttpStatus.OK).body(topicoRepository.save(topico));
	}
	
	//Vai chegar a requisi????o, o id do TopicoDto, preciso carregar todos os dados do t??pico do banco de dados e transformar em um DTO para devolver como resposta. Para carregar do banco de dados, usamos o topicoRepository.
    //Como buscar por id ?? uma a????o comum, j?? tem um m??todo no Spring chamado getOne(id), em que voc?? passa um id e ele te devolve o objeto t??pico que ?? nossa entidade. Vou selecionar getOne(id)com o comando "Ctrl + 1" e, em seguida, apertar "Assign statement to new local variable" para que ele guarde isso numa vari??vel que vou chamar de Topico. Esse getOne() n??o precisamos delcarar no nosso Repository, ele j?? vem da interface que n??s herdamos, JPARepository.
	@GetMapping("/{id}")
	public TopicoDto buscaId (@PathVariable Long id) {
		
		Topico topico = topicoRepository.getOne(id);
		
		//return new TopicoDto(topico). Lembrando que na hora em que dou new no TopicoDto posso passar um t??pico como par??metro, e ele converte para um DTO. E pronto, ele vai compilar tudo certinho.
		return new TopicoDto(topico);
	
	}
	/*
	 * S?? que nesse m??todo atualizar(), al??m do id, vou precisar dos dados do t??pico que quero atualizar. Ou seja, vou precisar receber um DTO com os dados, parecido com o que fizemos no cadastrar(). S?? que no cadastrar() n??o est??vamos usando o padr??o de nomenclatura DTO e, sim, o padr??o Form. No atualizar() tamb??m preciso receber oTopicoForm form, ele vem no corpo da requisi????o, e tem que ter valida????o, porque n??o posso atualizar com algo inv??lido. Ent??o, vou copiar o TopicoForm form que vem do m??todo cadastrar().
	 * No geral, o ideal seria ter outra classe Form que representa a atualiza????o. Vou criar outra classe, por exemplo, AtualizacaoTopicoForm, e nele s?? estar??o os dados que quero fazer a atualiza????o.
	 * Nessa l??gica, tenho que fazer o seguinte: est?? chegando como par??metro o id do t??pico que quero atualizar, ent??o preciso carreg??-lo do banco de dados. Depois preciso sobrescrever com as informa????es que foram enviadas pelo usu??rio, pelo cliente no AtualizacaoTopicoForm. Para n??o ficar com essa l??gica no Controller, vou encapsular essa l??gica dentro da classe Form. Eu vou chamar de form.atualizar().
	 * Vou ter um m??todo em que passo as informa????es que n??o consigo ter dentro do Form, por exemplo, o id, que vai chegar no Controller. Vou precisar tamb??m do topicoRepository, porque no Form n??o consigo fazer inje????o de depend??ncia, e o m??todo form.atualizar() vai atualizar e vai me devolver o topico como par??metro, como resposta. Sendo que o t??pico que vai ser devolvido ?? o t??pico com as informa????es atualizadas.
	 * Para buscar um t??pico pelo id, j?? vimos como fazer, topicoRepository.getOne(id), passo o id, que chegou como par??metro do m??todo. Pego o t??pico, que veio do banco de dados com as informa????es desatualizadas. Agora vou sobrescrever tudo que eu quiser sobrescrever topico.setTitulo(), e passo o this.titulo, que ?? o que veio no JSON que o usu??rio enviou. Mesma coisa com a mensagem, topico.setmensagem(this.mensagem). E a?? eu retorno o t??pico que foi atualizado return topico.
	 * No caso RETURN, vou usar a classe ResponseEntity para montar uma resposta. Eu n??o estou criando um novo recurso, ent??o n??o vou chamar o m??todo created(), vou chamar s?? o ok(), e a?? passo como par??metro um new TopicoDto(topico), com esse t??pico que foi atualizado. Esse par??metro do ok() ?? o corpo que vai ser devolvido como resposta pelo servidor.
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
