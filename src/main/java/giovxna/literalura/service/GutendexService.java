package giovxna.literalura.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexService {
    private final RestTemplate restTemplate = new RestTemplate();

    public GutendexBook buscarLivroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo;
        try {
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
        } catch (RestClientException e) {
            throw new RuntimeException("Erro ao buscar livro: " + e.getMessage(), e);
        }
    }
}
