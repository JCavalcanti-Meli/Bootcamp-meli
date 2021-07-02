package teste;

import java.util.Scanner;

public class exercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Desenvolva um programa para mostrar os primeiros n números múltiplos de m, sendo n e m valores que o usuário irá inserir via console. 
		//Lembre-se que um número a é divisível por b se a é divisível por b.
		
		
		Scanner leia = new Scanner (System.in);
		
		int n = 0, x = 0, m=0;
		
		System.out.println("Digite o 1 número: ");
		n = leia.nextInt();
		
		System.out.println("Digite o número múltiplo: ");
		m = leia.nextInt();
		
		//m = n * x 
		if (m%n ==0)
		{
			x = m/n;
			System.out.println("Número múltiplo é: "+x);
		} else {
			
			System.out.println("Não tem número");
		}
		
		
		
		
		

	}

}
