package giovxna.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorDTO {
    private Long id;
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;
    private String nacionalidade;
    private List<LivroDTO> livros;
}
