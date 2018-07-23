package com.centromedico1.dao;

import com.centromedico1.modelo.Conexion;
import com.centromedico1.modelo.Especialidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EspecialidadDao extends Conexion {
    
    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    
    //Agrega la especialidad
    public String nuevaEspecialidad (Especialidad Especialidad0){
        respuesta = null;
        try{
            this.Conector();
            sql = "INSERT INTO especialidad VALUES ?, ?, ?,";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            
            ejecutar.setInt(1, Especialidad0.getCodEspecialidad());
            ejecutar.setString(2, Especialidad0.getNombre());
            ejecutar.setString(3, Especialidad0.getDescripcion());
            
            ejecutar.executeUpdate();
            respuesta = "Especialidad agregada con exito";
           
        } catch (SQLException ex){
            System.out.println("Error en Statement"+ ex);
            respuesta = "No se puedo almacenar el registro";
        }finally{
            this.cerrarConexion();
        }
        return respuesta;
    }
    
    //Buscar un puesto
    public ArrayList<Especialidad> listaEspecialidad(){
        ArrayList<Especialidad> lista = null;
        ResultSet resultado;
        try{
            this.Conector();
            sql = "SELECT * FROM especialidad WHERE codEspecialidad = ?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            
            resultado = ejecutar.executeQuery();
            lista = new ArrayList();
            while(resultado.next()){
                Especialidad Especialidad0 = new Especialidad();
                
                Especialidad0.setCodEspecialidad(resultado.getInt("codEspecialidad"));
                Especialidad0.setNombre(resultado.getString("nombre"));
                Especialidad0.setDescripcion(resultado.getString("descripcion"));
                
                lista.add(Especialidad0);
            }
        } catch(Exception e){
            System.out.println("Error en "+e);
                     
        } finally{
            this.cerrarConexion();
        }
        return lista;
        
    }
    
    public String modificarEspecialidad(Especialidad datos){
        try{
            this.Conector();
            sql = "UPDATE especialidad SET codEspecialidad = ?, nombre = ?, descripcion = ?";
            ejecutar.setInt(1, datos.getCodEspecialidad());
            ejecutar.setString(2, datos.getNombre());
            ejecutar.setString(3, datos.getDescripcion());
            
            respuesta = "Datos modificados con Éxito!";
            
        } catch (SQLException ex){
            System.out.println("Error en conexion: "+ex);
            respuesta = "No se puede modificar";
        } finally {
            this.cerrarConexion();
        }
        return respuesta;
    }
    
    
    
    
}
