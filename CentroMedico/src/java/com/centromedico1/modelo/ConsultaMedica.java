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
public class ConsultaMedica extends Cita{
    private Integer codConsultaMedic;
    private String descripcion;
    private String noColegiado;

    public ConsultaMedica() {
        this.codConsultaMedic = 0;
        this.descripcion = null;
        this.noColegiado = null;
    }

    public ConsultaMedica(Integer Cod_Consulta_Medic, String Descripcion, String NoColegiado, Integer codCita, Date fechaHora, String descripcion, Integer codCliente, Integer codSecretaria) {
        super(codCita, fechaHora, descripcion, codCliente, codSecretaria);
        this.codConsultaMedic = Cod_Consulta_Medic;
        this.descripcion = Descripcion;
        this.noColegiado = NoColegiado;
    }

    public Integer getCod_Consulta_Medic() {
        return codConsultaMedic;
    }

    public void setCod_Consulta_Medic(Integer Cod_Consulta_Medic) {
        this.codConsultaMedic = Cod_Consulta_Medic;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public String getNoColegiado() {
        return noColegiado;
    }

    public void setNoColegiado(String NoColegiado) {
        this.noColegiado = NoColegiado;
    }
    
    
    
    
}
