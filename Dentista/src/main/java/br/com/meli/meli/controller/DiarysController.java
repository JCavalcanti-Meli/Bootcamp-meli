package br.com.meli.meli.controller;

import br.com.meli.meli.entity.Dentists;
import br.com.meli.meli.entity.Diarys;
import br.com.meli.meli.entity.Patients;
import br.com.meli.meli.repository.DiarysRepository;
import br.com.meli.meli.service.DiarysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diarys")
public class DiarysController {
    final
    DiarysService diarysService;

    @Autowired
    public DiarysController(DiarysService diarysService) {
        this.diarysService = diarysService;
    }

    @GetMapping
    public ResponseEntity<List<Diarys>> getAllPatients() {
        return new ResponseEntity<>(this.diarysService.getAllDiarys(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diarys> getById (@PathVariable Long id) {
        return new ResponseEntity<>(this.diarysService.getByIdDiarys(id), HttpStatus.OK);
    }

    @GetMapping("patients/{id}")
    public ResponseEntity<Dentists> getByDentistasDiarias (@PathVariable Long id) {
        return new ResponseEntity<>(this.diarysService.getAllPatientsDiarys(id), HttpStatus.OK);
    }




}
