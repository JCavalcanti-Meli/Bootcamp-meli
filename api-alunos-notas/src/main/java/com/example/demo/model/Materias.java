package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_materias")
public class Materias {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private float nota;
	
	@ManyToOne
	@JsonIgnoreProperties("materias")
	private Aluno aluno;

	
	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
	public Materias() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	
	
	
	
	
	
	
}
