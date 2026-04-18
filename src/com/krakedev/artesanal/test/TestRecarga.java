package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecarga {

	public static void main(String[] args) {
		
		Maquina honey = new Maquina("Honey","Sabor a miel",0.2,5000,"H100");
		
		System.out.println("*********** Recarga # 1 Honey 🍺 ***********");
		honey.recargarCerveza(2000);
		honey.imprimir();
		
		System.out.println("*********** Recarga # 2 Honey 🍺 ***********");
		honey.recargarCerveza(1000);
		honey.imprimir();
		
		System.out.println("*********** Recarga # 2 Honey 🍺 ***********");
		honey.recargarCerveza(1900);
		honey.imprimir();

	}

}
