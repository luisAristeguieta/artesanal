package com.krakedev.artesanal.test.negociomejorado;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestCargarMaquinas {

	public static void main(String[] args) {
		// Valida el metodo cargarMaquinas, que solo llena todas las maquinas de la lista
		
		/*
		 * Debe prviamente existir un negocio mejorado, unas maquinas dentro del
		 * negocios, verifico que estan vacias cargo e imprimo su estado cargado de todas las maquina de las lista
		 */
		
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("Pilsener", "Rubia ligera", 0.02);
        negocio.agregarMaquina("IPA", "Amarga", 0.03);


        System.out.println("=== ANTES DE CARGAR ===");
        for (Maquina m : negocio.getMaquinas()) {
            System.out.println("Cantidad actual: " + m.getCantidadActual());
            System.out.println("Capacidad máxima: " + m.getCapacidadMaxima());
        }

        negocio.cargarMaquinas();

        System.out.println("\n=== DESPUÉS DE CARGAR ===");
        for (Maquina m : negocio.getMaquinas()) {
            System.out.println("Cantidad actual: " + m.getCantidadActual());
            System.out.println("Capacidad máxima: " + m.getCapacidadMaxima());

            // Validación manual teniendo en cuenta que la capacidad es -200 de la capacidad maxima
            double esperado = m.getCapacidadMaxima() - 200;
            System.out.println("Esperado: " + esperado);
        }

	}

}
