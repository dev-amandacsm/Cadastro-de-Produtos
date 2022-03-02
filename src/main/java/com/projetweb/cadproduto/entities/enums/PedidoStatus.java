package com.projetweb.cadproduto.entities.enums;

public enum PedidoStatus {

	ESPERANDO_PAGAMENTO(1), PAGO(2), ENVIADO(3), ENTREGUE(4), CANCELADO(5);

	private int code;

	// perceba que o estado tem que privado
	private PedidoStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static PedidoStatus valorde(int code) {
		for (PedidoStatus valor : PedidoStatus.values()) {
			if(valor.getCode() == code) {
				return valor;
			}
		}
		
		throw new IllegalArgumentException("Valor do Status invalido");
	}

}
