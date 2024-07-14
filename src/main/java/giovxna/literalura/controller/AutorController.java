package giovxna.literalura.controller;

import giovxna.literalura.model.Autor;
import giovxna.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public Iterable<Autor> listarTodosAutores() {
        return autorRepository.findAll();
    }

    @GetMapping("/nome/{nome}")
    public Iterable<Autor> buscarPorNome(@PathVariable String nome) {
        return autorRepository.findByNomeContaining(nome);
    }

    @GetMapping("/ano/{ano}")
    public Iterable<Autor> buscarPorAno(@PathVariable int ano) {
        return autorRepository.findByAnoNascimento(ano);
    }

    @PostMapping
    public Autor cadastrarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/{id}")
    public Autor atualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        autor.setId(id);
        return autorRepository.save(autor);
    }

    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Long id) {
        autorRepository.deleteById(id);
    }
}