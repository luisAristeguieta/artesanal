package com.krakedev.artesanal.test.negociomejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquinaValidadoJUnit {
	private NegocioMejorado negocio;

    @BeforeEach
    public void setUp() {
        negocio = new NegocioMejorado();
    }

    @Test
    public void testAgregarMaquina_agregaCorrectamente() {
        // Se prueba: agregar una máquina válida
        // Resultado esperado: retorna true y se agrega a la lista

        boolean resultado = negocio.agregarMaquina("Pilsener", "Rubia", 0.02);

        assertTrue(resultado);
        assertEquals(1, negocio.getMaquinas().size());
    }

    @Test
    public void testAgregarMaquina_datosCorrectos() {
        // Se prueba: que los datos se guarden correctamente
        // Resultado esperado: atributos coinciden

        negocio.agregarMaquina("IPA", "Amarga", 0.03);

        Maquina m = negocio.getMaquinas().get(0);

        assertEquals("IPA", m.getNombreCerveza());
        assertEquals("Amarga", m.getDescripcion());
        assertEquals(0.03, m.getPrecioPorMl());
    }

    @Test
    public void testAgregarMaquina_codigoGenerado() {
        // Se prueba: que el código se genere automáticamente
        // Resultado esperado: no null y empieza con "M-"

        negocio.agregarMaquina("Stout", "Oscura", 0.04);

        Maquina m = negocio.getMaquinas().get(0);

        assertNotNull(m.getCodigo());
        assertTrue(m.getCodigo().startsWith("M-"));
    }

    @Test
    public void testAgregarMaquina_noDuplicados_logico() {
        // Se prueba: que no se repitan códigos (validación lógica)
        // Resultado esperado: los códigos generados sean diferentes

        negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
        negocio.agregarMaquina("IPA", "Amarga", 0.03);

        String codigo1 = negocio.getMaquinas().get(0).getCodigo();
        String codigo2 = negocio.getMaquinas().get(1).getCodigo();

        assertNotEquals(codigo1, codigo2);
    }
}
