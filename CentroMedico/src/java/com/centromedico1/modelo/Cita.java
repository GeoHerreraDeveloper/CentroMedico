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
public class Cita {
    private Integer codCita;
    private Date fechaHora;
    private String descripcion;
    private Integer codCliente;
    private Integer codSecretaria;

    public Cita() {
        this.codCita = 0;
        this.fechaHora = null;
        this.descripcion = null;
        this.codCliente = 0;
        this.codSecretaria = 0;
    }

    
    public Cita(Integer codCita, Date fechaHora, String descripcion, Integer codCliente, Integer codSecretaria) {
        this.codCita = codCita;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.codCliente = codCliente;
        this.codSecretaria = codSecretaria;
    }

    public Integer getCodCita() {
        return codCita;
    }

    public void setCodCita(Integer codCita) {
        this.codCita = codCita;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodSecretaria() {
        return codSecretaria;
    }

    public void setCodSecretaria(Integer codSecretaria) {
        this.codSecretaria = codSecretaria;
    }
    


           
}
