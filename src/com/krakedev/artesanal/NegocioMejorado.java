package com.krakedev.artesanal;

import java.util.ArrayList;


public class NegocioMejorado {
	ArrayList<Maquina> maquinas;

	public NegocioMejorado() {
		this.maquinas = new ArrayList<Maquina>();
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public String generarCodigo() {
		// En la clase maquina hay un atributo codigo pero no estaba con un formato para esto existe este metodo
		int numeroAleatorio = (int)(Math.random() * 100) + 1;
		return "M-" + numeroAleatorio;
	}
	
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		// Metodo que agrega maquinas a la lista existente adicionando el codigo del metodo anterior
	    String codigo = generarCodigo();
	    Maquina nueva = new Maquina(nombreCerveza, descripcion, precioPorMl, codigo);
	    return maquinas.add(nueva);
	}
}
