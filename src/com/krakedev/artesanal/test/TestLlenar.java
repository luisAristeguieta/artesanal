package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		
		Maquina honey = new Maquina("Honey","Sabor a miel",0.2,5000,"H100");
		Maquina ipa = new Maquina("Ginger","Sabor a gengibre",0.2,"G100");
		
		honey.imprimir();
		honey.llenarMaquina();
		honey.imprimir();
		
		ipa.imprimir();
		ipa.llenarMaquina();
		ipa.imprimir();
	}

}
