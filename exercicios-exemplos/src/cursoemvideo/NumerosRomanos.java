package cursoemvideo;

import java.util.Scanner;

public class NumerosRomanos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);

        int[] vaNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String[] vaRom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        while (true) {

            int numero = teclado.nextInt();
            if (numero == 0) break;
            System.out.printf("%-4d ", numero);
            int i = 0;
            while (numero > 0) {
                if (numero >= vaNum[i]) {
                    System.out.print(vaRom[i]);
                    numero -= vaNum[i];
                } else {
                    i++;
                }
            }
            
        }
		

	}

}
