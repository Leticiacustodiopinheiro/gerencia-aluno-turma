package br.com.api.gerencia.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import br.com.api.gerencia.model.Aluno;

public class AlunoDTO {
	private Long id;
	@NotEmpty
	@Size(min = 3, max = 100, message = "Verifique o nome do aluno.")
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

	public static AlunoDTO convert(Aluno aluno) {
		AlunoDTO alunoDto = new AlunoDTO();
		alunoDto.setId(aluno.getId());
		alunoDto.setNome(aluno.getNome());
		alunoDto.setStatus(aluno.isStatus());
		return alunoDto;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
