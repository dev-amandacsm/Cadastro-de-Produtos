package com.projetweb.cadproduto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetweb.cadproduto.entities.Usuario;
import com.projetweb.cadproduto.repositories.UsuarioRepository;
import com.projetweb.cadproduto.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository rep;
	
	public List<Usuario> findAll(){
		return rep.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj= rep.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
		
	}
	
	public Usuario inserir(Usuario obj) {
		return rep.save(obj);
	}
	
	public void delete (Long id) {
		rep.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario obj) {
		
		Usuario entity = rep.getById(id);
		updateData(entity,obj);
		return rep.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
				entity.setNome(obj.getNome());
				entity.setEmail(obj.getEmail());
				entity.setTelefone(obj.getTelefone());
	}
}
