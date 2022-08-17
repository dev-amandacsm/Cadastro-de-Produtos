package com.projetweb.cadproduto.resources.dto.form;import com.projetweb.cadproduto.entities.Usuario;

public class Usuarioform {
	private String nome;
	private String email;
	private String telefone;
	private String senha;

	public Usuarioform() {

	}

	public Usuarioform(String nome, String email, String telefone, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Usuarioform (Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.senha = usuario.getSenha();
		
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario converter () {
		return new Usuario(null, nome, email,telefone,senha);
	}

}
