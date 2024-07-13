package giovxna.literalura.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GutendexBook {
    @JsonProperty("title")
    private String title;

    @JsonProperty("languages")
    private List<String> languages;

    @JsonProperty("download_count")
    private int downloadCount;

    @JsonProperty("authors")
    private List<GutendexAuthor> authors;
}