package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {
		
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	//INSTANCIANDO O TOPICO DENTRO DA - DTO
	public TopicoDto(Topico topico) {
		//buscar as informacoes inseridas na Classe principal TOPICO, por meio do GET
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

    //metodo para conversao da Classe Topico, para TopicoDTO na qual vai devolver somente os atributos que eu quero
	public static List<TopicoDto> converter(List<Topico> topicos) {
		
		//usando o STREAM + MAP - CRIO UM NOVO DTOP -------COLETO DA LIST
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
	}
	
	
	

}
