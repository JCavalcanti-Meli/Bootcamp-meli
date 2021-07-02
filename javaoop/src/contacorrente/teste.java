package contacorrente;

public class teste extends ContaCorrente{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	ContaCorrente conta1 = new ContaCorrente(123, 1000, 0);
	ContaCorrente conta2 = new ContaCorrente(321, 5555, 0);
	
	System.out.println("TESTE 1");
	conta1.tranferencia(conta2, 200);
	System.out.println("\nTESTE 1");
	conta1.saquedevolucao(1000);
	
	
	

	}

}
