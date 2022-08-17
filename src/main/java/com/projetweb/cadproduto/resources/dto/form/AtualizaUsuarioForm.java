package com.projetweb.cadproduto.resources.dto.form;

import com.projetweb.cadproduto.entities.Usuario;
import com.projetweb.cadproduto.repositories.UsuarioRepository;

public class AtualizaUsuarioForm {
	private String nome;
	private String email;
	private String telefone;
	
	public AtualizaUsuarioForm() {
		
		
	}
	public AtualizaUsuarioForm(String nome, String email, String telefone) {
	
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Usuario atualiza (Long id, UsuarioRepository usuarioRepository) {
		
		Usuario usuario = usuarioRepository.getById(id);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		
		return usuario;
	}
}
