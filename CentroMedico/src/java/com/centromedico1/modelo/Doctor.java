
package com.centromedico1.modelo;

import java.sql.Date;


public class Doctor extends Personas {
    
    private int NoColegiado;
    private String Usuario;
    private String Contraseña;
    private int Cod_Especialidad;
    private int Cod_Puesto;

    public Doctor() {
        super();
        this.NoColegiado = 0;
        this.Usuario = null;
        this.Contraseña = null;
        this.Cod_Especialidad = 0;
        this.Cod_Puesto = 0;
       
    }

    public Doctor(int NoColegiado, String Usuario, String Contraseña, int Cod_Especialidad, int Cod_Puesto, Integer Cui, String pNombre, String pApellido, String sNombre, String sApellido, String Genero, Date FechaNacimiento, String Direccion, Integer Telefono, String Email) {
        super(Cui, pNombre, pApellido, sNombre, sApellido, Genero, FechaNacimiento, Direccion, Telefono, Email);
        this.NoColegiado = NoColegiado;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Cod_Especialidad = Cod_Especialidad;
        this.Cod_Puesto = Cod_Puesto;
    }
  
    public int getNoColegiado() {
        return NoColegiado;
    }

    public void setNoColegiado(int NoColegiado) {
        this.NoColegiado = NoColegiado;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getCod_Especialidad() {
        return Cod_Especialidad;
    }

    public void setCod_Especialidad(int Cod_Especialidad) {
        this.Cod_Especialidad = Cod_Especialidad;
    }

    public int getCod_Puesto() {
        return Cod_Puesto;
    }

    public void setCod_Puesto(int Cod_Puesto) {
        this.Cod_Puesto = Cod_Puesto;
    }
    
    
    
    
    

   }

   
    
    
    
    
    
    
    

