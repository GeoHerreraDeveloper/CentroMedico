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
public class Cliente extends Personas{
    private Integer Cod_cliente;

    public Cliente() {
        super();
        this.Cod_cliente=0;
    }

    public Cliente(Integer Cod_cliente, Integer Cui, String pNombre, String pApellido, String sNombre, String sApellido, String Genero, Date FechaNacimiento, String Direccion, Integer Telefono, String Email) {
        super(Cui, pNombre, pApellido, sNombre, sApellido, Genero, FechaNacimiento, Direccion, Telefono, Email);
        this.Cod_cliente = Cod_cliente;
    }

    public Integer getCod_cliente() {
        return Cod_cliente;
    }

    public void setCod_cliente(Integer Cod_cliente) {
        this.Cod_cliente = Cod_cliente;
    }
    
    
    
    
}
