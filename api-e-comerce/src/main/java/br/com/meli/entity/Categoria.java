package br.com.meli.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categoria {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	@ManyToMany
	private List<Produto> produto;
	private boolean usuario = new Usuario().isAdministrador();
	
	public Categoria() {
		
	}
	
	
	public Categoria(long id, String nome, String descricao, List<Produto> produto, boolean usuario) {
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.produto = produto;
		this.usuario = usuario;
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

	public Categoria(List<Produto> produto) {
		super();
		this.produto = produto;
	}

	public boolean isUsuario() {
		return usuario;
	}

	public void setUsuario(boolean usuario) {
		this.usuario = usuario;
	}

	
	
	

}
