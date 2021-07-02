package teste;

import java.util.Arrays;
import java.util.Collections;

public class exercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] array = new Integer [] {52, 10, 85, 1324, 01, 13, 62, 30, 12 , 127};

		Arrays.sort(array);

        System.out.println("Ordem crescente: " + Arrays.toString(array));

        Arrays.sort(array,Collections.reverseOrder());
        
        System.out.println("Ordem decrescente: " + Arrays.toString(array));

	}

}
