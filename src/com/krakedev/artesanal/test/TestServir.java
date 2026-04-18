package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		Maquina honey = new Maquina("Honey","Sabor a miel",0.2,5000,"H100");
		
		System.out.println("*********** Estado Inicial Honey 🍺 ***********");
		honey.imprimir();
		
		// Llena la maquina de cerveza honey a maxima capacidad segura:
		System.out.println("*********** Llenando Honey 🍺 ***********");
		honey.llenarMaquina();
		honey.imprimir();
		
		System.out.println("*********** Sirviendo 1000 ml Honey 🍺 ***********");
		double valor = honey.servirCerveza(1000);
		System.out.println("Valor a pagar: $ " + valor);
		
		System.out.println("*********** Sirviendo 3800 ml Honey 🍺 ***********");
		double valor2 = honey.servirCerveza(3800);
		System.out.println("Valor a pagar: $ " + valor2);
		
		System.out.println("*********** Sirviendo 100 ml Honey 🍺 ***********");
		double valor3 = honey.servirCerveza(100);
		System.out.println("Valor a pagar: $ " + valor3);
		honey.imprimir();
	}

}
