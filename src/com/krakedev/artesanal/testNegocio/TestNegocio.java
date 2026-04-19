package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {

	public static void main(String[] args) {
		
		Maquina nueva = new Maquina("Monkey IPA", "Sabor natural", 0.02, 10000, "M100");
		Negocio negocio1 = new Negocio("Principal",nueva);
		
		
		System.out.println("Nombre: " + negocio1.getNombre());
		System.out.println("Maquina: " + negocio1.getMaquinaA().getCodigo());
		
		Maquina m1 = negocio1.getMaquinaA();
		String codigo = m1.getCodigo();
		
		
	}

}
