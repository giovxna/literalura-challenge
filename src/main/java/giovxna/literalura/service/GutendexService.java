package giovxna.literalura.service;

import giovxna.literalura.dto.LivroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexService {

    @Autowired
    private RestTemplate restTemplate;

    public LivroDTO buscarLivroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo;
        ResponseEntity<GutendexResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<GutendexResponse>() {}
        );
        if (response.getBody() != null && !response.getBody().getResults().isEmpty()) {
            return response.getBody().getResults().get(0);
        } else {
            throw new RuntimeException("Livro não encontrado");
        }
    }
}
