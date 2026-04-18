package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {

	@Test
	public void testMaquinaVacia() {
		// Valida que, si la máquina está vacía,
		// no debe servir nada, no debe modificar la cantidad actual
		// y debe retornar 0.
		Maquina maquina = new Maquina("Honey", "Sabor a miel", 0.2, 5000,"H100");

		double valor = maquina.servirCerveza(300);

		assertEquals(0.0, valor, 0.0001);
		assertEquals(0.0, maquina.getCantidadActual(), 0.0001);
	}

	@Test
	public void testConstructorSinCapacidad() {
		// Valida el constructor que no recibe capacidad máxima.
		// Debe usar la capacidad por defecto y permitir servir correctamente.
		Maquina maquina = new Maquina("IPA", "Sabor fuerte", 0.3,"H100");

		assertEquals(10000.0, maquina.getCapacidadMaxima(), 0.0001);

		maquina.recargarCerveza(1000);
		double valor = maquina.servirCerveza(400);

		assertEquals(120.0, valor, 0.0001);
		assertEquals(600.0, maquina.getCantidadActual(), 0.0001);
	}

	@Test
	public void testNoHaySuficienteCerveza() {
		// Valida que, si no hay suficiente cerveza disponible,
		// no debe servir nada, no debe modificar la cantidad actual
		// y debe retornar 0.
		Maquina maquina = new Maquina("Porter", "Sabor intenso", 0.25, 4000,"H100");
		maquina.recargarCerveza(400);

		double valor = maquina.servirCerveza(700);

		assertEquals(0.0, valor, 0.0001);
		assertEquals(400.0, maquina.getCantidadActual(), 0.0001);
	}

	@Test
	public void testServirCantidadExacta() {
		// Valida que, si se sirve exactamente la cantidad disponible,
		// la cantidad actual debe quedar en 0 y debe retornar el valor correcto.
		Maquina maquina = new Maquina("Lager", "Suave", 0.15, 3000,"H100");
		maquina.recargarCerveza(800);

		double valor = maquina.servirCerveza(800);

		assertEquals(120.0, valor, 0.0001);
		assertEquals(0.0, maquina.getCantidadActual(), 0.0001);
	}

	@Test
	public void testServirCorrectamente() {
		// Valida que, si hay suficiente cerveza,
		// debe descontar la cantidad servida y retornar el valor a pagar.
		Maquina maquina = new Maquina("Honey", "Sabor a miel", 0.2, 5000,"H100");
		maquina.recargarCerveza(1000);

		double valor = maquina.servirCerveza(500);

		assertEquals(100.0, valor, 0.0001);
		assertEquals(500.0, maquina.getCantidadActual(), 0.0001);
	}

	@Test
	public void testServirCero() {
		// Valida que, si se intenta servir 0 mililitros,
		// el valor retornado sea 0 y la cantidad actual no cambie.
		Maquina maquina = new Maquina("Amber", "Sabor tostado", 0.2, 5000,"H100");
		maquina.recargarCerveza(900);

		double valor = maquina.servirCerveza(0);

		assertEquals(0.0, valor, 0.0001);
		assertEquals(900.0, maquina.getCantidadActual(), 0.0001);
	}
}