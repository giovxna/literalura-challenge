package giovxna.literalura.service;

import giovxna.literalura.model.Livro;
import giovxna.literalura.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    public List<Livro> listarPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }

    public List<Livro> buscarPorAutor(Long idAutor) {
        return livroRepository.findByAutorId(idAutor);
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizar(Long id, Livro livro) {
        if (livroRepository.existsById(id)) {
            livro.setId(id);
            return livroRepository.save(livro);
        } else {
            throw new EntityNotFoundException("Livro não encontrado");
        }
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}

