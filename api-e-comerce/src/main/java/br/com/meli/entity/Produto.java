package br.com.meli.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	private double valor;
	@ManyToOne
	private Pedido pedido;
	@ManyToMany
	private List<Categoria> categoria;
	private boolean usuario = new Usuario().isAdministrador();
	
	
	public Produto() {
	
	}
	
	public Produto(long id, String nome, String descricao, double valor, Pedido pedido, List<Categoria> categoria,
			boolean usuario) {
	
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.pedido = pedido;
		this.categoria = categoria;
		this.usuario = usuario;
	}


	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isUsuario() {
		return usuario;
	}

	public void setUsuario(boolean usuario) {
		this.usuario = usuario;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}



}
