package com.krakedev.artesanal.test.negociomejorado;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumoMejorado {

	public static void main(String[] args) {
		// Se modifico el metodo consumirCerveza agrrgando registrarConsumo que acumula valores
		// Igual se crea el negocio, se agrega la maquina, se llena, se crea el cliente y se registran varios consumos
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
        Maquina maquina = negocio.getMaquinas().get(0);
        maquina.llenarMaquina();
        
        negocio.registrarCliente("Luis", "17562728211");
        Cliente cliente = negocio.getClientes().get(0);

        int codigoCliente = cliente.getCodigo();
        String codigoMaquina = maquina.getCodigo();

        double consumo1 = negocio.consumirCerveza(codigoCliente, codigoMaquina, 500);
        double consumo2 = negocio.consumirCerveza(codigoCliente, codigoMaquina, 300);
        double consumo3 = negocio.consumirCerveza(codigoCliente, codigoMaquina, 200);

        System.out.println("Consumo 1: " + consumo1);
        System.out.println("Consumo 2: " + consumo2);
        System.out.println("Consumo 3: " + consumo3);

        System.out.println("\n=== TOTAL ACUMULADO ===");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Total consumido: " + cliente.getTotalConsumido());

	}

}
