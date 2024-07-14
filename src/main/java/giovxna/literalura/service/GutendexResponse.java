package giovxna.literalura.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GutendexResponse {
    private int count;
    private String next;
    private String previous;
    private List<GutendexBook> results;
}