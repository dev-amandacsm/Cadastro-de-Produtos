package com.projetweb.cadproduto.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetweb.cadproduto.entities.enums.PedidoStatus;

@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape=  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;

	private Integer pedidoStatus;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;// associacao que irá demonstrar que um cliente tem varios pedidos

	@OneToMany (mappedBy = "id.pedido" )
	private Set<PedidoItem> itens = new HashSet<>();
	
	@OneToOne(mappedBy="pedido", cascade= CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {
		
	}

	public Pedido(Long id, Instant momento, PedidoStatus pedidoStatus, Usuario cliente) {
		super();
		this.id = id;
		this.momento = momento;
		this.cliente = cliente;
		setPedidoStatus(pedidoStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valorde(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if (pedidoStatus != null) {
		this.pedidoStatus = pedidoStatus.getCode();
		}
	}
	

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<PedidoItem> getItens(){
		return itens;
	}
	
	public Double getTotal() {
		double soma =0.0;
		
		for (PedidoItem x: itens) {
			soma = soma + x.getSubTotal();
		}
		return soma;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
