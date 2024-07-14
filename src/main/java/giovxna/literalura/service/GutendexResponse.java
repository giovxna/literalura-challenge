package giovxna.literalura.service;

import giovxna.literalura.dto.LivroDTO;
import lombok.*;

import java.util.List;

@Data
public class GutendexResponse {
    private List<LivroDTO> results;
}
