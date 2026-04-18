package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		
		Maquina ipa = new Maquina("Ginger","Sabor a gengibre",0.2,"H100");
		
		ipa.setNombreCerveza("Ginger V2");
		ipa.setDescripcion("Doblemente fuerte en sabor");
		ipa.setPrecioPorMl(0.3);
		ipa.imprimir();
		
		Maquina honey = new Maquina("Honey","Sabor a miel",0.2,5000,"H100");
		
		honey.imprimir();
	}

}
