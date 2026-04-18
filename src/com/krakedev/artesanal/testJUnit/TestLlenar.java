package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	@Test
	public void testLlenarMaquina() {
		Maquina honey = new Maquina("Honey", "Sabor a miel", 0.2, 5000);

		honey.llenarMaquina();

		assertEquals(4900, honey.getCantidadActual(), 0.0001);

	}

}
