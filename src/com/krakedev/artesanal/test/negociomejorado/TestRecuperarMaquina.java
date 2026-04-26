package com.krakedev.artesanal.test.negociomejorado;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquina {

	public static void main(String[] args) {
		// Valida el metodo recuperarMaquina, recibiendo el codigo devuelve la maquina o null
		
		/*
		 * Debe prviamente existir un negocio mejorado, unas maquinas dentro del negocios, 
		 * verifico codigo de una de las maquinas recien agregad, muetro la maquina y condiciono por si no existe.
		 */
		
		NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
        negocio.agregarMaquina("IPA", "Amarga", 0.03);

        String codigoBuscado = negocio.getMaquinas().get(0).getCodigo();
        Maquina encontrada = negocio.recuperarMaquina(codigoBuscado);

        if (encontrada != null) {
            System.out.println("Máquina encontrada:");
            encontrada.imprimir();
        } else {
            System.out.println("No se encontró la máquina");
        }

	}

}
