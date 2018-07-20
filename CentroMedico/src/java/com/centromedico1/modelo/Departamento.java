package com.centromedico1.modelo;

public class Departamento {
	
	protected int codDepartamento;
	protected String nombre;
	protected String descripcion;
	
	//CONSTRUCTOR VACIO
	public Departamento(){
		this.codDepartamento = 0;
		this.nombre = null;
		this.descripcion = null;
	}
	
	public Departamento(int codDepartamento, String nombre, String descripcion) {
		this.codDepartamento = codDepartamento;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
	//METODOS DE ACCESO
	public int getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
