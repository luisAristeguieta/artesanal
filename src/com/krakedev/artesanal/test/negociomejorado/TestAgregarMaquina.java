package com.krakedev.artesanal.test.negociomejorado;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquina {

	public static void main(String[] args) {
		// Valida el metodo agregarMaquina, agrega una lista de maquina al negocio

		/*
		 * Debe prviamente existir un negocio mejorado, unas maquinas dentro del
		 * negocios, verifico que agrega y muestro el tamaño de la lista de las maquinas
		 * del negocio e imprimo la lista
		 */

		NegocioMejorado negocio = new NegocioMejorado();
		boolean r1 = negocio.agregarMaquina("Pilsener", "Rubia ligera", 0.02);
		boolean r2 = negocio.agregarMaquina("IPA", "Amarga", 0.03);

		System.out.println("Resultado agregar 1: " + r1);
		System.out.println("Resultado agregar 2: " + r2);

		System.out.println("Cantidad de máquinas: " + negocio.getMaquinas().size());

		// Muestra la lista agregada:
		for (int i = 0; i < negocio.getMaquinas().size(); i++) {
			Maquina m = negocio.getMaquinas().get(i);

			System.out.println("---- Máquina " + (i + 1) + " ----");
			System.out.println("Nombre: " + m.getNombreCerveza());
			System.out.println("Descripción: " + m.getDescripcion());
			System.out.println("Precio por ML: " + m.getPrecioPorMl());
			System.out.println("Código: " + m.getCodigo());
		}

	}

}
