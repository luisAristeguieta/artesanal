package com.krakedev.artesanal.test.negociomejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquinaJUnit {
	private NegocioMejorado negocio;

    @BeforeEach
    public void setUp() {
        negocio = new NegocioMejorado();
    }

    @Test
    public void testAgregarMaquina_retornaTrue() {
        // Se prueba: que el método retorne true al agregar correctamente
        // Resultado esperado: true

        boolean resultado = negocio.agregarMaquina("Pilsener", "Rubia ligera", 0.02);

        assertTrue(resultado);
    }

    @Test
    public void testAgregarMaquina_incrementaLista() {
        // Se prueba: que al agregar una máquina, el tamaño de la lista aumente
        // Resultado esperado: tamaño = 1

        negocio.agregarMaquina("IPA", "Amarga", 0.03);

        assertEquals(1, negocio.getMaquinas().size());
    }

    @Test
    public void testAgregarMaquina_datosCorrectos() {
        // Se prueba: que los datos ingresados se guarden correctamente
        // Resultado esperado: los atributos coinciden

        negocio.agregarMaquina("Stout", "Oscura", 0.04);

        Maquina maquina = negocio.getMaquinas().get(0);

        assertEquals("Stout", maquina.getNombreCerveza());
        assertEquals("Oscura", maquina.getDescripcion());
        assertEquals(0.04, maquina.getPrecioPorMl());
    }

    @Test
    public void testAgregarMaquina_codigoGenerado() {
        // Se prueba: que el código se genere automáticamente
        // Resultado esperado: no null y empieza con "M-"

        negocio.agregarMaquina("Porter", "Intensa", 0.05);

        Maquina maquina = negocio.getMaquinas().get(0);

        assertNotNull(maquina.getCodigo());
        assertTrue(maquina.getCodigo().startsWith("M-"));
    }

    @Test
    public void testAgregarMaquina_variasMaquinas() {
        // Se prueba: agregar varias máquinas
        // Resultado esperado: tamaño correcto (3)

        negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
        negocio.agregarMaquina("IPA", "Amarga", 0.03);
        negocio.agregarMaquina("Stout", "Oscura", 0.04);

        assertEquals(3, negocio.getMaquinas().size());
    }
}
