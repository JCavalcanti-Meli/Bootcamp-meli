package br.mongo.meli.consultorio.controller;

import br.mongo.meli.consultorio.entities.Consulta;
import br.mongo.meli.consultorio.entities.Patient;
import br.mongo.meli.consultorio.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping
    public ResponseEntity<List<Patient>> findAllPatient (){

        return ResponseEntity.status(HttpStatus.OK).body(patientRepository.findAll());

    }
}
