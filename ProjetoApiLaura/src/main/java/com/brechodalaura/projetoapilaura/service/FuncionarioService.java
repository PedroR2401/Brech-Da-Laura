package com.brechodalaura.projetoapilaura.service;


import com.brechodalaura.projetoapilaura.model.Funcionario;
import com.brechodalaura.projetoapilaura.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deletar(Integer id) {
        funcionarioRepository.deleteById(id);
    }//gf

    // Método para login
    public Funcionario login(String email, String senha) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(email);
        if (funcionario.isPresent() && funcionario.get().getSenha().equals(senha)) {
            return funcionario.get();
        }
        throw new IllegalArgumentException("E-mail ou senha inválidos");
    }

}