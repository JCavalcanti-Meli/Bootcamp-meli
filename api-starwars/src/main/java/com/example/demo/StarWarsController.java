package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/starwars")
public class StarWarsController {

	@Autowired
	StarWarsRepository starWarsRepository;
	
	@PostMapping
	public ResponseEntity<StarWarsModel> cadastrar (@RequestBody StarWarsModel starWarsModel) {
	
		return 	ResponseEntity.status(HttpStatus.CREATED).body(starWarsRepository.save(starWarsModel));
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<StarWarsModel> getById(@PathVariable String name){
		return starWarsRepository.findById(name).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		}
	
	@GetMapping
	@RequestMapping("/buscatodos")
	public List<StarWarsModel> buscarTodos(){
		return starWarsRepository.findAll();
	}
	
	
	@GetMapping
	@RequestMapping("/busca/{name}")
	public List<StarWarsModel> busca(@PathVariable String name){
		
		starWarsRepository.findByNameLikeIgnoreCase(name);
		
		return starWarsRepository.findByNameLikeIgnoreCase(name);
	}
	
	
}
