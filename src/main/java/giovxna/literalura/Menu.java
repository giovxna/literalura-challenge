package giovxna.literalura;

import giovxna.literalura.model.Autor;
import giovxna.literalura.model.Livro;
import giovxna.literalura.repository.AutorRepository;
import giovxna.literalura.repository.LivroRepository;
import giovxna.literalura.service.GutendexBook;
import giovxna.literalura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private GutendexService gutendexService;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Buscar livro pelo título");
            System.out.println("2. Listar livros registrados");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores em determinado ano");
            System.out.println("5. Listar livros em determinado idioma");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPorTitulo(scanner);
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresPorAno(scanner);
                    break;
                case 5:
                    listarLivrosPorIdioma(scanner);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void buscarLivroPorTitulo(Scanner scanner) {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        try {
            GutendexBook livroDTO = gutendexService.buscarLivroPorTitulo(titulo);
            Livro livro = converterParaLivro(livroDTO);
            livroRepository.save(livro);
            System.out.println("Livro encontrado e salvo: " + livro.getTitulo());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private Livro converterParaLivro(GutendexBook livroDTO) {
        Livro livro = new Livro();
        livro.setTitulo(livroDTO.getTitle());

        return livro;
    }

    private void listarLivrosRegistrados() {
        Iterable<Livro> livros = livroRepository.findAll();
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    private void listarAutores() {
        Iterable<Autor> autores = autorRepository.findAll();
        for (Autor autor : autores) {
            System.out.println(autor);
        }
    }

    private void listarAutoresPorAno(Scanner scanner) {
        System.out.println("Digite o ano:");
        int ano = scanner.nextInt();
        Iterable<Autor> autores = autorRepository.findByAnoNascimento(ano);
        for (Autor autor : autores) {
            System.out.println(autor);
        }
    }

    private void listarLivrosPorIdioma(Scanner scanner) {
        System.out.println("Digite o idioma (PT, EN, ES, FR):");
        String idioma = scanner.nextLine();
        Iterable<Livro> livros = livroRepository.findByIdioma(idioma);
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}