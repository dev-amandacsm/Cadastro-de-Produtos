package com.projetweb.cadproduto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetweb.cadproduto.entities.Produto;
import com.projetweb.cadproduto.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository rep;
	
	public List<Produto> findAll(){
		return rep.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj= rep.findById(id);
		return obj.get();
		
	}
}
