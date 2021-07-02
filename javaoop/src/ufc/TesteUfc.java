package ufc;

public class TesteUfc {

	public static void main(String[] args) {
		
		Lutador lutadores[] = new Lutador[4];
		
		lutadores[0]= new Lutador("Anderson Silva", "Brasileiro", 29, 1.88, 96, 11, 0, 2);
		lutadores[1] = new Lutador ("Silva", "Americano", 22, 1.77, 60, 9, 5, 5 );
		lutadores[2] = new Lutador ("Lukako", "Belga", 28, 1.99, 99, 10, 2, 3 );
		lutadores[3] = new Lutador ("Cristiano R.", "Português", 36, 1.86, 88, 20, 1, 4 );
		
		
		//lutadores[0].apresentar();
		//lutadores[1].apresentar();
		
		Combate SP = new Combate();
		
		SP.marcarluta(lutadores[0], lutadores[2]);
		
		SP.lutar();
		
		
		
	}

}
