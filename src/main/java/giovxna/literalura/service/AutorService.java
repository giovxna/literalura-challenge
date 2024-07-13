package giovxna.literalura.service;

import giovxna.literalura.model.Autor;
import giovxna.literalura.repository.AutorRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Transactional(readOnly = true)
    public List<Autor> listarTodosAutores() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(autor -> Hibernate.initialize(autor.getLivros()));
        return autores;
    }

    @Transactional(readOnly = true)
    public List<Autor> buscarPorNome(String nome) {
        List<Autor> autores = autorRepository.findByNomeContaining(nome);
        autores.forEach(autor -> Hibernate.initialize(autor.getLivros()));
        return autores;
    }

    @Transactional(readOnly = true)
    public List<Autor> buscarPorNacionalidade(String nacionalidade) {
        List<Autor> autores = autorRepository.findByNacionalidade(nacionalidade);
        autores.forEach(autor -> Hibernate.initialize(autor.getLivros()));
        return autores;
    }

    @Transactional(readOnly = true)
    public List<Autor> buscarPorPeriodoNascimento(int startYear, int endYear) {
        List<Autor> autores = autorRepository.findByAnoNascimentoBetween(startYear, endYear);
        autores.forEach(autor -> Hibernate.initialize(autor.getLivros()));
        return autores;
    }
}
