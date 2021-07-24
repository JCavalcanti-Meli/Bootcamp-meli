package br.com.meli.meli.controller;

import br.com.meli.meli.entity.Dentists;
import br.com.meli.meli.repository.DentistsRepository;
import br.com.meli.meli.service.DentistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistsController {
    final
    DentistsRepository dentistsRepository;

    final
    DentistsService dentistsService;

    @Autowired
    public DentistsController(DentistsRepository dentistsRepository, DentistsService dentistsService) {
        this.dentistsRepository = dentistsRepository;
        this.dentistsService = dentistsService;
    }

    @GetMapping
    public ResponseEntity<List<Dentists>> getAllPatients() {
        return new ResponseEntity<>(this.dentistsService.getAllDentists(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentists> getById (@PathVariable Long id) {
        return new ResponseEntity<>(this.dentistsService.getByIdDentists(id), HttpStatus.OK);
    }

    @GetMapping("/agenda")
    public ResponseEntity<List<Dentists>> getByIdTurnsStatusById (@RequestParam("agenda")  Long agenda) {
        return new ResponseEntity<>(this.dentistsService.buscaAgenda(agenda), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dentists> createDentists (@RequestBody Dentists dentists) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dentistsRepository.save(dentists));
    }

    // UPDATE --> PUT
    @PutMapping("/{id}")
    public ResponseEntity<Dentists> updateDentists (@PathVariable Long id, @RequestBody Dentists dentists) {
        dentists.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(dentistsRepository.save(dentists));
    }

    // DELETE --> DELETE
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        dentistsRepository.deleteById(id);
    }


}
