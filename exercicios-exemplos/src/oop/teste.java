package oop;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Caneta bic = new Caneta();
		
		bic.marca = "BIC";
		bic.setModelo("Pena");
		bic.setPonta(1);
		
		Caneta montblanc = new Caneta ("MONTBLANC","Pentil", 10);
		
		System.out.printf("%s %s ", bic.getMarca(), montblanc.getMarca());
		

	}

}
