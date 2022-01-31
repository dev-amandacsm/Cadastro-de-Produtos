package com.projetweb.cadproduto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetweb.cadproduto.entities.Usuario;
import com.projetweb.cadproduto.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository rep;
	
	public List<Usuario> findAll(){
		return rep.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj= rep.findById(id);
		return obj.get();
		
	}
}
