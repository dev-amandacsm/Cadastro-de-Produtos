package com.projetweb.cadproduto.resources.dto.form;

import com.projetweb.cadproduto.entities.Produto;
import com.projetweb.cadproduto.repositories.ProdutoRepository;

public class ProdutoForm {
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;

	public ProdutoForm() {

	}

	public ProdutoForm(String nome, String descricao, Double preco, String imgUrl) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
	}

	public ProdutoForm(Produto produto) {

		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.imgUrl= produto.getImgUrl();
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

	public Produto converter() {
		return new Produto (null,nome,descricao, preco, imgUrl);
	}
	
public Produto atualiza (Long id, ProdutoRepository produtoRepository) {
		
		Produto produto = produtoRepository.getById(id);
		produto.setNome(this.nome);
		produto.setDescricao(this.descricao);
		produto.setPreco(this.preco);
		produto.setImgUrl(imgUrl);
		
		return produto;
	}

}
