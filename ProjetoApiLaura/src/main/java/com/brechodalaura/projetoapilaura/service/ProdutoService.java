package com.brechodalaura.projetoapilaura.service;

import com.brechodalaura.projetoapilaura.model.Produto;
import com.brechodalaura.projetoapilaura.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto atualizar(Integer id, Produto produtoAtualizado) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));

        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setPreco(produtoAtualizado.getPreco());
        produtoExistente.setDescricao(produtoAtualizado.getDescricao());
        produtoExistente.setCategoria(produtoAtualizado.getCategoria());

        return produtoRepository.save(produtoExistente);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }
}


