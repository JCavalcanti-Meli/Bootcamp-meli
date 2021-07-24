package br.com.meli.meli.service;

import br.com.meli.meli.Enum.TurnStatusEnum;
import br.com.meli.meli.entity.Dentists;
import br.com.meli.meli.entity.Patients;
import br.com.meli.meli.entity.Turns;
import br.com.meli.meli.repository.PatientsRepository;
import br.com.meli.meli.repository.TurnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnsService {

    final
    TurnsRepository turnsRepository;

    @Autowired
    public TurnsService(TurnsRepository turnsRepository) {
        this.turnsRepository = turnsRepository;
    }

    public Turns getByIdTurns(Long id) {
        return turnsRepository.getById(id);
    }

    public List<Turns> getAllTurns() {

        return turnsRepository.findAll();
    }

    public List<Turns> buscaDay (LocalDate day){
        List<Turns> list = turnsRepository.findByDay(day);

        return list;
    }

    public List<Turns> buscaStatus (Long status){
        List<Turns> list = turnsRepository.findByTurnStatusId(status);

        return list;
    }

    public List<Turns> buscaStatusName (TurnStatusEnum name){
        List<Turns> list = turnsRepository.findByTurnStatusName(name);

        return list;
    }




}
