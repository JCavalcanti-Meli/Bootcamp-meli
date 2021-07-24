package br.com.meli.meli.repository;

import br.com.meli.meli.Enum.TurnStatusEnum;
import br.com.meli.meli.entity.Dentists;
import br.com.meli.meli.entity.Turns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnsRepository extends JpaRepository<Turns, Long> {

    List<Turns> findByDay (LocalDate day);

    List<Turns> findByTurnStatusId (Long id);

    List<Turns> findByTurnStatusName (TurnStatusEnum name);

}
