package br.com.api.gerencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.api.gerencia.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}