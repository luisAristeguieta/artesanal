package com.krakedev.artesanal.test.negociomejorado;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestGenerarCodigoJUnit {
	
	// Para el taller # 3, Se valida el metodo generarCodigo con JUnit five dando 97% para la clase negocioMejorado:
	
	@Test
    public void testGenerarCodigo_noEsNull() {
        // Se prueba: que el método no retorne null
        // Resultado esperado: código válido distinto de null

        NegocioMejorado negocio = new NegocioMejorado();
        String codigo = negocio.generarCodigo();

        assertNotNull(codigo);
    }

    @Test
    public void testGenerarCodigo_formatoCorrecto() {
        // Se prueba: que el código empiece con "M-"
        // Resultado esperado: true

        NegocioMejorado negocio = new NegocioMejorado();
        String codigo = negocio.generarCodigo();

        assertTrue(codigo.startsWith("M-"));
    }

    @Test
    public void testGenerarCodigo_rangoCorrecto() {
        // Se prueba: que el número generado esté entre 1 y 100
        // Resultado esperado: número dentro del rango

        NegocioMejorado negocio = new NegocioMejorado();
        String codigo = negocio.generarCodigo();

        String numeroTexto = codigo.split("-")[1];
        int numero = Integer.parseInt(numeroTexto);

        assertTrue(numero >= 1 && numero <= 100);
    }

    @Test
    public void testGenerarCodigo_multiplesEjecuciones() {
        // Se prueba: ejecutar varias veces y validar siempre formato y rango
        // Resultado esperado: todos los códigos válidos

        NegocioMejorado negocio = new NegocioMejorado();

        for (int i = 0; i < 50; i++) {
            String codigo = negocio.generarCodigo();

            assertNotNull(codigo);
            assertTrue(codigo.startsWith("M-"));

            int numero = Integer.parseInt(codigo.split("-")[1]);
            assertTrue(numero >= 1 && numero <= 100);
        }
    }
}
