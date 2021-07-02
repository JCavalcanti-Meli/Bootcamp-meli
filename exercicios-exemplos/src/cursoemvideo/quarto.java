package cursoemvideo;

import java.util.Scanner;

public class quarto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		int idade=0, anoNascimento=0;
		
		System.out.print("Digite seu ano de nascimento: ");
		anoNascimento = leia.nextInt();
		
		idade = 2021 - anoNascimento;
		
		
		if ((idade >= 16 && idade <18) || idade >=70) {
			System.out.print("opcional");
		}else if (idade < 16) {
			System.out.print("proibido");
		} else {
			System.out.print("obrigatorio");
		}

	}

}
