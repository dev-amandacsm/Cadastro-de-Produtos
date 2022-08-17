package com.projetweb.cadproduto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetweb.cadproduto.entities.Produto;
import com.projetweb.cadproduto.repositories.ProdutoRepository;
import com.projetweb.cadproduto.resources.dto.ProdutoDto;
import com.projetweb.cadproduto.services.exceptions.DatabaseException;
import com.projetweb.cadproduto.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository rep;
	
	public List<Produto> findAll(){
		return rep.findAll();
	}
	
	public ProdutoDto findById(Long id) {
		Produto obj= rep.findById(id).get();
		ProdutoDto dto = new ProdutoDto(obj);
		return dto;
		
	}
	
public Produto inserir(Produto obj) {
		
		return rep.save(obj);
	}

public void delete (Long id) {
	try {
	rep.deleteById(id);
	}catch (EmptyResultDataAccessException e){
		throw new ResourceNotFoundException(id);
	}catch(DataIntegrityViolationException e) {
		throw new DatabaseException(e.getMessage());
	}
	
}

// public metodo update(){}

}

