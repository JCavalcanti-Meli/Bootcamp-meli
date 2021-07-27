package br.mongo.meli.consultorio.controller;

import br.mongo.meli.consultorio.entities.Doctor;
import br.mongo.meli.consultorio.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping
    public ResponseEntity<List<Doctor>> findAllDoctor (){

        return ResponseEntity.status(HttpStatus.OK).body(doctorRepository.findAll());

    }
}
