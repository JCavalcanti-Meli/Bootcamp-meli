package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	//metodo criado para busca por nome
	Curso findByNome(String nomeCurso);
	

}
