package br.com.meli.meli.service;

import br.com.meli.meli.entity.Patients;
import br.com.meli.meli.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PatientsService {

    final
    PatientsRepository patientsRepository;

    @Autowired
    public PatientsService(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }


    public Patients getById(Long id) {
        return patientsRepository.getById(id);
    }

    public List<Patients> getAllPatients() {

        return patientsRepository.findAll();
    }

}
