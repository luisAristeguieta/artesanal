package com.krakedev.artesanal.test.negociomejorado;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestBuscarClientePorCodigo {

    public static void main(String[] args) {
    	// Valida el codigo del cliente y devuelve el cliente de existir en la lista de negocios
    	
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.registrarCliente("Luis", "17562728211"); // código 100
        negocio.registrarCliente("Maria", "0912345678"); // código 101

        Cliente clienteConsultado = negocio.buscarClientePorCodigo(100);

        if (clienteConsultado != null) {
            System.out.println("El cliente con el código 100 es : " + clienteConsultado.getNombre());
        } else {
            System.out.println("Código No encontrado");
        }

        Cliente clienteConsultado2 = negocio.buscarClientePorCodigo(999);

        if (clienteConsultado2 != null) {
            System.out.println("El cliente con el código 999 es :" + clienteConsultado2.getNombre());
        } else {
            System.out.println("Código No encontrado");
        }
    }
}