package com.projetweb.cadproduto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetweb.cadproduto.entities.Usuario;
import com.projetweb.cadproduto.repositories.UsuarioRepository;
import com.projetweb.cadproduto.resources.dto.UsuarioDto;
import com.projetweb.cadproduto.services.exceptions.DatabaseException;
import com.projetweb.cadproduto.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository rep;
	
	public List<Usuario> findAll(){
		return rep.findAll();
	}
	
	public UsuarioDto findById(Long id) {
		Usuario obj= rep.findById(id).get();
		UsuarioDto dto = new UsuarioDto(obj);
		return dto;
		
	}
	
	public Usuario inserir(Usuario obj) {
		
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
	
//	public  UsuarioDto  update(Long id, AtualizaUsuarioForm form) {
//		Usuario usuario = rep.getById(id);
//		UsuarioDto dto = new UsuarioDto(usuario);
//		
//		form.atualiza(dto.getId(), rep);
//		return form;
//		
	}



