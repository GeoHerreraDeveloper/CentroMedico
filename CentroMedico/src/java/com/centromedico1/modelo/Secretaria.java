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
	

	public Secretaria(Integer cui, String pNombre, String pApellido, String sNombre, String sApellido, String genero,
			Date fechaNacimiento, String direccion, Integer telefono, String email, Integer cod_Secretaria, String user,
			 String pass, Integer cod_Puesto) {
		super(cui, pNombre, pApellido, sNombre, sApellido, genero, fechaNacimiento, direccion, telefono, email);
		// TODO Auto-generated constructor stub
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
