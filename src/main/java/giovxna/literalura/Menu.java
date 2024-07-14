package giovxna.literalura;

import giovxna.literalura.dto.LivroDTO;
import giovxna.literalura.model.Autor;
import giovxna.literalura.model.Livro;
import giovxna.literalura.service.AutorService;
import giovxna.literalura.service.GutendexService;
import giovxna.literalura.service.GutendexAuthor;
import giovxna.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Menu {

    @Autowired
    private GutendexService gutendexService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

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
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarLivroPorTitulo(Scanner scanner) {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        try {
            LivroDTO livroDTO = gutendexService.buscarLivroPorTitulo(titulo);
            Livro livro = livroService.converterDtoParaLivro(livroDTO);
            livroService.salvar(livro);

            System.out.println("Livro encontrado e salvo no banco de dados:");
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor(es): " + livro.getAutores().stream()
                    .map(Autor::getNome)
                    .collect(Collectors.joining(", ")));
            System.out.println("Idiomas: " + livro.getIdioma());
        } catch (Exception e) {
            System.out.println("Livro não encontrado.");
        }
    }

    private void listarLivrosRegistrados() {
        List<Livro> livros = livroService.listarTodos();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            livros.forEach(livro -> {
                System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo());
            });
        }
    }

    private void listarAutores() {
        List<Autor> autores = autorService.listarTodos();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            autores.forEach(autor -> {
                System.out.println("ID: " + autor.getId() + ", Nome: " + autor.getNome());
            });
        }
    }

    private void listarAutoresPorAno(Scanner scanner) {
        System.out.println("Digite o ano de nascimento:");
        int ano = scanner.nextInt();
        scanner.nextLine();
        List<Autor> autores = autorService.listarPorAnoNascimento(ano);
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado para o ano " + ano + ".");
        } else {
            autores.forEach(autor -> {
                System.out.println("ID: " + autor.getId() + ", Nome: " + autor.getNome());
            });
        }
    }

    private void listarLivrosPorIdioma(Scanner scanner) {
        System.out.println("Digite o idioma:");
        String idioma = scanner.nextLine();
        List<Livro> livros = livroService.listarPorIdioma(idioma);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o idioma " + idioma + ".");
        } else {
            livros.forEach(livro -> {
                System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo());
            });
        }
    }
}
