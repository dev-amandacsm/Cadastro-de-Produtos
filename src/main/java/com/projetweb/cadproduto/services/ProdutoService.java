package com.projetweb.cadproduto.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetweb.cadproduto.entities.Categoria;
import com.projetweb.cadproduto.entities.Produto;
import com.projetweb.cadproduto.repositories.ProdutoRepository;
import com.projetweb.cadproduto.resources.dto.CategoriaDto;
import com.projetweb.cadproduto.resources.dto.ProdutoDetalheDto;
import com.projetweb.cadproduto.resources.dto.ProdutoDto;
import com.projetweb.cadproduto.services.exceptions.DatabaseException;
import com.projetweb.cadproduto.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository rep;
	@Autowired
	private CategoriaService categoriaService;
	
	public List<ProdutoDetalheDto> findAll(){
		
		return rep.findAll().stream().map(ProdutoDetalheDto::new).collect(Collectors.toList());
	}
	
	public ProdutoDto findById(Long id) {
		
		return new ProdutoDto(rep.findById(id).get());
		
	}
	
public ProdutoDto inserir(ProdutoDto form) {
		
		Produto produto = new Produto (null,form.getNome(),form.getDescricao(), form.getPreco(),form.getImgUrl(), form.getCategorias());
		
		return new ProdutoDto(rep.save(produto)); 
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

public ProdutoDto atualizar(Long id, ProdutoDto form) {
    Produto produto = rep.findById(id).get();
  
    produto.setNome(form.getNome());
    produto.setDescricao(form.getDescricao());
    produto.setPreco(form.getPreco());
    produto.setImgUrl(form.getImgUrl());
	produto.setCategorias(form.getCategorias());

    return new ProdutoDto(produto);
}

}

