package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String cpf;
	
	@OneToMany(mappedBy="aluno", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("aluno")
	private List<Materias> materias;
	

	public Aluno() {
		
	}
	
	public Aluno(String nome, String cpf) {
		
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Aluno(String id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	
	
	public List<Materias> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	
}
