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
    public Personas(Integer Cui, String pNombre, String pApellido, String sNombre, String sApellido, String Genero, Date FechaNacimiento, String Direccion, Integer Telefono, String Email) {
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
    }

    public Integer getCui() {
        return cui;
    }

    public void setCui(Integer Cui) {
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

    public void setGenero(String Genero) {
        this.genero = Genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.fechaNacimiento = FechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer Telefono) {
        this.telefono = Telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }
    
    
            }
