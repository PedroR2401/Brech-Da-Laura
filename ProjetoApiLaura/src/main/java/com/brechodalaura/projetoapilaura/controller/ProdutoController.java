package com.brechodalaura.projetoapilaura.controller;


import com.brechodalaura.projetoapilaura.model.Produto;
import com.brechodalaura.projetoapilaura.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //Endpoint para listar todos os produtos
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    //Endpoint para cadastrar produto
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    //Endpoint para editar produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto produtoAtualizado) {
        Produto produto = produtoService.atualizar(id, produtoAtualizado);
        return ResponseEntity.ok(produto);
    }

    //Endpoint para deletar o produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
