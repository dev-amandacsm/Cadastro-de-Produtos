package com.projetweb.cadproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetweb.cadproduto.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
