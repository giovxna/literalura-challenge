package giovxna.literalura.service;

import giovxna.literalura.dto.LivroDTO;
import giovxna.literalura.model.Autor;
import giovxna.literalura.model.Livro;
import giovxna.literalura.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> findByAutorId(Long autorId) {
        return livroRepository.findByAutoresId(autorId);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    public List<Livro> listarPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }

    public List<Livro> buscarPorAutor(Long idAutor) {
        return livroRepository.findByAutoresId(idAutor);
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

    public Livro converterDtoParaLivro(LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setTitulo(livroDTO.getTitle());
        livro.setIdioma(String.join(", ", livroDTO.getLanguages()));

        List<Autor> autores = livroDTO.getAuthors().stream()
                .map(dto -> {
                    Autor autor = new Autor();
                    autor.setNome(dto.getName());
                    return autor;
                })
                .collect(Collectors.toList());

        livro.setAutores(autores);

        return livro;
    }
}
