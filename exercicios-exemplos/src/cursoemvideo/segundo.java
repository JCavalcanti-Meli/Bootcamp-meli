package cursoemvideo;

import java.util.Scanner;

public class segundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		
		
		int num = 10;
		
		int soma=0, soma2=0;
		
		soma = 1 + num++;
		
		int incremento = num;
		
		soma2 = 1 + ++num;
		
		System.out.printf("Soma 1: %d, Incremento: %d, Soma 2: %d ", soma, incremento,  soma2);
		
		int resto=0;
		
		double resultResto = 0;
		
		resultResto = soma %soma2;
		
		System.out.printf("\nResultado Resto: %f",resultResto);
		
		double match = 0;
		//raiz de 125
		match = Math.sqrt(125);
		
		System.out.print("\n"+match);
		
		double aleatorio = Math.random();
		//modo aleatorio
		int n = (int) (1 + (aleatorio*(60-1)));
		
		System.out.println("\n Sorteado é: "+n);
		
		

	}

}
