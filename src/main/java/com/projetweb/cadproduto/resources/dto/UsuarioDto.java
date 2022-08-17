package com.projetweb.cadproduto.resources.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projetweb.cadproduto.entities.Usuario;

public class UsuarioDto {
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	
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

	public UsuarioDto() {
	}

	public UsuarioDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	

	public UsuarioDto(Usuario usuario) {

		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static List<UsuarioDto> convert(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}
