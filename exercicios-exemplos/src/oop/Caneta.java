package oop;

public class Caneta {

		public String marca;
		private String modelo;
		private int ponta;
		
		
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
			System.out.print(1);
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public int getPonta() {
			return ponta;
		}
		public void setPonta(int ponta) {
			this.ponta = ponta;
		}
		
		
		public Caneta() {
			
		}
		
		public Caneta(String marca, String modelo, int ponta) {
			super();
			this.marca = marca;
			this.modelo = modelo;
			this.ponta = ponta;
		}
		
		
		
		
		
		
		
		



}
