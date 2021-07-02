package teste;

import java.util.Scanner;

public class exercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Desenvolver um programa para exibição por console os n primeiros números naturais que têm pelo menos de m dígitos de d, 
		 * sendo n, m e d valores que o utilizador vai enviar pelo console.
		 * Por exemplo: se o usuário inserir n = 5, m = 2 e d = 3, o programa deve exibir os primeiros 5 números naturais que tenham pelo menos 2 dígitos 3 no console. 
			Neste caso, a saída será: 33, 133 , 233, 303, 313.
		 */
		Scanner leia = new Scanner(System.in); 
		
		int n=0, m=0, d=0, aux=0, count=0, p=0;
		
		System.out.println("Digite um número N: ");
        n = leia.nextInt();  
        System.out.println("Digite um número N: ");
        m = leia.nextInt();  
        System.out.println("Digite um número N: ");
        d = leia.nextInt();  
        
       while(count !=n) {
    	   String number = Integer.toString(aux);
    	   p=0;
    	   
    	   
    	   for (int i=0; i < number.length(); i++) {
    		   char chr = number.charAt(i);
    		   
    		   if (d== Character.getNumericValue(chr)) {
    			   p++;
    		   }
    	   }
    		   
    		   if (m==p) {
    			   System.out.println(aux);
    			   count++;
    		   }
    	
    	aux++;   
       }
        
        

	}

}
