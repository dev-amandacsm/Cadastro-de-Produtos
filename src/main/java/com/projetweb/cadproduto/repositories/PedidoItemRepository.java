package com.projetweb.cadproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetweb.cadproduto.entities.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>{

}
