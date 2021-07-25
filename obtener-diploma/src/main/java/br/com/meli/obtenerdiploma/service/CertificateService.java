package br.com.meli.obtenerdiploma.service;

import br.com.meli.obtenerdiploma.dto.CertificateDTO;
import br.com.meli.obtenerdiploma.dto.StudentDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);
}

