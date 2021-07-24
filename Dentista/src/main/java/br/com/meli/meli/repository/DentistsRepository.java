package br.com.meli.meli.repository;

import br.com.meli.meli.entity.Dentists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DentistsRepository extends JpaRepository<Dentists, Long> {

    List<Dentists> findByDiarysDentistId (Long id);
}

