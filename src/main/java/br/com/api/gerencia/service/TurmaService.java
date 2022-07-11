package br.com.api.gerencia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.gerencia.dto.TurmaDTO;
import br.com.api.gerencia.model.Turma;
import br.com.api.gerencia.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	private TurmaRepository turmaRepository;

	public TurmaDTO inserir(TurmaDTO turmaDTO) {
		Turma turma = new Turma().convert(turmaDTO);
		turma.setStatus(true);
		turma = turmaRepository.save(turma);
		if (turma != null) {
			return TurmaDTO.convert(turma);
		}
		return null;
	}

	public Turma pesquisarNomeId(Long id) {
		Turma turma = turmaRepository.findById(id).get();
		if (turma != null) {
			return turma;
		}
		return null;
	}

	public TurmaDTO atualizar(TurmaDTO turmaDTO) {
		Turma turma = pesquisarNomeId(turmaDTO.getId());
		turma.setNome(turmaDTO.getNome());
		turma = turmaRepository.save(turma);
		if (turma != null) {
			return turmaDTO.convert(turma);
		}
		return null;
	}

	public void excluir(Long id) {
		Turma turma = pesquisarNomeId(id);
		turma.setStatus(false);
		turmaRepository.save(turma);
	}

	public List<TurmaDTO> listar() {
		List<Turma> turma = new ArrayList<Turma>();
		turmaRepository.findAll().forEach(turma::add);
		return turma.stream().map(TurmaDTO::convert).collect(Collectors.toList());
	}
}