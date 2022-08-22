package com.projetweb.cadproduto.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetweb.cadproduto.repositories.CategoriaRepository;
import com.projetweb.cadproduto.resources.dto.CategoriaDto;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository rep;
	
	public List<CategoriaDto> findAll(){
		return rep.findAll().stream().map(CategoriaDto::new).collect(Collectors.toList());
	}
	
	public CategoriaDto findById(Long id) {
		return new CategoriaDto(rep.findById(id).get());
		
	}
}
