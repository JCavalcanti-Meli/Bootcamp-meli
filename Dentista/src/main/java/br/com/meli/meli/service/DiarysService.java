package br.com.meli.meli.service;

import br.com.meli.meli.entity.Dentists;
import br.com.meli.meli.entity.Diarys;
import br.com.meli.meli.entity.Turns;
import br.com.meli.meli.repository.DiarysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DiarysService {
    final
    DiarysRepository diarysRepository;

    @Autowired
    public DiarysService(DiarysRepository diarysRepository) {

        this.diarysRepository = diarysRepository;
    }

    public Diarys getByIdDiarys(Long id) {

        return diarysRepository.getById(id);
    }

    public List<Diarys> getAllDiarys() {

        return diarysRepository.findAll();
    }

    public Dentists getAllPatientsDiarys (Long id) {
        Diarys diarysList = diarysRepository.getById(id);
        Dentists dentistsList =  diarysList.getDentist();

        return dentistsList;
    }


}
