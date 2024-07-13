package giovxna.literalura.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class GutendexResponse {
    @JsonProperty("results")
    private List<GutendexBook> results;

    public List<GutendexBook> getResults() {
        return results;
    }

    public void setResults(List<GutendexBook> results) {
        this.results = results;
    }
}
