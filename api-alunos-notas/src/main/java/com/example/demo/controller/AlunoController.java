package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aluno;
import com.example.demo.model.Materias;
import com.example.demo.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins="*")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public ResponseEntity<Aluno>  salvarAluno(@RequestBody Aluno aluno) {
		
		return 	ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
	}
	
	@GetMapping
	@RequestMapping("/buscatodos")
	public List<Aluno> buscarTodos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getById(@PathVariable long id){
		return alunoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	 
	
	
	
}
