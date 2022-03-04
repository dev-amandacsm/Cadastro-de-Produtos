package com.projetweb.cadproduto.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public ResourceNotFoundException (Object id) {
			
			super("Fonte não encontrada. Id " + id);
		}

}
