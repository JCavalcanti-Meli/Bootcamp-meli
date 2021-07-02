package cursoemvideo;

import java.util.Scanner;

public class primeiro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		
		char letra = (char) 'G';
		
		Character letra1 = new Character ('X');
		
		
		
		//float precisa do "f"no final 
		float nota = 9.5f;
		
		float notas = (float) 10.15;
		
		int notaMatematica = 10;
		
		String nome = "Jonathan";
		
		System.out.printf("A nota de %s, é %d . O char é %c & %c. \n \n", nome, notaMatematica, letra, letra1);
		
		
		String name;
		System.out.println("Diga seu nome: ");
		name = leia.nextLine();
		System.out.printf("Nome digitado: %s.",name);
		
		//convertendo uma string num INT
		String numero;
		System.out.println("Diga um número int: ");
		numero = leia.nextLine();
		int numero1;
		numero1 = Integer.parseInt(numero);
		System.out.printf("Nome digitado: %d.",numero1);
		
		int num;
		System.out.println("Diga um NUM int: ");
		num = leia.nextInt();
		String numString;
		numString = Integer.toString(num);
		System.out.printf("Num digitado: %s.",numString);
		
		
		
		
		
		
		
		
		

	}

}
