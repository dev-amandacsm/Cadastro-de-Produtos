package com.projetweb.cadproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetweb.cadproduto.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
