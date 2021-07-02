package com.example.demo.entity;

public class anuncio {
	
	
	private long id;
	private String codigo;
	private String descricao;
	
	
	public anuncio(long id, String codigo, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
