package com.projetweb.cadproduto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetweb.cadproduto.entities.Categoria;
import com.projetweb.cadproduto.resources.dto.CategoriaDto;
import com.projetweb.cadproduto.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService serv;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDto>> findAll(){
		List<CategoriaDto> l = serv.findAll();
		return ResponseEntity.ok().body(l);
	}
	
	@GetMapping (value="/{id}")
	public ResponseEntity<CategoriaDto> findById(@PathVariable Long id){
		CategoriaDto obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
