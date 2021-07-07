package br.com.meli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.entity.Categoria;
import br.com.meli.entity.Pedido;
import br.com.meli.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Pedido>> GetAll(){
		return ResponseEntity.ok(pedidoRepository.findAll());
	} 
	/*
	 * @GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	 */
	
	@PostMapping
	public ResponseEntity<Pedido> post (@RequestBody Pedido pedido){
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
	}

}
