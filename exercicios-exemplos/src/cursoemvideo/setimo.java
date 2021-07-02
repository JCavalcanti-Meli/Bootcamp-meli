package cursoemvideo;

import java.util.Scanner;

public class setimo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		double num = 0, soma=0, x=0, saldo=10000;
		String resposta;
		
		
		
		do {
			System.out.printf("Quer sacar quanto do seu saldo de %.2f? ",saldo);
			num = leia.nextDouble();
			saldo -= num;
			
			System.out.printf("Seu saldo de %f. Quer continuar? S/N ",saldo);
			resposta = leia.next();
			
			
			
			
		} while (resposta.equals("S"));

	}

}
