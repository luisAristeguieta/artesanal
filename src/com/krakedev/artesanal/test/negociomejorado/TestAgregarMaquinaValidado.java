package com.krakedev.artesanal.test.negociomejorado;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquinaValidado {

	public static void main(String[] args) {

		// Valida que la modificacion que se realiza en el metodo agregar maquina no se agregue si existe el codigo en true agregado 
        NegocioMejorado negocio = new NegocioMejorado();

        // Agregar máquinas
        boolean r1 = negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
        boolean r2 = negocio.agregarMaquina("IPA", "Amarga", 0.03);

        System.out.println("Resultado 1: " + r1);
        System.out.println("Resultado 2: " + r2);

        // Mostrar lista
        System.out.println("\n=== LISTA DE MAQUINAS ===");
        for (Maquina m : negocio.getMaquinas()) {
            System.out.println("Nombre: " + m.getNombreCerveza());
            System.out.println("Código: " + m.getCodigo());
            System.out.println("------------------------");
        }

        // Validación manual de duplicado (simulación)
        System.out.println("\nCantidad total: " + negocio.getMaquinas().size());
    }
}
