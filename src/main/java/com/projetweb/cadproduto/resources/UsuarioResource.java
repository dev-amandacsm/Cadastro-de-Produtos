package com.projetweb.cadproduto.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario obj){
		obj = serv.inserir(obj);
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);	
	}

	
	@DeleteMapping  (value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
	
		serv.delete(id);
		return ResponseEntity.noContent().build();
}
	
	@PutMapping (value="/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
		
		obj= serv.update(id, obj);
		
		return ResponseEntity.ok().body(obj);
		
	}

}