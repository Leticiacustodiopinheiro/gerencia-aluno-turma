package br.com.api.gerencia.dto;

public class TurmasAlunoDTO {
	private Long idTurma;
	private String nomeTurma;

	public TurmasAlunoDTO(Long idTurma, String nomeTurma) {
		super();
		this.idTurma = idTurma;
		this.nomeTurma = nomeTurma;
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
}
