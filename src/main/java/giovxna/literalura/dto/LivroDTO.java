package giovxna.literalura.dto;

import giovxna.literalura.service.GutendexAuthor;
import lombok.Data;
import java.util.List;

@Data
public class LivroDTO {
    private String title;
    private List<String> languages;
    private List<GutendexAuthor> authors;
}
