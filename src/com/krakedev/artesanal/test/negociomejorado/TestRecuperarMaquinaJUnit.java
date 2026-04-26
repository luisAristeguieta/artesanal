package com.krakedev.artesanal.test.negociomejorado;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquinaJUnit {

		private NegocioMejorado negocio;

	    @BeforeEach
	    public void setUp() {
	        negocio = new NegocioMejorado();
	    }

	    @Test
	    public void testRecuperarMaquina_codigoExistente() {
	        // Se prueba: buscar una máquina con código existente
	        // Resultado esperado: retorna objeto distinto de null

	        negocio.agregarMaquina("Pilsener", "Rubia", 0.02);

	        String codigo = negocio.getMaquinas().get(0).getCodigo();

	        Maquina resultado = negocio.recuperarMaquina(codigo);

	        assertNotNull(resultado);
	        assertEquals(codigo, resultado.getCodigo());
	    }

	    @Test
	    public void testRecuperarMaquina_codigoInexistente() {
	        // Se prueba: buscar una máquina con código que no existe
	        // Resultado esperado: retorna null

	        negocio.agregarMaquina("IPA", "Amarga", 0.03);

	        Maquina resultado = negocio.recuperarMaquina("M-999");

	        assertNull(resultado);
	    }

	    @Test
	    public void testRecuperarMaquina_listaVacia() {
	        // Se prueba: buscar en lista vacía
	        // Resultado esperado: retorna null

	        Maquina resultado = negocio.recuperarMaquina("M-1");

	        assertNull(resultado);
	    }

	    @Test
	    public void testRecuperarMaquina_variasMaquinas() {
	        // Se prueba: buscar en lista con múltiples máquinas
	        // Resultado esperado: retorna la máquina correcta

	        negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
	        negocio.agregarMaquina("IPA", "Amarga", 0.03);
	        negocio.agregarMaquina("Stout", "Oscura", 0.04);

	        String codigoBuscado = negocio.getMaquinas().get(1).getCodigo();

	        Maquina resultado = negocio.recuperarMaquina(codigoBuscado);

	        assertNotNull(resultado);
	        assertEquals("IPA", resultado.getNombreCerveza());
	    }

	}

