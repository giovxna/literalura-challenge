package giovxna.literalura.repository;

import giovxna.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContaining(String titulo);
    List<Livro> findByGenero(String genero);
    List<Livro> findByEditora(String editora);
    List<Livro> findByDataPublicacaoBetween(LocalDate startDate, LocalDate endDate);
    Iterable<Livro> findByIdioma(String idioma);
}