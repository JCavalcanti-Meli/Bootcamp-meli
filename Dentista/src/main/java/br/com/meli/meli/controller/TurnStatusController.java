package br.com.meli.meli.controller;

import br.com.meli.meli.entity.Turn_status;
import br.com.meli.meli.entity.Turns;
import br.com.meli.meli.service.TurnsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turnStatus")
public class TurnStatusController {

    final
    TurnsStatusService turnsStatusService;

    @Autowired
    public TurnStatusController(TurnsStatusService turnsStatusService) {
        this.turnsStatusService = turnsStatusService;
    }

    @GetMapping
    public ResponseEntity<List<Turn_status>> getAllTurns() {
        return new ResponseEntity<>(this.turnsStatusService.getAllTurnsStatus(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turn_status> getByIdTurns (@PathVariable Long id) {
        return new ResponseEntity<>(this.turnsStatusService.getByIdTurnsStatus(id), HttpStatus.OK);
    }
}
