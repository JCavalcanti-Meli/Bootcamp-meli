package br.com.meli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.meli.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>  {

	//@Query(value = "select * from produto where categoria_id = 2", nativeQuery = true)
	//List<Produto> findAllCategoria();


}
