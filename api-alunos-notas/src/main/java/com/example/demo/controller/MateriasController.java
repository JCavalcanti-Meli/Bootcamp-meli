package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aluno;
import com.example.demo.model.Materias;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.MateriasRepository;

@RestController
@RequestMapping("/materias")
@CrossOrigin(origins="*")
public class MateriasController {

	@Autowired
	MateriasRepository materiasRepository;
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public ResponseEntity<Materias>  salvarAluno(@RequestBody Materias materias) {
		
		return 	ResponseEntity.status(HttpStatus.CREATED).body(materiasRepository.save(materias));
	}
	
	@GetMapping
	@RequestMapping("/buscatodos")
	public  List<Materias> buscarTodos(){
		return materiasRepository.findAll();
	}
	
	
	
	
}
