package giovxna.literalura.controller;

import giovxna.literalura.model.Livro;
import giovxna.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarTodosLivros() {
        return livroService.listarTodos();
    }

    @GetMapping("/titulo/{titulo}")
    public List<Livro> buscarPorTitulo(@PathVariable String titulo) {
        return livroService.buscarPorTitulo(titulo);
    }

    @GetMapping("/idioma/{idioma}")
    public List<Livro> buscarPorIdioma(@PathVariable String idioma) {
        return livroService.listarPorIdioma(idioma);
    }

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        return livroService.atualizar(id, livro);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletar(id);
    }
}
