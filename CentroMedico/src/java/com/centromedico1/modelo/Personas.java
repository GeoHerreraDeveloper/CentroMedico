/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centromedico1.modelo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Personas {
    protected Integer cui;
    protected String pNombre;
    protected String pApellido;
    protected String sNombre;
    protected String sApellido;
    protected String genero;
    protected Date fechaNacimiento;
    protected String direccion;
    protected Integer telefono;
    protected String email;
    
    public Personas(){
        this.cui = null;
        this.pNombre = null;
        this.pApellido = null;
        this.sNombre = null;
        this.sApellido = null;
        this.genero = null;
        this.fechaNacimiento = null;
        this.direccion = null;
        this.telefono = null;
        this.email = null;
    }
    public Personas(Integer cui, String pNombre, String pApellido, String sNombre, String sApellido, String genero, Date fechaNacimiento, String direccion, Integer telefono, String email) {
        this.cui = cui;
        this.pNombre = pNombre;
        this.pApellido = pApellido;
        this.sNombre = sNombre;
        this.sApellido = sApellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

   
    public Integer getCui() {
		return cui;
	}
	public void setCui(Integer cui) {
		this.cui = cui;
	}
	public String getpNombre() {
		return pNombre;
	}
	public void setpNombre(String pNombre) {
		this.pNombre = pNombre;
	}
	public String getpApellido() {
		return pApellido;
	}
	public void setpApellido(String pApellido) {
		this.pApellido = pApellido;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getsApellido() {
		return sApellido;
	}
	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
        
            }
