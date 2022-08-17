package com.projetweb.cadproduto.resources;

import java.net.URI;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
import com.projetweb.cadproduto.repositories.UsuarioRepository;
import com.projetweb.cadproduto.resources.dto.UsuarioDto;
import com.projetweb.cadproduto.resources.dto.form.AtualizaUsuarioForm;
import com.projetweb.cadproduto.resources.dto.form.Usuarioform;
import com.projetweb.cadproduto.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {
	// Tem o intuito de disponibilizar um recurso web para a entidade user - rest
	// controller

	@Autowired
	private UsuarioService serv;
	@Autowired
	private UsuarioRepository rep;
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll() {
		List<Usuario> usuarios = serv.findAll();
		List<UsuarioDto> dto = UsuarioDto.convert(usuarios);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
		UsuarioDto obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Usuarioform> inserir(@RequestBody Usuarioform form) {
		Usuario usuario = form.converter();
		serv.inserir(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();

		return ResponseEntity.created(uri).body(new Usuarioform(usuario));
	}

	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		serv.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody AtualizaUsuarioForm form) {
		
		Optional<Usuario> optional = rep.findById(id);
		
		if(optional.isPresent()) {
			Usuario usuario = form.atualiza(id, rep);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		return ResponseEntity.notFound().build();

	}

}