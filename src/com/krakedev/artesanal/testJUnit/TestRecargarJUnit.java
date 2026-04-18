package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {
	
	@Test
	public void testRecargaExitosa() {
		
		Maquina honey = new Maquina("Honey", "Sabor a miel", 0.2, 5000,"H100");
		
		boolean Resultado = honey.recargarCerveza(1000);
		
		assertTrue(Resultado);
		assertEquals(1000, honey.getCantidadActual(), 0.0001);
		
	}
	
	@Test
	public void testRecargaFallida() {
		
		Maquina ginger = new Maquina("Ginger", "Sabor a gengibre", 0.3, 8000,"H100");
		
		ginger.recargarCerveza(7000);
		boolean Resultado = ginger.recargarCerveza(1000);
		
		assertTrue(Resultado);
		assertEquals(3000, ginger.getCantidadActual(), 0.0001);
		
	}
	
}
