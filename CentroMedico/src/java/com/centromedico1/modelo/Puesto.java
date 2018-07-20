package com.centromedico1.modelo;

import java.sql.Date;

public class Puesto extends Departamento {
	private Integer cod_puesto;
	private String nombre_Puesto;
	private Date hora_Inicio;
	private Date hora_Fin;
	private Boolean salario;
	private Date inicia_Puesto;
	private Integer cod_depto;
	
	public Puesto () {
		super();
		this.cod_puesto = null;
		this.nombre_Puesto = null;
		this.hora_Inicio = null;
		this.hora_Fin = null;
		this.salario = null;
		this.inicia_Puesto = null;
		this.cod_depto = null;
	}
	
	

	public Puesto(Integer cod_puesto, String nombre_Puesto, Date hora_Inicio, Date hora_Fin, Boolean salario,
			Date inicia_Puesto, Integer cod_depto) {
		super();
		this.cod_puesto = cod_puesto;
		this.nombre_Puesto = nombre_Puesto;
		this.hora_Inicio = hora_Inicio;
		this.hora_Fin = hora_Fin;
		this.salario = salario;
		this.inicia_Puesto = inicia_Puesto;
		this.cod_depto = cod_depto;
	}



	public Integer getCod_puesto() {
		return cod_puesto;
	}

	public void setCod_puesto(Integer cod_puesto) {
		this.cod_puesto = cod_puesto;
	}

	public String getNombre_Puesto() {
		return nombre_Puesto;
	}

	public void setNombre_Puesto(String nombre_Puesto) {
		this.nombre_Puesto = nombre_Puesto;
	}

	public Date getHora_Inicio() {
		return hora_Inicio;
	}

	public void setHora_Inicio(Date hora_Inicio) {
		this.hora_Inicio = hora_Inicio;
	}

	public Date getHora_Fin() {
		return hora_Fin;
	}

	public void setHora_Fin(Date hora_Fin) {
		this.hora_Fin = hora_Fin;
	}

	public Boolean getSalario() {
		return salario;
	}

	public void setSalario(Boolean salario) {
		this.salario = salario;
	}

	public Date getInicia_Puesto() {
		return inicia_Puesto;
	}

	public void setInicia_Puesto(Date inicia_Puesto) {
		this.inicia_Puesto = inicia_Puesto;
	}

	public Integer getCod_depto() {
		return cod_depto;
	}

	public void setCod_depto(Integer cod_depto) {
		this.cod_depto = cod_depto;
	}
	
	
	
	
}
