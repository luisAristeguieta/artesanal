package com.krakedev.artesanal.test.negociomejorado;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumo {

	public static void main(String[] args) {
		// Valida el metodo consumirCerveza, de valores si existe la maquina y codigo del cliente devuelve el valor consumido
		NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
        Maquina maquina = negocio.getMaquinas().get(0);

        // Llenar máquina
        maquina.llenarMaquina();

        // Registrar cliente nuevo y se obtiene el codigo en la posicion de la lista 0 de la lista cliente y el codigo de la mquina
        negocio.registrarCliente("Luis", "17562728211");
        int codigoCliente = negocio.getClientes().get(0).getCodigo();
        String codigoMaquina = maquina.getCodigo();

        // Consumir cerveza
        double valor = negocio.consumirCerveza(codigoCliente, codigoMaquina, 500);

        System.out.println("Valor consumido: " + valor);

	}

}
