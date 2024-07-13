package giovxna.literalura.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private int downloads;
    private LocalDate dataPublicacao;
    private String genero;
    private String editora;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id")
    private Autor autor;

}