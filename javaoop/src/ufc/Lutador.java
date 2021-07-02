package ufc;

public class Lutador {
	
	private String nome;
	private String nacionalidade;
	private int idade;
	private double altura;
	private double peso;
	private String categoria;
	private int vitorias;
	private int derotas;
	private int empates;
	
	
	
	public Lutador(String nome, String nacionalidade, int idade, double altura, double peso,
			int vitorias, int derotas, int empates) {
		super();
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
		this.vitorias = vitorias;
		this.derotas = derotas;
		this.empates = empates;
	}
	
	public Lutador() {
		
	}

	//gets and sets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNacionalidade() {  
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
		
			if (this.peso < 52.0) {
				this.setCategoria("Invalida - peso abaixo.");
			}else if (this.peso > 52.0 && this.peso < 70.0) {
				this.setCategoria("Leve ");
			}else if (this.peso > 70.0 && this.peso < 85.0) {
				this.setCategoria("Medio");
			}else if (this.peso > 85.0 && this.peso < 120.0){
				this.setCategoria("Pesado");
			}else {
				this.setCategoria("Inválido - peso acima.");
			}
			
		};
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getDerotas() {
		return derotas;
	}
	public void setDerotas(int derotas) {
		this.derotas = derotas;
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	
	
	public void ganharluta() {
		this.setVitorias(getVitorias()+1);
		
	}
	
	public void perderluta() {
		this.setDerotas(getDerotas()+1);
		
	}
	
	public void empatarluta() {
		this.setEmpates(getEmpates()+1);
		
	}
	
	public void apresentar() {
		
		System.out.println("Lutador: "+this.getNome());
		System.out.println("Origem: "+this.getNacionalidade());
		System.out.println("Idade: "+this.getIdade()+" anos");
		System.out.println("Altura: "+this.getAltura()+"m");
		System.out.println("Pessando: "+this.getPeso());
		System.out.println("Vitórias: "+this.getVitorias());
		System.out.println("Derrotas: "+this.getDerotas());
		System.out.println("Empates: "+this.getEmpates());
		
	}
	
	public void status() {
		System.out.println("Lutador: "+this.getNome());
		System.out.println("Categoria: "+this.getCategoria());
		System.out.println("Vitórias: "+this.getVitorias());
		System.out.println("Derrotas: "+this.getDerotas());
		System.out.println("Empates: "+this.getEmpates());
		
	}
	

}
