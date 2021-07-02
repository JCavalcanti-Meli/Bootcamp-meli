package animepoliformismo;

public abstract class Protagonista {
	
	String nome;
	String origem;
	String classe;
	Arma arma;
	int nivel;
	
	
	
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public abstract void superpoder();
	public abstract void magia();
	public abstract void especial();
	
	
	
	
}
