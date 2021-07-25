package br.com.meli.obtenerdiploma.service;

import org.springframework.stereotype.Service;

import br.com.meli.obtenerdiploma.dto.CertificateDTO;
import br.com.meli.obtenerdiploma.dto.StudentDTO;
import br.com.meli.obtenerdiploma.dto.SubjectDTO;

@Service
public class CertificateServiceImpl implements CertificateService {

	//
	public CertificateDTO analyzeNotes(StudentDTO notes) {
		CertificateDTO response = new CertificateDTO(notes);
		response.setAverage(calculateAverage(notes));
		response.setMessage(writeDiploma(notes));
		return response;
	}
	
	//calculo da media
	public Double calculateAverage(StudentDTO average) {
		int sum = average.getSubjects().stream().mapToInt(SubjectDTO::getNote).sum();
		double result = sum / (int) average.getSubjects().size();
		
		return result;
	}
	
	//Imprimir Diploma
	public String writeDiploma(StudentDTO notes) {
		Double localAverage = calculateAverage(notes);
		String studentName = notes.getName();
		String message = "Diploma para " + studentName + " obteve média satisfatória de " + localAverage;
		if (localAverage > 9)
			message = withHonors(localAverage, studentName);
		return message;
	}
	
	//imprimir Felicitacoes para quem obteve média > 9
	public String withHonors(Double localAverage, String localStudent) {
		return "Parabéns " + localStudent + ", você está entre os melhores, com nota média de " + localAverage;
	}
}
