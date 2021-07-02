package cursoemvideo;

import java.util.Scanner;

public class quinto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leia = new Scanner(System.in);
		int num = 0;
		
		System.out.println("Diga qual seu DDD: ");
		num = leia.nextInt();
		
		
		switch (num) {
	     case 11:
	       System.out.println("Você escolheu SP");
	       break;
	     case 21:
	       System.out.println("Você escolheu RJ");
	       break;
	     case 51:
	       System.out.println("Você escolheu SC");
	       break;
	     case 45:
	       System.out.println("Você escolheu RN");
	       break;
	     default:
	       System.out.println("DDD inválido");
	  }
		

	}

}
