package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Aluno;
import com.example.demo.model.Materias;

public interface MateriasRepository extends JpaRepository<Materias, Long>{

}
