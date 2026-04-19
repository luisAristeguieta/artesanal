package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigos {
	
	@Test
	public void asignarCodigo() {
		
		Negocio barMayu = new Negocio();
		
		Cliente luis = new Cliente("Luis", "1757271921");
		Cliente maria = new Cliente("Maria", "1725836450");
		
		barMayu.asignarCodigoCLiente(luis);
		barMayu.asignarCodigoCLiente(maria);
		
		assertEquals(100,luis.getCodigo(),0.0001);
		assertEquals(101,maria.getCodigo(),0.0001);
		
	}
}
