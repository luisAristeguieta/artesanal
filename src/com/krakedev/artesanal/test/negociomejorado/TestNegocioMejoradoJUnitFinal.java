package com.krakedev.artesanal.test.negociomejorado;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejoradoJUnitFinal {
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
        // Se prueba: agregar máquina correctamente
        // Resultado esperado: true y tamaño incrementa

        boolean resultado = negocio.agregarMaquina("IPA", "Fuerte", 0.03);

        assertTrue(resultado);
        assertEquals(2, negocio.getMaquinas().size());
    }

    @Test
    public void testRecuperarMaquina_encontrada() {
        // Se prueba: búsqueda existente
        // Resultado esperado: objeto no null

        Maquina encontrada = negocio.recuperarMaquina(maquina.getCodigo());

        assertNotNull(encontrada);
    }

    @Test
    public void testRecuperarMaquina_noExiste() {
        // Se prueba: búsqueda inexistente
        // Resultado esperado: null

        Maquina encontrada = negocio.recuperarMaquina("M-999");

        assertNull(encontrada);
    }

    @Test
    public void testCargarMaquinas() {
        // Se prueba: llenado de máquinas
        // Resultado esperado: cantidadActual > 0

        negocio.agregarMaquina("IPA", "Fuerte", 0.03);

        negocio.cargarMaquinas();

        for (Maquina m : negocio.getMaquinas()) {
            assertTrue(m.getCantidadActual() > 0);
        }
    }

    @Test
    public void testBuscarClientePorCedula_encontrado() {
        // Se prueba: búsqueda por cédula existente
        // Resultado esperado: no null

        Cliente c = negocio.buscarClientePorCedula("123");

        assertNotNull(c);
    }

    @Test
    public void testBuscarClientePorCedula_noExiste() {
        // Se prueba: cédula inexistente
        // Resultado esperado: null

        Cliente c = negocio.buscarClientePorCedula("000");

        assertNull(c);
    }

    @Test
    public void testBuscarClientePorCodigo_encontrado() {
        // Se prueba: búsqueda por código existente
        // Resultado esperado: no null

        Cliente c = negocio.buscarClientePorCodigo(cliente.getCodigo());

        assertNotNull(c);
    }

    @Test
    public void testBuscarClientePorCodigo_noExiste() {
        // Se prueba: código inexistente
        // Resultado esperado: null

        Cliente c = negocio.buscarClientePorCodigo(999);

        assertNull(c);
    }

    @Test
    public void testConsumirCerveza_valorCorrecto() {
        // Se prueba: cálculo correcto del consumo
        // Resultado esperado: cantidad * precio

        double valor = negocio.consumirCerveza(
                cliente.getCodigo(),
                maquina.getCodigo(),
                500
        );

        assertEquals(10.0, valor);
    }

    @Test
    public void testConsumirCerveza_clienteActualizado() {
        // Se prueba: acumulación en cliente
        // Resultado esperado: suma correcta

        negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 500);
        negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 300);

        assertEquals(16.0, cliente.getTotalConsumido());
    }

    @Test
    public void testConsumirCerveza_maquinaDisminuyeCantidad() {
        // Se prueba: reducción en máquina
        // Resultado esperado: disminuye cantidadActual

        double inicial = maquina.getCantidadActual();

        negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 200);

        double finalCantidad = maquina.getCantidadActual();

        assertEquals(inicial - 200, finalCantidad);
    }

    @Test
    public void testConsumirCerveza_clienteNoExiste() {
        // Se prueba: cliente inexistente
        // Resultado esperado: retorna 0

        double valor = negocio.consumirCerveza(999, maquina.getCodigo(), 200);

        assertEquals(0, valor);
    }

    @Test
    public void testConsumirCerveza_maquinaNoExiste() {
        // Se prueba: máquina inexistente
        // Resultado esperado: retorna 0

        double valor = negocio.consumirCerveza(cliente.getCodigo(), "M-999", 200);

        assertEquals(0, valor);
    }

    @Test
    public void testRegistrarConsumo_clienteNoExiste() {
        // Se prueba: no falla si cliente no existe

        negocio.registrarConsumo(999, 10);

        assertTrue(true);
    }

    @Test
    public void testConsultarValorVendido_sinConsumos() {
        // Se prueba: sin consumo
        // Resultado esperado: 0

        NegocioMejorado n = new NegocioMejorado();
        n.registrarCliente("Luis", "123");
        n.registrarCliente("Maria", "456");

        double total = n.consultarValorVendido();

        assertEquals(0, total);
    }

    @Test
    public void testConsultarValorVendido_conConsumos() {
        // Se prueba: suma total entre clientes
        // Resultado esperado: suma correcta

        negocio.registrarCliente("Maria", "456");
        Cliente c2 = negocio.getClientes().get(1);

        negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 500); // 10
        negocio.consumirCerveza(c2.getCodigo(), maquina.getCodigo(), 300); // 6

        double total = negocio.consultarValorVendido();

        assertEquals(16.0, total);
    }
}
