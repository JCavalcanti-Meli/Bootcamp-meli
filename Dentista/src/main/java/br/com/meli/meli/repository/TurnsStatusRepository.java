package br.com.meli.meli.repository;

import br.com.meli.meli.entity.Dentists;
import br.com.meli.meli.entity.Turn_status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnsStatusRepository extends JpaRepository<Turn_status, Long> {
}
