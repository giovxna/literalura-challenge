package giovxna.literalura.service;

import giovxna.literalura.model.Autor;
import giovxna.literalura.model.Livro;
import giovxna.literalura.repository.AutorRepository;
import giovxna.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GutendexService {

    @Autowired
    private LivroRepository livroRepository;

    private static final String API_URL = "http://gutendex.com/books?search=";

    public Livro buscarLivroPorTitulo(String titulo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + titulo;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);

        if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
            Livro livro = mapToLivro(response.getResults().get(0));
            livroRepository.save(livro);
            return livro;
        } else {
            throw new RuntimeException("Livro não encontrado na API");
        }
    }
    private Livro mapToLivro(GutendexBook gutendexBook) {
        Livro livro = new Livro();
        livro.setTitulo(gutendexBook.getTitle());
        livro.setIdioma(gutendexBook.getLanguages().get(0)); // Pegando o primeiro idioma da lista
        livro.setDownloads(gutendexBook.getDownloadCount());
        if (!gutendexBook.getAuthors().isEmpty()) {
            Autor autor = mapToAutor(gutendexBook.getAuthors().get(0)); // Pegando o primeiro autor da lista
            livro.setAutor(autor);
        }
        return livro;
    }

    private Autor mapToAutor(GutendexAuthor gutendexAuthor) {
        Autor autor = new Autor();
        autor.setNome(gutendexAuthor.getName());

        if (gutendexAuthor.getBirthDate() != null && !gutendexAuthor.getBirthDate().isEmpty()) {
            try {
                autor.setAnoNascimento(Integer.parseInt(gutendexAuthor.getBirthDate().split("-")[0])); // Pegando apenas o ano
            } catch (NumberFormatException e) {
                // Lidar com formato inesperado da data de nascimento
                autor.setAnoNascimento(0); // ou qualquer outro valor padrão/indicativo
            }
        }

        if (gutendexAuthor.getDeathDate() != null && !gutendexAuthor.getDeathDate().isEmpty()) {
            try {
                autor.setAnoFalecimento(Integer.parseInt(gutendexAuthor.getDeathDate().split("-")[0])); // Pegando apenas o ano
            } catch (NumberFormatException e) {
                // Lidar com formato inesperado da data de falecimento
                autor.setAnoFalecimento(0); // ou qualquer outro valor padrão/indicativo
            }
        }

        return autor;
    }
}