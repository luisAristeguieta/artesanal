package com.krakedev.artesanal.test.negociomejorado;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestbuscarClientePorCedula {

	public static void main(String[] args) {
		// Valida el metodo buscarClientePorCedula en la lista existente de cliente del
		// negocio, ya se debe tener varios clientes agregados.

		NegocioMejorado negocio = new NegocioMejorado();
		negocio.registrarCliente("Luis", "17562728211");
		negocio.registrarCliente("Maria", "0912345678");

		Cliente encontrado = negocio.buscarClientePorCedula("17562728211");

		if (encontrado != null) {
			System.out.println("Cliente encontrado:");
			System.out.println("Nombre: " + encontrado.getNombre());
			System.out.println("Cédula: " + encontrado.getCedula());
			System.out.println("Código: " + encontrado.getCodigo());
		} else {
			System.out.println("No se encontró el cliente");
		}
		
		Cliente encontrado2 = negocio.buscarClientePorCedula("1756272");
		
		if (encontrado2 != null) {
			System.out.println("Cliente encontrado:");
			System.out.println("Nombre: " + encontrado.getNombre());
			System.out.println("Cédula: " + encontrado.getCedula());
			System.out.println("Código: " + encontrado.getCodigo());
		} else {
			System.out.println("No se encontró el cliente");
		}
	}

}
