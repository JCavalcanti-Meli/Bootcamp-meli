package teste;

import java.util.Scanner;

public class exercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Desenvolva um programa para mostrar os primeiros n números pares, sendo n um valor que o usuário irá inserir pelo console. 
		//Lembre-se que um número é par quando divisível por 2.
		
		System.out.println("Hello Word");
		Scanner leia = new Scanner (System.in);
		
		int n = 0, n2 = 2;
		
		System.out.println("Digite o 1 número: ");
		n = leia.nextInt();
		
		System.out.println("Digite o 2 número: ");
		n2 = leia.nextInt();
		
		if (n%2 == 0 ) {
			System.out.println("N1 - É par");
		} else {
			System.out.println("N1 - É impar ");
		}
		
		if (n2%2 == 0 ) {
			System.out.println("N2 - É par");
		} else {
			System.out.println("N2 - É impar ");
		}
		
		
		
		
	}

}
