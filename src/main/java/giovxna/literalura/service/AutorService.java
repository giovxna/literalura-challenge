package giovxna.literalura.service;

import giovxna.literalura.model.Autor;
import giovxna.literalura.repository.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public List<Autor> buscarPorNome(String nome) {
        return autorRepository.findByNomeContaining(nome);
    }

    public List<Autor> listarPorAnoNascimento(int anoNascimento) {
        return autorRepository.findByAnoNascimento(anoNascimento);
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor atualizar(Long id, Autor autor) {
        if (autorRepository.existsById(id)) {
            autor.setId(id);
            return autorRepository.save(autor);
        } else {
            throw new EntityNotFoundException("Autor não encontrado");
        }
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }
}
