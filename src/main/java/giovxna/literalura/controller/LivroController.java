package giovxna.literalura.controller;

import giovxna.literalura.model.Livro;
import giovxna.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarTodosLivros() {
        return livroService.listarTodosLivros();
    }

    @GetMapping("/titulo/{titulo}")
    public List<Livro> buscarPorTitulo(@PathVariable String titulo) {
        return livroService.buscarPorTitulo(titulo);
    }

    @GetMapping("/genero/{genero}")
    public List<Livro> buscarPorGenero(@PathVariable String genero) {
        return livroService.buscarPorGenero(genero);
    }

    @GetMapping("/editora/{editora}")
    public List<Livro> buscarPorEditora(@PathVariable String editora) {
        return livroService.buscarPorEditora(editora);
    }

    @GetMapping("/data-publicacao")
    public List<Livro> buscarPorPeriodo(@RequestParam("start") String startDate, @RequestParam("end") String endDate) {
        return livroService.buscarPorPeriodo(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}