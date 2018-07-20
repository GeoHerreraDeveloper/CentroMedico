
package com.centromedico1.modelo;

import java.sql.Date;


public class Doctor extends Personas {
    
    private int noColegiado;
    private String usuario;
    private String contraseña;
    private int codEspecialidad;
    private int codPuesto;

    public Doctor() {
        super();
        this.noColegiado = 0;
        this.usuario = null;
        this.contraseña = null;
        this.codEspecialidad = 0;
        this.codPuesto = 0;
       
    }

    public Doctor(int noColegiado, String usuario, String contraseña, int codEspecialidad, int codPuesto, Integer cui, String pNombre, String pApellido, String sNombre, String sApellido, String genero, Date fechaNacimiento, String direccion, Integer telefono, String email) {
        super(cui, pNombre, pApellido, sNombre, sApellido, genero, fechaNacimiento, direccion, telefono, email);
        this.noColegiado = noColegiado;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.codEspecialidad = codEspecialidad;
        this.codPuesto = codPuesto;
    }

    public int getNoColegiado() {
        return noColegiado;
    }

    public void setNoColegiado(int noColegiado) {
        this.noColegiado = noColegiado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(int codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public int getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(int codPuesto) {
        this.codPuesto = codPuesto;
    }
    
    
    
   }