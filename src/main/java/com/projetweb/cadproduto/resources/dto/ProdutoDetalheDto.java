package com.projetweb.cadproduto.resources.dto;

import com.projetweb.cadproduto.entities.Produto;

public class ProdutoDetalheDto {
	private Long id;
	private String nome;
	private Double preco;

	public ProdutoDetalheDto() {

	}

	public ProdutoDetalheDto(Long id, String nome, Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;

	}

	public ProdutoDetalheDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();

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


	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}



}
