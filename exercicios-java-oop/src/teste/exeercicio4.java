package teste;

import java.util.Scanner;

public class exeercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Desenvolva um programa para mostrar por console os primeiros n números primos, sendo um valor que o usuário irá inserir pelo console.
		
		Scanner leia = new Scanner(System.in);   
		
		int n;
		
        System.out.println("Digite um númerp para verificar o intervalo de números primos: ");
        n = leia.nextInt();   
        
        for(int i = 2; i <= n; i++) {
        	
            boolean primo = true;   
            
            for(int j = 2; j < i; j++) {            
                
            	if(i % j == 0) {
                    primo = false;
                }
            }
            
            if(primo) {
            	
                System.out.println(i);
            }          
        }
		
		
		

	}

}
