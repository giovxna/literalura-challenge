package giovxna.literalura.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}