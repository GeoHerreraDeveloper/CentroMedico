
package com.centromedico1.modelo;


public class Especialidad {
    
    private int codEspecialidad;
    private String nombre;
    private String descripcion;
    
    public Especialidad(){
        super();
        this.codEspecialidad = 0;
        this.nombre = null;
        this.descripcion = null;
    }

    public Especialidad(int codEspecialidad, String nombre, String descripcion) {
        this.codEspecialidad = codEspecialidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(int codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
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
