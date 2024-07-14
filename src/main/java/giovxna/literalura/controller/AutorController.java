package giovxna.literalura.controller;

import giovxna.literalura.model.Autor;
import giovxna.literalura.repository.AutorRepository;
import giovxna.literalura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listarTodosAutores() {
        return autorService.listarTodos();
    }

    @GetMapping("/nome/{nome}")
    public List<Autor> buscarPorNome(@PathVariable String nome) {
        return autorService.buscarPorNome(nome);
    }

    @GetMapping("/ano/{ano}")
    public List<Autor> buscarPorAno(@PathVariable int ano) {
        return autorService.listarPorAnoNascimento(ano);
    }

    @PostMapping
    public Autor cadastrarAutor(@RequestBody Autor autor) {
        return autorService.salvar(autor);
    }

    @PutMapping("/{id}")
    public Autor atualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        return autorService.atualizar(id, autor);
    }

    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Long id) {
        autorService.deletar(id);
    }
}
