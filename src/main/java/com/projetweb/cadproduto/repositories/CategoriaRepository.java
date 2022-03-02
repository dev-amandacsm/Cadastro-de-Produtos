package com.projetweb.cadproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetweb.cadproduto.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
