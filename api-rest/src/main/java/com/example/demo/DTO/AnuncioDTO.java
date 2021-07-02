package com.example.demo.DTO;

import com.example.demo.entity.anuncio;

public class AnuncioDTO {
	
	private String codigo;
	private String descricao;
	
	
	
	
	public AnuncioDTO(String codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
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
	
	public static AnuncioDTO converte (anuncio anuncio) {
		return new AnuncioDTO (anuncio.getCodigo(), anuncio.getDescricao());
	}
	

}
