package com.example.demo;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class CalculadoraIdade {
	
		@GetMapping
		@RequestMapping("/{1}/{2}/{3}")
		public Integer ponto2 (@PathVariable("1") int dia,@PathVariable("2")  int mes, @PathVariable("3")  int ano ) {
			
			int idade=0;
			
			LocalDate data = LocalDate.now();
			
			if (mes>=data.getMonthValue() && dia>data.getDayOfMonth()) {
				idade = (data.getYear()-ano)-1;
			} else {
				idade = (data.getYear()-ano);
			}
			
			return idade;
			
		}


	
	
	
}
