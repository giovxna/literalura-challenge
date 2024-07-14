package giovxna.literalura.repository;

import giovxna.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByAnoNascimento(int anoNascimento);
    List<Autor> findByNomeContaining(String nome);
}
