package br.com.meli.obtenerdiploma.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SubjectDTO {

	@NotBlank(message = "Nome da matéria deve ser preenchido.")
	@Pattern(regexp="([A-Z|À-Ú])[ a-z|à-ú]*", message = "O nome da materia deve começar com uma letra maiúscula e/ou conter letras de A - Z.")
	@Size(min = 8, max = 50, message = "Nome da matéria deve conter mínimo de 8  e máximo de 50 caracteres.")
	private String subject;
	
	
	@Range(min = 0, max = 10, message = "Nota deve ser entre 0 e 10.")
	private Integer note;
	
	public SubjectDTO() {

	}
	
	public SubjectDTO(
			@NotBlank(message = "Nome da matéria deve ser preenchido.") @Size(min = 8, max = 50, message = "Nome da matéria deve conter mínimo de 8  e máximo de 50 caracteres.") String subject,
			@Range(min = 0, max = 10, message = "Nota deve ser entre 0 e 10.") Integer note) {
		this.subject = subject;
		this.note = note;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

}
