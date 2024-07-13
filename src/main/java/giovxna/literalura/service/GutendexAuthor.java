package giovxna.literalura.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GutendexAuthor {
    @JsonProperty("name")
    private String name;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("death_date")
    private String deathDate;
}