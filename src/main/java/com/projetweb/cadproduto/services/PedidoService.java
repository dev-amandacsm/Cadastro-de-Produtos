package com.projetweb.cadproduto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetweb.cadproduto.entities.Pedido;
import com.projetweb.cadproduto.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository rep;
	
	public List<Pedido> findAll(){
		return rep.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj= rep.findById(id);
		return obj.get();
		
	}
}
