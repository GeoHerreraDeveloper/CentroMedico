
package com.centromedico1.modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DoctorDao extends Conexion{
    
    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
   
    //Agregar un usuario doctor
    public String registrarDoctor(Doctor doctorChapatin){
        respuesta = null;
        try {
            this.Conector();
            
            sql = "INSERT INTO Persona values(?,?,?,?,?,?,?,?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, doctorChapatin.getCui());
            ejecutar.setString(2, doctorChapatin.getpNombre());
            ejecutar.setString(3, doctorChapatin.getpApellido());
            ejecutar.setString(4, doctorChapatin.getsNombre());
            ejecutar.setString(5, doctorChapatin.getsApellido());
            ejecutar.setString(6, doctorChapatin.getsApellido());
            ejecutar.setString(7, doctorChapatin.getGenero());
            
            sql = "INSERT INTO Doctor values(?,?,?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, doctorChapatin.getNoColegiado());
            ejecutar.setString(2,doctorChapatin.getUsuario());
            ejecutar.setString(3, doctorChapatin.getContraseña());
            ejecutar.setInt(4, doctorChapatin.getCod_Especialidad());
            ejecutar.setInt(5, doctorChapatin.getCod_Puesto());
            
            ejecutar.executeQuery();
            respuesta = "Registrod Alacenado con éxito";
            
        }catch (SQLException ex){
            System.out.println("Error "+ ex);
            respuesta = "No se pudo almacenar el registro de doctor";
        }finally{
            this.cerrarConexion();
        }
        return respuesta;
    } 
    
    
}
