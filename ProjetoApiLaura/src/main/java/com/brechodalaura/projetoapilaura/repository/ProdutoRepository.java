package com.brechodalaura.projetoapilaura.repository;

import com.brechodalaura.projetoapilaura.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
