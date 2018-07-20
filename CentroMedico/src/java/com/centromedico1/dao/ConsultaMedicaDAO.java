/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centromedico1.dao;

import com.centromedico1.modelo.Conexion;
import com.centromedico1.modelo.ConsultaMedica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConsultaMedicaDAO extends Conexion{
    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    
    //Crear Consulta
    public String crearConsultaMedica(ConsultaMedica consultax){
        respuesta=null;
        try {
            this.Conector();
            sql= "insert into consultamedia values (?,?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, consultax.getCod_Consulta_Medic());
            ejecutar.setString(2, consultax.getDescripcion());
            ejecutar.setInt(3, consultax.getCodCita());
            ejecutar.setString(4, consultax.getNoColegiado());
            ejecutar.executeUpdate();
            respuesta="Registro Almacenado con Exito";
            
        } catch (SQLException ex) {
            respuesta="No se pudo almacenar el registro";
        }finally {
            this.cerrarConexion();
        }
        return respuesta;
    }
    
    //BUSCAR
    public ArrayList<ConsultaMedica> listaConsultaMedica (){
        ArrayList<ConsultaMedica> lista= null;
        ResultSet resultado;
        try {
            this.Conector();
            sql= "SELECT * FROM consultamedia";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            resultado= ejecutar.executeQuery();
            lista = new ArrayList ();
            while (resultado.next()){
                ConsultaMedica consultax = new ConsultaMedica();
                consultax.setCod_Consulta_Medic(resultado.getInt("codConsultaMedica"));
                consultax.setDescripcion(resultado.getString("descripcionConsulta"));
                consultax.setCodCita(resultado.getInt("codCita"));
                consultax.setNoColegiado(resultado.getString("noColegiado"));
                consultax.setCodCliente(resultado.getInt("codCliente"));
                
                lista.add(consultax);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        } finally {
            this.cerrarConexion();
        }
        return lista;
    }
    
    //MODIFICAR
    public String actualizarConsultaMedica(ConsultaMedica datos){
        try{
            this.Conector();
            sql="UPDATE consultamedia SET Descripcion=? WHERE Cod_Consulta_Medic=?" ;
            ejecutar= this.getMiconexion().prepareStatement(sql);
            ejecutar.setString(1, datos.getDescripcion());
            ejecutar.executeUpdate();
            respuesta= "Datos modificados con exito";
            
        } catch (SQLException ex) {
            respuesta= "No se pudo modificar, Error en conexion:"+ ex;
        } 
        return respuesta;
    }
}

