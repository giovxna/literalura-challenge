package giovxna.literalura.controller;

import giovxna.literalura.model.Livro;
import giovxna.literalura.repository.LivroRepository;
import giovxna.literalura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private GutendexService gutendexService;

    @GetMapping
    public Iterable<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    @GetMapping("/titulo/{titulo}")
    public Iterable<Livro> buscarPorTitulo(@PathVariable String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    @GetMapping("/idioma/{idioma}")
    public Iterable<Livro> buscarPorIdioma(@PathVariable String idioma) {
        return livroRepository.findByIdioma(idioma);
    }

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        return livroRepository.save(livro);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
    }
}