package animepoliformismo;

public class Arma {

	String nome;
	String tipo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Arma(String nome, String tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Arma () {
		
	}
	
}
