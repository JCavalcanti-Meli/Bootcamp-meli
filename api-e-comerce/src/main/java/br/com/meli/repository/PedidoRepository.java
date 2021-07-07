package br.com.meli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meli.entity.Pedido;



public interface PedidoRepository extends JpaRepository<Pedido, Long>  {

}
