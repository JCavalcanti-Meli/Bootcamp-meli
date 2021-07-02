package ufc;

import java.util.Random;

public class Combate {
	
	//tipos abistratos de dados
	private Lutador desafiado;
	private Lutador desafiante;
	
	private int rounds;
	private boolean aprovado;
	
	public void marcarluta(Lutador lutador1, Lutador lutador2) {
		if (lutador1.getCategoria() == lutador2.getCategoria() && lutador1 != lutador2){
			this.aprovado=true;
			this.desafiante = lutador2;
			this.desafiado = lutador1;
			System.out.printf("Vamos para o Combate: "+ lutador1.getNome()+" X " + lutador2.getNome());
		} else if (lutador1.getCategoria() == lutador2.getCategoria()  && lutador1==lutador2) {
			this.aprovado=false;
			this.desafiado=null;
			this.desafiante=null;
			System.out.println("Ops... Mesmo Lutador...");
			
		} else {
			this.aprovado=false;
			this.desafiado=null;
			this.desafiante=null;
			System.out.println("Ops... Não vai rolar...");
		}
		
		
		
	}
	
	public void lutar() {
		if (this.aprovado) {
			System.out.println("\n\n****DE UM LADO O DESAFIANTE*****\n");
			this.desafiante.apresentar();
			System.out.println("\n****DE UM LADO O DESAFIADO*****\n");
			this.desafiado.apresentar();
			
			Random sorteio  = new Random();
			
			int vencedor=0;
			
			vencedor = sorteio.nextInt(3);
			
			switch (vencedor) {
			case 0:
				System.out.println("\nEmpatou...");
				this.desafiado.empatarluta();
				this.desafiante.empatarluta();
				break;
			case 1:
				System.out.println("\nDESAFIANTE WINS: "+this.desafiante.getNome());
				this.desafiado.perderluta();;
				this.desafiante.ganharluta();;
				
				break;
			case 2:
				System.out.println("\nDESAFIADO WINS: "+this.desafiado.getNome());
				this.desafiado.ganharluta();
				this.desafiante.perderluta();;
	
				break;
				
			}
			
		} else {
			
			System.out.println("\nA luta não vai rolar....");
		}
		
		
		
	}
	
	
	
	

	public Lutador getDesafiado() {
		return desafiado;
	}

	public void setDesafiado(Lutador desafiado) {
		this.desafiado = desafiado;
	}

	public Lutador getDesafiante() {
		return desafiante;
	}

	public void setDesafiante(Lutador desafiante) {
		this.desafiante = desafiante;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}
	
	
	
	  

}
