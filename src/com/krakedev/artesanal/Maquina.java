package com.krakedev.artesanal;

public class Maquina {
	private String nombreCerveza;
	private String descripcion;
	public double precioPorMl;
	public double capacidadMaxima;
	public double cantidadActual;

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(double capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public void imprimir() {
		String mensaje = "Nombre Cerveza: " + nombreCerveza + " , Descripcion: " + descripcion + " , Precio por Ml: "
				+ precioPorMl + " , Capacidad Maxima:" + capacidadMaxima + " , Cantidad Actual:" + cantidadActual;
		System.out.println(mensaje);
	}

}
