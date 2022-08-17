package com.projetweb.cadproduto.resources.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projetweb.cadproduto.entities.Produto;

public class ProdutoDto {
	private String nome;
	private String descricao;
	private Double preco;
	
	
	public ProdutoDto() {
		
	}
	public ProdutoDto(String nome, String descricao, Double preco) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public ProdutoDto(Produto produto) {
		
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
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
	public static List<ProdutoDto> convert(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
		
	}
	
	
}
