package df.controller;


import df.model.Livro;
import df.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tech4Livros")
public class LivroController {
    @Autowired
    private LivroService servico;

    @GetMapping
    public List<Livro> obterLivros(){
        return  servico.obterLivros();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> obterLivroPorId(@PathVariable String id){
        return new ResponseEntity<>(servico.obterLivrosPorId(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro){
        return new ResponseEntity<>(servico.cadastrarLivro(livro), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable String id){
        servico.excluirLivro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable String id,@RequestBody Livro novoLivro){
        return new ResponseEntity<>(servico.atualizarLivro(id, novoLivro), HttpStatus.ACCEPTED);
    }
}
