package cursoemvideo;

import java.util.Scanner;

public class terceiro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		
		int a=10, b=20;
		
		String nome = "Jonathan";
		String sigla = "J";
		
		String resultado;
		
		resultado = (a>b)? nome:sigla;
		
		System.out.printf("Resulta da comparacao entre  A > B é %s", resultado);
		
		
		String anoNascimento, suaIdade;
		int ano, idade;
		System.out.printf("\nDiga o ano de nascimento: ");
		anoNascimento = leia.nextLine();
		//convertendo em Int
		ano = Integer.parseInt(anoNascimento);
		
		idade = 2020 - ano;
		//convertendo em String
		suaIdade = Integer.toString(idade);
		
		String maioridade = (idade>=18)? "Maior de Idade.":"Menor de Idade.";
		
		
		System.out.printf("\nSua idade é %s, e você é %s", suaIdade, maioridade);
		
		
		
		
		
		
		
		
		
		

	}

}
