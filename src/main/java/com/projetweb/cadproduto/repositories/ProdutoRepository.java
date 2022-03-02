package com.projetweb.cadproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetweb.cadproduto.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
