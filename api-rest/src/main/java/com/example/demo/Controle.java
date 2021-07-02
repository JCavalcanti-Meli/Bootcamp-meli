package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AnuncioDTO;
import com.example.demo.entity.anuncio;

//@Controller
@RestController
@RequestMapping("/controller")
public class Controle {
	
	@RequestMapping("/point1/{x}")
	//@ResponseBody
	public String endPoint1(@PathVariable String x) {
			
		String numRomano="x";
		int num = 0;
		
		return numRomano+num;
	}
		
		
		@GetMapping
		@RequestMapping("/ponto2/{1}/{2}/{3}")
		public String ponto2 (@PathVariable("1") String parametro1,@PathVariable("2")  String parametro2, @PathVariable("3")  String parametro3 ) {
			
			return "Parametros reebidos"+parametro1+parametro2+parametro3;
			
		}
		
		@GetMapping
		@RequestMapping("/Anuncio")
		public anuncio ponto2 ( ) {
			anuncio anuncio = new anuncio (1, "MLB177", "PS5");
			
			return anuncio;
			
		}
		
		@PostMapping
		public void cadastrarAnuncio ( @RequestBody AnuncioDTO anuncio) {
			System.out.println("chegou"+ anuncio.getCodigo()+ " : "+ anuncio.getDescricao());
			
			
			
			
		}
		
		
	
		
		
	}
	
	
	


