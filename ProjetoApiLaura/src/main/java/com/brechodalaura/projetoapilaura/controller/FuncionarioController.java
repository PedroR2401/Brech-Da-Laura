package com.brechodalaura.projetoapilaura.controller;


import com.brechodalaura.projetoapilaura.model.Funcionario;
import com.brechodalaura.projetoapilaura.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    //Endpoint para listar funcionarios
    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    // Endpoint para cadastrar
    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.salvar(funcionario));
    }

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<Funcionario> login(@RequestParam String email, @RequestParam String senha) {
        try {
            Funcionario funcionario = funcionarioService.login(email, senha);
            return ResponseEntity.ok(funcionario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(null); // Retorna 401 se o login falhar
        }
    }

    // Endpoint para deletar funcionario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}