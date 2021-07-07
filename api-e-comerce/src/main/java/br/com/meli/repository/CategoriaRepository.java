package br.com.meli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meli.entity.Categoria;
import br.com.meli.entity.Produto;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

	List<Categoria> findByProduto (long id);

	
}
