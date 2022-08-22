package com.projetweb.cadproduto.resources.dto;

import java.util.HashSet;
import java.util.Set;

import com.projetweb.cadproduto.entities.Categoria;
import com.projetweb.cadproduto.entities.Produto;

public class ProdutoDto {
	private Long id;
	private String nome;
	private String descricao;
	private String imgUrl;
	private Double preco;
	private Set<Categoria> categorias = new HashSet<>();


	public ProdutoDto() { 

	}

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.imgUrl = produto.getImgUrl();
		this.categorias = produto.getCategorias(); 
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}


}
