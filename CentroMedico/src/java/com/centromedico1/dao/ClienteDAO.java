/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centromedico1.dao;

import com.centromedico1.modelo.Cliente;
import com.centromedico1.modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario Geovanni
 */
public class ClienteDAO extends Conexion {
    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    
    //Agregar nuevo cliente
    public String registrarCliente(Cliente clientex){
        respuesta=null;
        try {
            this.Conector();
            sql = "insert into Persona values(?,?,?,?,?,?,?,?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, clientex.getCui());
            ejecutar.setString(2, clientex.getpNombre());
            ejecutar.setString(3, clientex.getpApellido());
            ejecutar.setString(4, clientex.getsNombre());
            ejecutar.setString(5, clientex.getsApellido());
            ejecutar.setString(6, clientex.getGenero());
            ejecutar.setDate(7, clientex.getFechaNacimiento());
            ejecutar.setString(8, clientex.getDireccion());
            ejecutar.setInt(9, clientex.getTelefono());
            ejecutar.setString(10, clientex.getEmail());
            
            sql = "insert into Cliente values(?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, clientex.getCod_cliente());
            ejecutar.setInt(2, clientex.getCui());
            
            ejecutar.executeUpdate();
            respuesta="Registro Almacenado con Exito";
            
        }catch(SQLException ex){
            System.out.println("Error en Statement"+ex);
            respuesta="No se pudo almacenar el registro";
        }finally {
            this.cerrarConexion();
        }
        return respuesta;
    }
    
    //BUSCAR
    public ArrayList<Cliente> listaClientes(){
        ArrayList<Cliente> lista= null;
        ResultSet resultado;
        try {
            this.Conector();
            sql= "select * from Cliente";
            ejecutar= this.getMiconexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            lista = new ArrayList();
            while (resultado.next()){
                Cliente clientex = new Cliente();
                clientex.setCod_cliente(resultado.getInt("Cod_cliente"));
                clientex.setCui(resultado.getInt("Cui"));
                clientex.setpNombre(resultado.getString("pNombre"));
                clientex.setpApellido(resultado.getString("pApellido"));
                clientex.setsNombre(resultado.getString("sNombre"));
                clientex.setsApellido(resultado.getString("sApellido"));
                clientex.setGenero(resultado.getString("Genero"));
                clientex.setFechaNacimiento(resultado.getDate("FechaNacimiento"));
                clientex.setDireccion(resultado.getString("Direccion"));
                clientex.setTelefono(resultado.getInt("Telefono"));
                clientex.setEmail(resultado.getString("Email"));
                
                lista.add(clientex);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        } finally {
            this.cerrarConexion();
        }
        return lista;
    }
    
}
