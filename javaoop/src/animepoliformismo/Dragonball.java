package animepoliformismo;

public class Dragonball extends Protagonista{
	String raca;

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	@Override
	public void superpoder() {
		System.out.println("Voar!");
		
	}

	@Override
	public void magia() {
		System.out.println("Ki!!");
		
	}

	@Override
	public void especial() {
		System.out.println("Kamehameha");
		
	}
	
	
	

}
