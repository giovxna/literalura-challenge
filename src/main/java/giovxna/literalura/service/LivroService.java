package giovxna.literalura.service;

import giovxna.literalura.model.Livro;
import giovxna.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    public List<Livro> buscarPorGenero(String genero) {
        return livroRepository.findByGenero(genero);
    }

    public List<Livro> buscarPorEditora(String editora) {
        return livroRepository.findByEditora(editora);
    }

    public List<Livro> buscarPorPeriodo(LocalDate startDate, LocalDate endDate) {
        return livroRepository.findByDataPublicacaoBetween(startDate, endDate);
    }
}
