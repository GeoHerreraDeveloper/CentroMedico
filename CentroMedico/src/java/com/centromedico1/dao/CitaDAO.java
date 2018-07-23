/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centromedico1.dao;

import com.centromedico1.modelo.Cita;
import com.centromedico1.modelo.Conexion;
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
public class CitaDAO extends Conexion{
    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    
    //Cita nueva
    
     public String nuevaCita (Cita citaN){
respuesta= null;
    try{
            this.Conector();
            sql = "INSERT INTO cita VALUES (?,?,?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, citaN.getCodCita());
            ejecutar.setDate(2, citaN.getFechaHora());
            ejecutar.setString(3, citaN.getDescripcion());
            ejecutar.setInt(4, citaN.getCodCliente());
            ejecutar.setInt(5, citaN.getCodSecretaria());
}catch (SQLException ex) {
        System.out.println("Error en Statement" + ex);
        respuesta = "No se pudo almacenar el registro";
} finally {
    this.cerrarConexion();
    }
return respuesta;
}
     
    //Buscar Ccita
     
     public ArrayList<Cita> listaCitas(){
         ArrayList<Cita> lista = null;
         ResultSet resultado;
         try{
             this.Conector();
             sql = "SELECT * FROM cita";
             ejecutar = this.getMiconexion().prepareStatement(sql);
             resultado = ejecutar.executeQuery();
             lista = new ArrayList();
             while (resultado.next()){
                 Cita citaN = new Cita();
                 citaN.setCodCita(resultado.getInt("codCita"));
                 citaN.setFechaHora(resultado.getDate("fechaHora"));
                 citaN.setDescripcion(resultado.getString("descripcion"));
                 citaN.setCodCliente(resultado.getInt("codCliente"));
                 citaN.setCodSecretaria(resultado.getInt("codSecretaria"));
                 
             }
             }catch (Exception e){
             System.out.println("error" + e);
             }finally {
             this.cerrarConexion();
         }
         return lista;
         }
     
     
         //MODIFICAR
    public String actualizarCita(Cita datos){
        try {
            this.Conector();
            sql="update cita set codCita=?, fechaHora=?, descripcion=?, codCliente=?, codSecretaria=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
                 //Cita citaN = new Cita();
                 ejecutar.setInt(1, datos.getCodCita());
                 ejecutar.setDate(2, datos.getFechaHora());
                 ejecutar.setString(3, datos.getDescripcion());
                 ejecutar.setInt(4, datos.getCodCliente());
                 ejecutar.setInt(5, datos.getCodSecretaria());
  
            ejecutar.executeUpdate();
            respuesta = "Datos modificados con exito";
            
        } catch (SQLException ex) {
            System.out.println("Error en conexion: "+ ex);
            respuesta= "No se puede modificar";
        }
        return respuesta;
    }
     
    
     
     }

   