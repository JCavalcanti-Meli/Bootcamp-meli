package animepoliformismo;

public class Naruto extends Protagonista {
	
	String clã;
	
	public String getClã() {
		return clã;
	}

	public void setClã(String clã) {
		this.clã = clã;
	}
	
	@Override
	public String toString() {
		return "Clã: " + clã + ", Nome: " + nome +
			   ", Classe: " + classe + ", Origem: " + origem +
			   ", Nivel: " + nivel;
	}

	//sobrescrevendo métodos da classe abstrata
	@Override
	public void superpoder() {
		System.out.println("Jutsu");
		
	}

	@Override
	public void magia() {
		System.out.println("Ninjutsu");
	}

	@Override
	public void especial() {
		System.out.println("Taijutsu");
	}
	
	
	

}
