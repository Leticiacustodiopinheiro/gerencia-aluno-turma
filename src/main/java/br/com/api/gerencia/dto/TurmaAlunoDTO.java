package br.com.api.gerencia.dto;

import javax.validation.constraints.NotNull;

public class TurmaAlunoDTO {
	@NotNull
	private Long idTurma;
	@NotNull
	private Long idAluno;

	public static TurmaAlunoDTO convert(Long idTurma, Long idAluno) {
		TurmaAlunoDTO turmaAlunoDto = new TurmaAlunoDTO();
		turmaAlunoDto.setIdAluno(idAluno);
		turmaAlunoDto.setIdTurma(idTurma);
		return turmaAlunoDto;
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}
}