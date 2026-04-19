package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestConsumoCliente {

	@Test
	public void cosumoCliente() {
		
		Maquina laRegional = new Maquina("Pilsener", "Light", 0.03, 20000, "P10");
		Negocio barMayu = new Negocio("BarExotico",laRegional);
		Cliente mesa1 = new Cliente("luis", "1757126528");
		
		// Se llena la maquina a capacidad maxima segura, ya que por defecto esta vacia.
		// Se llenaria en el negocio
		barMayu.cargarMaquina();
		
		// Una vez en la capacidad maxima segura se procede a servir: 
		barMayu.consumirCervezaMaquinaA(mesa1, 1000);
		
		// Serivido se procede a comparar el valor de la cantidad actual de la maquina en el bar y el valor pagado: 
		assertEquals(18800,barMayu.getMaquinaA().getCantidadActual(),0.0001);
		assertEquals(30,mesa1.getTotalConsumido(),0.0001);
		
		// Realiza el calculo de nuevos consumos: 
		barMayu.consumirCervezaMaquinaA(mesa1, 2000);
		
		assertEquals(16800,barMayu.getMaquinaA().getCantidadActual(),0.0001);
		assertEquals(90,mesa1.getTotalConsumido(),0.0001);
		
	}
}
