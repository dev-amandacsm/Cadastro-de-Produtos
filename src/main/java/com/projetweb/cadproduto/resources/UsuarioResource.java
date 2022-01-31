package com.projetweb.cadproduto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetweb.cadproduto.entities.Usuario;
import com.projetweb.cadproduto.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {
	// Tem o intuito de disponibilizar um recurso web para a entidade user - rest controller
	
	@Autowired
	private UsuarioService serv;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> l = serv.findAll();
		return ResponseEntity.ok().body(l);
	}
	
	@GetMapping (value="/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
