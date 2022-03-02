package com.projetweb.cadproduto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetweb.cadproduto.entities.Categoria;
import com.projetweb.cadproduto.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository rep;
	
	public List<Categoria> findAll(){
		return rep.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj= rep.findById(id);
		return obj.get();
		
	}
}
