package com.brechodalaura.projetoapilaura.model;

//Usando o jpa para mapear as classes para o banco de dados

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Double preco;
    private String descricao;
    private String categoria;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao(){
        return descricao;
    }

    public String setDescricao(String descricao){
        return this.descricao = descricao;
    }

    public String getCategoria(){
        return categoria;
    }

    public String setCategoria(String categoria){
        return this.categoria = categoria;
    }

    public Double getPreco(){
        return preco;
    }

    public Double setPreco(Double preco){
        return this.preco = preco;
    }

    public String getNome(){
        return nome;
    }

    public String setNome(String nome){
        return this.nome = nome;
    }



}
