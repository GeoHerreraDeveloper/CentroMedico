package com.centromedico1.modelo;

import java.sql.Date;

public class Secretaria extends Personas {
	private Integer cod_Secretaria;
	private String user;
	private String pass;
	private Integer cod_Puesto;
	
	Secretaria() {
		super();
		this.cod_Secretaria = 0;
		this.user = null;
		this.pass = null;
		this.cod_Puesto = null;
	}
	

	public Secretaria(Integer Cui, String pNombre, String pApellido, String sNombre, String sApellido, String Genero,
			Date FechaNacimiento, String Direccion, Integer Telefono, String Email, Integer cod_Secretaria, String user,
			 String pass, Integer cod_Puesto) {
	this.cui = Cui;
        this.pNombre = pNombre;
        this.pApellido = pApellido;
        this.sNombre = sNombre;
        this.sApellido = sApellido;
        this.genero = Genero;
        this.fechaNacimiento = FechaNacimiento;
        this.direccion = Direccion;
        this.telefono = Telefono;
        this.email = Email;
        this.cod_Secretaria = cod_Secretaria;
		this.user = user;
		this.pass = pass;
		this.cod_Puesto = cod_Puesto;
		
	}

	public Integer getCod_Secretaria() {
		return cod_Secretaria;
	}

	public void setCod_Secretaria(Integer cod_Secretaria) {
		this.cod_Secretaria = cod_Secretaria;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getCod_Puesto() {
		return cod_Puesto;
	}

	public void setCod_Puesto(Integer cod_Puesto) {
		this.cod_Puesto = cod_Puesto;
	}

		
}
