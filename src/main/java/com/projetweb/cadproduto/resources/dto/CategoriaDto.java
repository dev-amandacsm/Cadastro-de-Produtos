package com.projetweb.cadproduto.resources.dto;

import java.util.HashSet;
import java.util.Set;

import com.projetweb.cadproduto.entities.Categoria;
import com.projetweb.cadproduto.entities.Produto;

public class CategoriaDto {
	private Long id;
	private String nome;
	private Set<Produto> produtos = new HashSet <>();
	
	public CategoriaDto() {
		
	}
	
	public CategoriaDto(Categoria categoria) {
		
		this.id = categoria.getId();
		this.nome= categoria.getNome();
		this.produtos= categoria.getProdutos();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
