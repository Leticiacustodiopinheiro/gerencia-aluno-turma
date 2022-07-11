package br.com.api.gerencia.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.api.gerencia.model.Aluno;
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    public Aluno findByNome(String nome);
}