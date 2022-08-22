package com.projetweb.cadproduto.resources;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.projetweb.cadproduto.resources.dto.ProdutoDetalheDto;
import com.projetweb.cadproduto.resources.dto.ProdutoDto;
import com.projetweb.cadproduto.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService serv;
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<ProdutoDetalheDto>> findAll() {
		
		return ResponseEntity.ok().body(serv.findAll());
	}

	@GetMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok(serv.findById(id));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto> inserir(@RequestBody ProdutoDto form, UriComponentsBuilder uriBuilder) {

		ProdutoDto dto = serv.inserir(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		serv.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> update(@PathVariable Long id, @RequestBody ProdutoDto form) {

		ProdutoDto dto = serv.atualizar(id, form);
		return ResponseEntity.ok(dto);

	}
}
