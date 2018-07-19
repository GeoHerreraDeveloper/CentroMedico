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
    private Integer Cui;
    private String pNombre;
    private String pApellido;
    private String sNombre;
    private String sApellido;
    private String Genero;
    private Date FechaNacimiento;
    private String Direccion;
    private Integer Telefono;
    private String Email;
    
    public Personas(){
        this.Cui = null;
        this.pNombre = null;
        this.pApellido = null;
        this.sNombre = null;
        this.sApellido = null;
        this.Genero = null;
        this.FechaNacimiento = null;
        this.Direccion = null;
        this.Telefono = null;
        this.Email = null;
    }
    public Personas(Integer Cui, String pNombre, String pApellido, String sNombre, String sApellido, String Genero, Date FechaNacimiento, String Direccion, Integer Telefono, String Email) {
        this.Cui = Cui;
        this.pNombre = pNombre;
        this.pApellido = pApellido;
        this.sNombre = sNombre;
        this.sApellido = sApellido;
        this.Genero = Genero;
        this.FechaNacimiento = FechaNacimiento;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public Integer getCui() {
        return Cui;
    }

    public void setCui(Integer Cui) {
        this.Cui = Cui;
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
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
            }
