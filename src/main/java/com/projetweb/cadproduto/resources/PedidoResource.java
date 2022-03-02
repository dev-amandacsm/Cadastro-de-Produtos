package com.projetweb.cadproduto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetweb.cadproduto.entities.Pedido;
import com.projetweb.cadproduto.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	// Tem o intuito de disponibilizar um recurso web para a entidade user - rest controller
	
	@Autowired
	private PedidoService serv;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> l = serv.findAll();
		return ResponseEntity.ok().body(l);
	}
	
	@GetMapping (value="/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
