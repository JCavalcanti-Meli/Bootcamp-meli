package br.com.meli.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

public class StudentDTO {

    @NotBlank(message = "Preencher o Nome.")
    @Size(min = 8, max = 50, message = "Nome deve conter mínimo de 8  e máximo de 50 caracteres.")
    @Pattern(regexp="([A-Z|À-Ú])[ a-z|à-ú]*", message = "O nome deve começar com uma letra maiúscula e/ou conter letras de A - Z.")
    private String name;

    @Valid
    @NotEmpty(message = "Cadastrar mínimo de uma matéria por Aluno")
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }
    
    

    public StudentDTO(
			@NotBlank(message = "Preencher o Nome.") @Size(min = 8, max = 50, message = "Nome deve conter mínimo de 8  e máximo de 50 caracteres.") String name,
			@Valid @NotEmpty(message = "Cadastrar mínimo de uma matéria por Aluno") List<SubjectDTO> subjects) {
		this.name = name;
		this.subjects = subjects;
	}



	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

}
