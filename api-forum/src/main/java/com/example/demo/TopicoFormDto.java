package com.example.demo;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sun.istack.NotNull;

public class TopicoFormDto {
	
	@NotNull 
	@NotEmpty 
	@Length(min = 5)
	private String titulo;
	@NotNull 
	@NotEmpty 
	@Length(min = 10)
	private String mensagem;
	//busca no BD - nome curso
	@NotNull 
	@NotEmpty 
	private String nomeCurso;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	/*
	 * Eu vou importar o Curso, em seguida tenho o findByNome, passei o nomeCurso, ele devolveu o objeto curso completo. 
	 * E aí sim eu pego e passo esse objeto na hora de criar o tópico. Agora, no meu TopicoForm.java, no meu método converter(), 
	 * já devolvo um objeto Topico(titulo, mensagem, curso) completo, com título, mensagem e curso que carreguei pelo Repository.
	 * No TopicoForm.java, preciso falar para o Repository, dado o curso, buscar pelo nome. 
	 * Ou seja, Curso curso = cursoRepository.findByNome(). E aí, o meu parâmetro é nomeCurso.
	 */
	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
	}
	
	
	
	
	
	
}
