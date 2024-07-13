package giovxna.literalura.repository;

import giovxna.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNomeContaining(String nome);
    List<Autor> findByNacionalidade(String nacionalidade);
    List<Autor> findByAnoNascimentoBetween(int startYear, int endYear);
    Iterable<Autor> findByAno(int ano);
}