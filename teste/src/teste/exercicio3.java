package teste;

import java.util.Scanner;

public class exercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Desenvolva um programa para informar se um um número n é primo ou não, sendo n um valor que o usuário irá inserir pelo console. 
		//Lembre-se que um número é primo quando só é divisível por 1 e por si mesmo.


		Scanner leia = new Scanner (System.in);
		
		int n = 0, numDiv=0;
		
		System.out.println("Digite o N número: ");
		n = leia.nextInt();
		
		for (int x=1; x<= n; x++) {
			
			if (n%x==0) {
				
				numDiv++;
			}
			
		}
		
		if(numDiv==2) {
			System.out.println("Número PRIMO");
		} else {
			System.out.println("NAO PRIMO");
		}
		
		
		
	}

}
