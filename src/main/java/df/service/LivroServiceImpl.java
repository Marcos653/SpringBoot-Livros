package df.service;

import df.model.Livro;
import df.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements   LivroService {
    @Autowired
    private LivroRepository repo;


    @Override
    public List<Livro> obterLivros() {
        return repo.findAll();
    }

    @Override
    public Livro cadastrarLivro(Livro livro) {
        return repo.save(livro);
    }

    @Override
    public Livro obterLivrosPorId(String id) {
        return repo.findById(id).get();
    }

    @Override
    public void excluirLivro(String id) {
        repo.deleteById(id);
    }

    @Override
    public Livro atualizarLivro(String id, Livro novoLivro) {
        novoLivro.setCodigo(id);
        return  repo.save(novoLivro);
    }
}
