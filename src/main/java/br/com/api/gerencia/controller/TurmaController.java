package br.com.api.gerencia.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.api.gerencia.dto.TurmaDTO;
import br.com.api.gerencia.service.TurmaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TurmaController {
	@Autowired
	private TurmaService turmaService;

	@PostMapping("/inserir-turma")
	public ResponseEntity<TurmaDTO> inserirturma(@RequestBody @Valid TurmaDTO turmaDTO,
			UriComponentsBuilder uriBuilder) {
		TurmaDTO dto = turmaService.inserir(turmaDTO);
		URI uri = uriBuilder.path("turma/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("/atualizar-turma")
	public ResponseEntity<TurmaDTO> atualizarturma(@RequestBody @Valid TurmaDTO turmaDTO) {
		TurmaDTO dto = turmaService.atualizar(turmaDTO);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("/excluir-turma/{id}")
	public ResponseEntity atualizarturma(@PathVariable("id") Long id) {
		turmaService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/listar-turma")
	public ResponseEntity<List<TurmaDTO>> listarturma() {
		List<TurmaDTO> listadto = turmaService.listar();
		return ResponseEntity.ok(listadto);
	}
}