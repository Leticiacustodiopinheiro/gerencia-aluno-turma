package br.com.api.gerencia.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import br.com.api.gerencia.model.Turma;

public class TurmaDTO {
	private Long id;
	@NotEmpty
	@Size(min = 3, max = 100, message = "Verifique o nome da Turma.")
	private String nome;
	private boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static TurmaDTO convert(Turma turma) {
		TurmaDTO turmaDto = new TurmaDTO();
		turmaDto.setId(turma.getId());
		turmaDto.setNome(turma.getNome());
		turmaDto.setStatus(turma.isStatus());
		return turmaDto;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}