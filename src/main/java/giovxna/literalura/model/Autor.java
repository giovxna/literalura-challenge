package giovxna.literalura.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;
    private int ano;
    private String nacionalidade;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;
}