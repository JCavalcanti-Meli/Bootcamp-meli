package br.com.meli.meli.repository;

import br.com.meli.meli.entity.Dentists;
import br.com.meli.meli.entity.Diarys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiarysRepository extends JpaRepository<Diarys, Long> {

}
