package br.com.meli.meli.service;

import br.com.meli.meli.entity.Dentists;
import br.com.meli.meli.entity.Turns;
import br.com.meli.meli.repository.DentistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistsService {

    final
    DentistsRepository dentistsRepository;

    @Autowired
    public DentistsService(DentistsRepository dentistsRepository) {

        this.dentistsRepository = dentistsRepository;
    }

    public Dentists getByIdDentists(Long id) {

        return dentistsRepository.getById(id);
    }

    public List<Dentists> getAllDentists() {

        return dentistsRepository.findAll();
    }

    public List<Dentists> buscaAgenda (Long agenda){
        List<Dentists> list = dentistsRepository.findByDiarysDentistId(agenda);

        return list;
    }

}
