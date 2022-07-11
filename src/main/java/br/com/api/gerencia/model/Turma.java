package br.com.api.gerencia.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import br.com.api.gerencia.dto.TurmaDTO;

@Entity
@Table(name = "tbl_turma")
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long id;
	@Column(name = "nome_turma")
	private String nome;
	@Column(name = "status_turma")
	private boolean status;
	@ManyToMany(mappedBy = "turmas")
	private List<Aluno> turmas = new ArrayList<>();

	public Turma() {
		super();
	}

	public Turma(Long id) {
		super();
		this.id = id;
	}

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

	public List<Aluno> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Aluno> turmas) {
		this.turmas = turmas;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static Turma convert(TurmaDTO turmaDto) {
		Turma turma = new Turma();
		turma.setId(turmaDto.getId());
		turma.setNome(turmaDto.getNome());
		turma.setStatus(turmaDto.isStatus());
		return turma;
	}
}