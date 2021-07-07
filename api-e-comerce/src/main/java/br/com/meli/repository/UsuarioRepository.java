package br.com.meli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meli.entity.Produto;
import br.com.meli.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	

}
