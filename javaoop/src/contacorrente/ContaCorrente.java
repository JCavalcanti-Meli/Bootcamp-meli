package contacorrente;

import java.util.Scanner;

public class ContaCorrente {
		/*
		 * Crie uma classe Conta Corrente, com os métodos: depósito, saque, devolução e transferência. 
		 * A classe conterá um construtor padrão, um com parâmetros e outro que receberá uma conta corrente 
		 * da qual copiará todos os seus dados. Além disso, os métodos de acesso devem ser desenvolvidos para
		 *  cada variável de instância da classe, desenvolvendo um método set e outro método get. 
		 *  Por exemplo: se a classe tem uma variável double saldo, seus métodos de acesso serão: 
		 *  double getSaldo () e void setSaldo (double s)
		 */
		Scanner leia = new Scanner(System.in);
		int conta;
		double saldo;
		double valor;
		
		public ContaCorrente(int conta, double saldo, double valor) {
			super();
			this.conta = conta;
			this.saldo = saldo;
			this.valor = valor;
		}
		
		public ContaCorrente () {
			
		}
		
		public int getConta() {
			return conta;
		}
		public void setConta(int conta) {
			this.conta = conta;
		}
		public double getSaldo() {
			return saldo;
		}
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		public double getValor() {
			return valor;
		}
		public void setValor(double valor) {
			this.valor = valor;
		}
			
		
		public void saquedevolucao (double valor) {
			
			int resposta;
			
			saldo = saldo - valor;
			
			System.out.println("Conta: " +conta + " Debitado: "+valor+ " Saldo: R$ " + saldo);
			System.out.println("Deseja Devolucao?\nSim(digite 1) /Não(digite 2) ?");
			resposta = leia.nextInt();
			
			if (resposta == 1 || resposta == 11) {
				this.deposito(valor);
				System.out.println("Valor Devolvido! \nConta: " +conta + " Debitado: "+valor+ " Saldo: R$ " + saldo);
			} else {
				System.out.println("Obrigado.");
			}
			
			
		}
		
		public void deposito(double valor) {
			 
			saldo = saldo + valor;
			 
			 }
		
		
		
		public void tranferencia (ContaCorrente contadestino, double valor) {
			this.saque(valor);
			contadestino.deposito(valor);
			
			System.out.println("Conta Destino: " +contadestino.getConta() + " Saldo: R$" + contadestino.saldo);
			
		}
		

		public void saque(double valor) {
			 
			saldo = saldo - valor;
			System.out.println("Conta: " +conta + " Debitado: "+valor+ " Saldo: R$ " + saldo);
		} 
		
		public void Saldo() {
			 System.out.println("Conta: " +conta + " Saldo: R$" + saldo);
			 } 
		
		
	
	

}
