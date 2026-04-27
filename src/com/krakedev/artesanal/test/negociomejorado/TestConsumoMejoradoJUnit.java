package com.krakedev.artesanal.test.negociomejorado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumoMejoradoJUnit {

    private NegocioMejorado negocio;
    private Maquina maquina;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        negocio = new NegocioMejorado();

        // Crear máquina
        negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
        maquina = negocio.getMaquinas().get(0);
        maquina.llenarMaquina();

        // Crear cliente
        negocio.registrarCliente("Luis", "123");
        cliente = negocio.getClientes().get(0);
    }

    @Test
    public void testAgregarMaquina_ok() {
        boolean resultado = negocio.agregarMaquina("IPA", "Fuerte", 0.03);
        assertTrue(resultado);
        assertEquals(2, negocio.getMaquinas().size());
    }

    @Test
    public void testAgregarMaquina_codigoDuplicado() {
        String codigo = maquina.getCodigo();

        // Forzar duplicado
        Maquina duplicada = new Maquina("Otra", "Desc", 0.03, codigo);
        negocio.getMaquinas().add(duplicada);

        boolean resultado = negocio.agregarMaquina("Nueva", "Test", 0.05);

        assertTrue(resultado);
    }

    @Test
    public void testRecuperarMaquina_encontrada() {
        Maquina encontrada = negocio.recuperarMaquina(maquina.getCodigo());
        assertNotNull(encontrada);
    }

    @Test
    public void testRecuperarMaquina_noExiste() {
        Maquina encontrada = negocio.recuperarMaquina("M-999");
        assertNull(encontrada);
    }

    @Test
    public void testCargarMaquinas() {
        negocio.agregarMaquina("IPA", "Fuerte", 0.03);

        negocio.cargarMaquinas();

        for (Maquina m : negocio.getMaquinas()) {
            assertTrue(m.getCantidadActual() > 0);
        }
    }

    @Test
    public void testBuscarClientePorCedula_encontrado() {
        Cliente c = negocio.buscarClientePorCedula("123");
        assertNotNull(c);
    }

    @Test
    public void testBuscarClientePorCedula_noExiste() {
        Cliente c = negocio.buscarClientePorCedula("000");
        assertNull(c);
    }

    @Test
    public void testBuscarClientePorCodigo_encontrado() {
        Cliente c = negocio.buscarClientePorCodigo(cliente.getCodigo());
        assertNotNull(c);
    }

    @Test
    public void testBuscarClientePorCodigo_noExiste() {
        Cliente c = negocio.buscarClientePorCodigo(999);
        assertNull(c);
    }

    @Test
    public void testConsumirCerveza_valorCorrecto() {
        double valor = negocio.consumirCerveza(
                cliente.getCodigo(),
                maquina.getCodigo(),
                500
        );

        assertEquals(10.0, valor);
    }

    @Test
    public void testConsumirCerveza_clienteActualizado() {
        negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 500);
        negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 300);

        assertEquals(16.0, cliente.getTotalConsumido());
    }

    @Test
    public void testConsumirCerveza_maquinaDisminuyeCantidad() {
        double inicial = maquina.getCantidadActual();

        negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 200);

        double finalCantidad = maquina.getCantidadActual();

        assertEquals(inicial - 200, finalCantidad);
    }

    @Test
    public void testConsumirCerveza_clienteNoExiste() {
        double valor = negocio.consumirCerveza(999, maquina.getCodigo(), 200);
        assertEquals(0, valor);
    }

    @Test
    public void testConsumirCerveza_maquinaNoExiste() {
        double valor = negocio.consumirCerveza(cliente.getCodigo(), "M-999", 200);
        assertEquals(0, valor);
    }

    @Test
    public void testRegistrarConsumo_clienteNoExiste() {
        // No debe fallar
        negocio.registrarConsumo(999, 10);
        assertTrue(true);
    }
}