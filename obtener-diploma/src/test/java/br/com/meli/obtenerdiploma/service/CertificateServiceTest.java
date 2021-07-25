package br.com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.meli.obtenerdiploma.dto.CertificateDTO;
import br.com.meli.obtenerdiploma.dto.StudentDTO;
import br.com.meli.obtenerdiploma.dto.SubjectDTO;
import br.com.meli.obtenerdiploma.exceptions.ApiExceptionControllerAdvice;


@SpringBootTest
class CertificateServiceTest {
	
	@Autowired
	CertificateServiceImpl service;
	
	@BeforeEach
	void setUp() throws Exception {
	}
	@Test
	void verificandoValorMedioDaNota() {
		List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
		SubjectDTO materia1 = new SubjectDTO("Matematica Aplicada", 10);
		SubjectDTO materia2 = new SubjectDTO("Fisica Quantica", 9);
		SubjectDTO materia3 = new SubjectDTO("Algebra Especilizada", 8);
		subjects.add(materia1);
		subjects.add(materia2);
		subjects.add(materia3);
		StudentDTO student = new StudentDTO("Jonathan CP", subjects);
		
		double result = service.calculateAverage(student);
		
		assertEquals(9, result);
	
	}
	
	
	@Test
	void verificandoParabenizacaoParaMediaAlta() {
		List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
		SubjectDTO materia1 = new SubjectDTO("Matematica Aplicada", 10);
		SubjectDTO materia2 = new SubjectDTO("Fisica Quantica", 10);
		SubjectDTO materia3 = new SubjectDTO("Algebra Especilizada", 10);
		subjects.add(materia1);
		subjects.add(materia2);
		subjects.add(materia3);
		StudentDTO student = new StudentDTO("Jonathan CP", subjects);
		
		CertificateDTO response = new CertificateDTO(student);
		response.setAverage(service.calculateAverage(student));
		response.setMessage(service.writeDiploma(student));
		
		
		assertTrue(response.getMessage().contains("Parabéns"));
		
	}
	
	@Test
	void verificandoNomeStudent() throws Exception {
		List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
		SubjectDTO materia1 = new SubjectDTO("Matematica Aplicada", 10);
		SubjectDTO materia2 = new SubjectDTO("Fisica Quantica", 10);
		SubjectDTO materia3 = new SubjectDTO("Algebra Especilizada", 10);
		subjects.add(materia1);
		subjects.add(materia2);
		subjects.add(materia3);
		StudentDTO student = new StudentDTO("Jonathan", subjects);
		
		assertEquals("Jonathan", student.getName());
	
	}
	
	@Test
	void verificandoNota() throws Exception {
		List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
		SubjectDTO materia1 = new SubjectDTO("Matematica Aplicada", 10);
		SubjectDTO materia2 = new SubjectDTO("Fisica Quantica", 9);
		SubjectDTO materia3 = new SubjectDTO("Algebra Especilizada", 8);
		subjects.add(materia1);
		subjects.add(materia2);
		subjects.add(materia3);
		StudentDTO student = new StudentDTO("Jonathan", subjects);
		
		assertEquals(10, materia1.getNote());
	
	}


}
