package com.telefonica.barcos;

public class Barco extends Thread {
	private String matricula;
	private String modelo;
	private String descripcion;

	public Barco(String matricula){
		this.matricula = matricula;
	}
	public Barco(String matricula, String modelo, String descripcion){
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
