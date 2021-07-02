package controleremoto;

public class ControleRemoto implements Controlador  {

	private int volume;
	private Boolean ligado;
	private Boolean tocando;
	
	
	public ControleRemoto() {
		
		this.volume = 50;
		this.ligado = false;
		this.tocando = false;
	}
	
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Boolean getLigado() {
		return ligado;
	}
	public void setLigado(Boolean ligado) {
		this.ligado = ligado;
	}
	public Boolean getTocando() {
		return tocando;
	}
	public void setTocando(Boolean tocando) {
		this.tocando = tocando;
	}


	@Override
	public void ligar() {
		this.setLigado(true);
		
	}


	@Override
	public void desligar() {
		this.setLigado(false);
	}


	@Override
	public void abrirMenu() {
		if (this.getLigado().equals(true)) {
		System.out.printf("Controle Ligado: %s; Tocando: %s; Volume: %d;", this.getLigado(), this.getTocando(), this.getVolume());
		} else {
			System.out.println("Primeiro ligue a TV.");
		}
	}


	@Override
	public void fecharMenu() {
		
		if (this.getLigado().equals(true)) {
			System.out.println("Menu: Tchaus...");
			} else {
				System.out.println("Primeiro ligue a TV.");
			}
		
	}


	@Override
	public void ligarMudo() {		
		if (this.getLigado().equals(true) && this.getVolume()>0) {
			this.setVolume(0);
			} else {
				System.out.println("Primeiro ligue a TV.");
			}
		
	}


	@Override
	public void desligarMudo() {
		if (this.getLigado().equals(true) && this.getVolume() == 0) {
			this.setVolume(50);
			} else {
				System.out.println("Primeiro ligue a TV.");
			}
		
	}


	@Override
	public void play() {
		if (this.getLigado().equals(true) && this.getTocando().equals(false)) {
			this.setTocando(true);
			} else {
				System.out.println("Primeiro ligue a TV.");
			}
		
	}


	@Override
	public void pause() {
		if (this.getLigado().equals(true) && this.getTocando().equals(true)) {
			this.setTocando(false);
			
			System.out.println("Pausado...");
			} else {
				System.out.println("Primeiro ligue a TV.");
			}
		
	}


	@Override
	public void tocando() {
		if (this.getLigado().equals(true) && this.getTocando().equals(false)) {
			this.setTocando(true);
			System.out.println("Tocando....");
			} else {
				System.out.println("Primeiro ligue a TV.");
			}
		
	}
	
	
	
}
