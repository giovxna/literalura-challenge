package giovxna.literalura.controller;

import giovxna.literalura.model.Autor;
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
        return autorService.listarTodosAutores();
    }

    @GetMapping("/nome/{nome}")
    public List<Autor> buscarPorNome(@PathVariable String nome) {
        return autorService.buscarPorNome(nome);
    }

    @GetMapping("/nacionalidade/{nacionalidade}")
    public List<Autor> buscarPorNacionalidade(@PathVariable String nacionalidade) {
        return autorService.buscarPorNacionalidade(nacionalidade);
    }

    @GetMapping("/ano-nascimento")
    public List<Autor> buscarPorPeriodoNascimento(@RequestParam("start") int startYear, @RequestParam("end") int endYear) {
        return autorService.buscarPorPeriodoNascimento(startYear, endYear);
    }
}