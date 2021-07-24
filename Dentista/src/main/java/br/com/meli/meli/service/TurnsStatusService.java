package br.com.meli.meli.service;

import br.com.meli.meli.entity.Turn_status;
import br.com.meli.meli.entity.Turns;
import br.com.meli.meli.repository.TurnsRepository;
import br.com.meli.meli.repository.TurnsStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnsStatusService {

    final
    TurnsStatusRepository turnsStatusRepository;

    @Autowired
    public TurnsStatusService(TurnsStatusRepository turnsStatusRepository) {
        this.turnsStatusRepository = turnsStatusRepository;
    }

    public Turn_status getByIdTurnsStatus(Long id) {
        return turnsStatusRepository.getById(id);
    }

    public List<Turn_status> getAllTurnsStatus() {

        return turnsStatusRepository.findAll();
    }
}
