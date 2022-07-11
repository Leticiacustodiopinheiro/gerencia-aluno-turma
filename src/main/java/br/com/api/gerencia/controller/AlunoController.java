package br.com.api.gerencia.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.gerencia.dto.AlunoDTO;
import br.com.api.gerencia.dto.TurmaAlunoDTO;
import br.com.api.gerencia.dto.TurmasAlunoDTO;
import br.com.api.gerencia.service.AlunoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AlunoController {
	@Autowired
	private AlunoService alunoService;

	@PostMapping("/inserir-aluno")
	public ResponseEntity<AlunoDTO> inserir(@RequestBody @Valid AlunoDTO alunoDTO, UriComponentsBuilder uriBuilder) {
		AlunoDTO dto = alunoService.inserir(alunoDTO);
		URI uri = uriBuilder.path("aluno/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("/atualizar-aluno")
	public ResponseEntity<AlunoDTO> atualizar(@RequestBody @Valid AlunoDTO alunoDTO) {
		AlunoDTO dto = alunoService.atualizar(alunoDTO);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("/excluir-aluno/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id) {
		alunoService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/listar-aluno")
	public ResponseEntity<List<AlunoDTO>> listar() {
		List<AlunoDTO> listadto = alunoService.listar();
		return ResponseEntity.ok(listadto);
	}

	@PostMapping("/inserir-aluno-turma")
	public ResponseEntity inserirAlunoTurma(@RequestBody @Valid TurmaAlunoDTO turmaAlunoDto) {
		alunoService.inserir(turmaAlunoDto);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/excluir-aluno-turma")
	public ResponseEntity excluirAlunoTurma(@RequestBody @Valid TurmaAlunoDTO turmaAlunoDto) {
		alunoService.excluir(turmaAlunoDto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/listar-aluno-turma/{id}")
	public ResponseEntity<List<TurmasAlunoDTO>> listarTurmas(@PathVariable("id") Long id) {
		List<TurmasAlunoDTO> lista = alunoService.listarTurmas(id);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listar-aluno-paginacao/{pag}/{qtde}/{ordenacao}")
	public Page<AlunoDTO> listarPaginacao(@PathVariable("pag") int pag, @PathVariable("qtde") int qtde,
			@PathVariable("ordenacao") String ordenacao) {
		Page<AlunoDTO> listadto = alunoService.listar(pag, qtde, ordenacao);
		return listadto;
	}
}