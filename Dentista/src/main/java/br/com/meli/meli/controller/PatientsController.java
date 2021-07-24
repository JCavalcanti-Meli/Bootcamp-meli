package br.com.meli.meli.controller;

import br.com.meli.meli.entity.Patients;
import br.com.meli.meli.repository.PatientsRepository;
import br.com.meli.meli.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    final
    PatientsService patientsService;
    @Autowired
    public PatientsController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }

    @GetMapping
    public ResponseEntity<List<Patients> >getAllPatients() {
        return new ResponseEntity<>(this.patientsService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patients> getById (@PathVariable Long id) {
        return new ResponseEntity<>(this.patientsService.getById(id), HttpStatus.OK);
    }
}
