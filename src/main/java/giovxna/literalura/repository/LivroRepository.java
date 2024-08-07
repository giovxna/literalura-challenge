package giovxna.literalura.repository;

import giovxna.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContaining(String titulo);
    List<Livro> findByIdioma(String idioma);
    List<Livro> findByAutoresId(Long autorId);
}
