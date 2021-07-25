package br.com.meli.obtenerdiploma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.obtenerdiploma.dto.CertificateDTO;
import br.com.meli.obtenerdiploma.dto.StudentDTO;
import br.com.meli.obtenerdiploma.service.CertificateService;

import javax.validation.Valid;

@RestController
public class AnalyzeNotesRestController {
  private final CertificateService certificateService;

  public AnalyzeNotesRestController(CertificateService certificateService) {
    this.certificateService = certificateService;
  }

  @PostMapping("/analyzeNotes")
  public ResponseEntity<CertificateDTO> analyzeNotes(@Valid @RequestBody StudentDTO notes){
    
	  return ResponseEntity.status(HttpStatus.CREATED).body(certificateService.analyzeNotes(notes));
  }
}
