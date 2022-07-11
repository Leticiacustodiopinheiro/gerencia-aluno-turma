package br.com.api.gerencia.service;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.com.api.gerencia.dto.AlunoDTO;
import br.com.api.gerencia.dto.TurmaAlunoDTO;
import br.com.api.gerencia.dto.TurmasAlunoDTO;
import br.com.api.gerencia.model.Aluno;
import br.com.api.gerencia.model.Turma;
import br.com.api.gerencia.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private TurmaService turmaService;

	public AlunoDTO inserir(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno().convert(alunoDTO);
		aluno.setStatus(true);
		aluno = alunoRepository.save(aluno);
		if (aluno != null) {
			return AlunoDTO.convert(aluno);
		}
		return null;
	}

	public Aluno pesquisarNomeId(Long id) {
		Aluno aluno = alunoRepository.findById(id).get();
		if (aluno != null) {
			return aluno;
		}
		return null;
	}

	public AlunoDTO atualizar(AlunoDTO alunoDTO) {
		Aluno aluno = pesquisarNomeId(alunoDTO.getId());
		aluno.setNome(alunoDTO.getNome());
		aluno = alunoRepository.save(aluno);
		if (aluno != null) {
			return AlunoDTO.convert(aluno);
		}
		return null;
	}

	public void excluir(Long id) {
		Aluno aluno = pesquisarNomeId(id);
		aluno.setStatus(false);
		alunoRepository.save(aluno);
	}

	public List<AlunoDTO> listar() {
		List<Aluno> aluno = new ArrayList<Aluno>();
		alunoRepository.findAll().forEach(aluno::add);
		return aluno.stream().map(AlunoDTO::convert).collect(Collectors.toList());
	}

	public void inserir(TurmaAlunoDTO turmaAlunoDto) {
		Aluno aluno = pesquisarNomeId(turmaAlunoDto.getIdAluno());
		aluno.getTurmas().add(new Turma(turmaAlunoDto.getIdTurma()));
		alunoRepository.save(aluno);
	}

	public TurmaAlunoDTO excluir(TurmaAlunoDTO turmaAlunoDto) {
		Aluno aluno = pesquisarNomeId(turmaAlunoDto.getIdAluno());
		Turma turma = turmaService.pesquisarNomeId(turmaAlunoDto.getIdTurma());
		aluno.getTurmas().remove(turma);
		alunoRepository.save(aluno);
		return null;
	}

	public List<TurmasAlunoDTO> listarTurmas(Long id) {
		List<TurmasAlunoDTO> lista = new ArrayList<TurmasAlunoDTO>();
		Aluno aluno = pesquisarNomeId(id);
		aluno.getTurmas().stream().forEach(a -> {
			lista.add(new TurmasAlunoDTO(a.getId(), a.getNome()));
		});
		return lista;
	}

	public Page<AlunoDTO> listar(int pagina, int quantidade, String ordenacao) {
		Pageable paginacao = PageRequest.of(pagina, quantidade, Direction.ASC, ordenacao);
		Page<Aluno> alunos = alunoRepository.findAll(paginacao);
		Page<AlunoDTO> lista = alunos.map(a -> new AlunoDTO().convert(a));
		return lista;
	}
}