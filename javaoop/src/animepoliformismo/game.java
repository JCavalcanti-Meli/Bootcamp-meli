package animepoliformismo;

public class game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Naruto uzumaki = new Naruto();
		Dragonball goku = new Dragonball();
		
		uzumaki.setClã("Uzumaki");
		uzumaki.setNome("Minato");
		uzumaki.setNivel(97);
		uzumaki.setOrigem("Jiraya Sensei");
		uzumaki.setClasse("Hokage");
		
		uzumaki.magia();
		uzumaki.especial();
		uzumaki.superpoder();
		
		System.out.print(uzumaki.toString());
		
		
		
		


	}

}
