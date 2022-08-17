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

import com.projetweb.cadproduto.entities.Produto;
import com.projetweb.cadproduto.repositories.ProdutoRepository;
import com.projetweb.cadproduto.resources.dto.ProdutoDto;
import com.projetweb.cadproduto.resources.dto.form.ProdutoForm;
import com.projetweb.cadproduto.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService serv;
	@Autowired
	private ProdutoRepository rep;

	@GetMapping
	@Transactional
	public ResponseEntity<List<ProdutoDto>> findAll() {
		List<Produto> produtos = serv.findAll();
		List<ProdutoDto> dto = ProdutoDto.convert(produtos);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> findById(@PathVariable Long id) {
		ProdutoDto obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoForm> inserir(@RequestBody ProdutoForm form) {
		Produto produto = form.converter();
		serv.inserir(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId())
				.toUri();

		return ResponseEntity.created(uri).body(new ProdutoForm(produto));
	}

	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		serv.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> update(@PathVariable Long id, @RequestBody ProdutoForm form) {

		Optional<Produto> prod = rep.findById(id);

		if (prod.isPresent()) {
			Produto produto = form.atualiza(id, rep);
			return ResponseEntity.ok(new ProdutoDto(produto));
		}
		return ResponseEntity.notFound().build();

	}
}
