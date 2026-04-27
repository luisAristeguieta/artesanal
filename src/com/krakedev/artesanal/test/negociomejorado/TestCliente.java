package com.krakedev.artesanal.test.negociomejorado;

import com.krakedev.artesanal.NegocioMejorado;

public class TestCliente {

	public static void main(String[] args) {
		// Valida el nullPointException por no inicializar la lista para registra un cliente nuevo
		
		NegocioMejorado negocio = new NegocioMejorado();
		
		boolean resultado = negocio.registrarCliente("Luis", "17562728211");
		
		System.out.println("Se agrego? " + resultado);

	}

}
