package br.com.meli.meli.controller;

import br.com.meli.meli.Enum.TurnStatusEnum;
import br.com.meli.meli.entity.Patients;
import br.com.meli.meli.entity.Turns;
import br.com.meli.meli.service.TurnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turns")
public class TurnsController {

    final
    TurnsService turnsService;

    @Autowired
    public TurnsController(TurnsService turnsService) {
        this.turnsService = turnsService;
    }

    @GetMapping
    public ResponseEntity<List<Turns>> getAllTurns() {
        return new ResponseEntity<>(this.turnsService.getAllTurns(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turns> getByIdTurns (@PathVariable Long id) {
        return new ResponseEntity<>(this.turnsService.getByIdTurns(id), HttpStatus.OK);
    }

    @GetMapping("/day")
    public ResponseEntity<List<Turns>> getByIdTurnsDay (@RequestParam("day")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day) {
        return new ResponseEntity<>(this.turnsService.buscaDay(day), HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Turns>> getByIdTurnsStatusById (@RequestParam("status")  Long status) {
        return new ResponseEntity<>(this.turnsService.buscaStatus(status), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Turns>> getByIdTurnsStatusByName (@RequestParam("name") TurnStatusEnum name) {
        return new ResponseEntity<>(this.turnsService.buscaStatusName(name), HttpStatus.OK);
    }


}
