package com.centromedico1.modelo;

public class Medicamento {
	
	private int codMedicamento;
	private String nombre;
	private String descripcion;
	private String presentacion;
	
	public Medicamento() {
		this.codMedicamento = 0;
		this.nombre = null;
		this.descripcion = null;
		this.presentacion = null;
	}
	
	public Medicamento(int codMedicamento, String nombre, String descripcion, String presentacion) {
		this.codMedicamento = codMedicamento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.presentacion = presentacion;
	}

	public int getCodMedicamento() {
		return codMedicamento;
	}

	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
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

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	
	
}
