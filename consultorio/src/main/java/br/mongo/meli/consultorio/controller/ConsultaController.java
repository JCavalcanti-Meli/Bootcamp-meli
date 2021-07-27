package br.mongo.meli.consultorio.controller;

import br.mongo.meli.consultorio.entities.Consulta;
import br.mongo.meli.consultorio.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/consult")
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;

    @PostMapping
    public ResponseEntity<Consulta> postConsult (@RequestBody Consulta consulta){

    return ResponseEntity.status(HttpStatus.CREATED).body(consultaRepository.save(consulta));

    }

    @GetMapping("/all")
    public ResponseEntity<List<Consulta>> findAllConsult (){
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.findAll());
    }

    @GetMapping("/doctor")
    public ResponseEntity<List<Consulta>> findAllConsultByDoctor (@PathParam(value="name") String name){
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.findByDoctorFirstName(name));
    }

    @GetMapping("/status")
    public ResponseEntity<List<Consulta>> findAllConsultByStatus (@PathParam(value="consult") String consult){
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.findByStatus(consult));
    }

}
