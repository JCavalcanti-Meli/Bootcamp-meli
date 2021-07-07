package br.com.meli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.entity.Categoria;
import br.com.meli.entity.Produto;
import br.com.meli.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	

	@Autowired
	private CategoriaRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
		
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
		if (categoria.isUsuario()==true) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
		}  
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
		if (categoria.isUsuario()==true) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
		}  
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		categoriaRepository.deleteById(id);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		
		
		return categoriaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	

}
