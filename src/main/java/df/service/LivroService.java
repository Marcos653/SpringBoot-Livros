package df.service;

import df.model.Livro;

import java.util.List;

public interface LivroService {
    List<Livro> obterLivros();
    Livro cadastrarLivro(Livro livro);
    Livro obterLivrosPorId(String id);
    void excluirLivro(String id);
    Livro atualizarLivro(String id, Livro novoLivro);
}
