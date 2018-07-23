
package com.centromedico1.dao;

import com.centromedico1.modelo.Conexion;
import com.centromedico1.modelo.Doctor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
            ejecutar.setString(6, doctorChapatin.getGenero());
            ejecutar.setDate(7, doctorChapatin.getFechaNacimiento());
            ejecutar.setString(8, doctorChapatin.getDireccion());
            ejecutar.setInt(9, doctorChapatin.getTelefono());
            ejecutar.setString(10, doctorChapatin.getEmail());
            
            sql = "INSERT INTO Doctor values(?,?,?,?,?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, doctorChapatin.getNoColegiado());
            ejecutar.setString(2,doctorChapatin.getUsuario());
            ejecutar.setString(3, doctorChapatin.getContraseña());
            ejecutar.setInt(4, doctorChapatin.getCodEspecialidad());
            ejecutar.setInt(5, doctorChapatin.getCodPuesto());
            
            ejecutar.executeQuery();
            respuesta = "Registrod Almacenado con éxito";
            
        }catch (SQLException ex){
            System.out.println("Error "+ ex);
            respuesta = "No se pudo almacenar el registro de doctor";
        }finally{
            this.cerrarConexion();
        }
        return respuesta;
    } 
    
    //Buscar la especialidad
    public ArrayList <Doctor> listaDoctor(){
        ArrayList<Doctor> lista = null;
        ResultSet resultado;
        try {
            this.Conector();
            sql = "SELECT * FROM doctor";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            
            resultado = ejecutar.executeQuery();
            lista = new ArrayList();
            
            while (resultado.next()){
                //Datos de persona
                Doctor doctor0 = new Doctor();
                doctor0.setpNombre(resultado.getString("pNombre"));
                doctor0.setpApellido(resultado.getString("pApellido"));
                doctor0.setsNombre(resultado.getString("sNombre"));
                doctor0.setsApellido(resultado.getString("sApellido"));
                doctor0.setGenero(resultado.getString("genero"));
                doctor0.setFechaNacimiento(resultado.getDate("fechaNacimiento"));
                doctor0.setDireccion(resultado.getString("direccion"));
                doctor0.setTelefono(resultado.getInt("telefono"));
                doctor0.setEmail(resultado.getString("email"));
                //Datos de Doctor
                doctor0.setNoColegiado(resultado.getInt("noColegiado"));
                doctor0.setUsuario(resultado.getString("usuario"));
                doctor0.setContraseña(resultado.getString("contraseña"));
                doctor0.setCodEspecialidad(resultado.getInt("codEspecialidad"));
                doctor0.setCodPuesto(resultado.getInt("codPuesto"));
                
                lista.add(doctor0);
            }
        }catch (SQLException ex){
            System.out.println("Error "+ ex);
        }finally{
            this.cerrarConexion();
        }
        return lista;
    }
   
    public String eliminarDoctor(int NoColegiado){
        try{
            this.Conector();
            sql = "DELETE FROM doctor WHERE NoColegiado = ?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, NoColegiado);
            ejecutar.executeUpdate();
            respuesta = "RegistroEliminado";
        } catch (SQLException ex){
            System.out.println("Error en conexion: "+ ex);
            respuesta="Error, no se puede eliminar el registro";
            
        }return respuesta;
    }
    
    public String modificarDoctor(Doctor datos){
        try{
            this.Conector();
            sql = "UPDATE doctor SET cui = ?, pNombre = ?, pApellido = ?, sNombre = ?,"
                   + " sApellido = ?, genero = ?, fechaNacimiento = ?, direccion = ?, "
                   + "telefono = ?, email = ?, noColegiado = ?, usuario = ?, contraseña = ?, "
                   + "codEspecialidad = ?, codPuesto = ?";
            
            ejecutar = this.getMiconexion().prepareStatement(sql);
            
            //Datos de persona
            ejecutar.setInt(1, datos.getCui());
            ejecutar.setString(2, datos.getpNombre());
            ejecutar.setString(3, datos.getpApellido());
            ejecutar.setString(4, datos.getsNombre());
            ejecutar.setString(5, datos.getsApellido());
            ejecutar.setString(6, datos.getGenero());
            ejecutar.setDate(7, datos.getFechaNacimiento());
            ejecutar.setString(8, datos.getDireccion());
            ejecutar.setInt(9,  datos.getTelefono());
            ejecutar.setString(10,  datos.getEmail());
            //Datos de Doctor
            ejecutar.setInt(11, datos.getNoColegiado());
            ejecutar.setString(12, datos.getUsuario());
            ejecutar.setString(13, datos.getContraseña());
            ejecutar.setInt(14, datos.getCodEspecialidad());
            ejecutar.setInt(15, datos.getCodPuesto());
            
            respuesta = "Datos modificados con éxito";
            
        } catch (SQLException ex){
            System.out.println("Erro en conexion: "+ex);
            respuesta = "No se puede modificar";
        } finally{
            this.cerrarConexion();
        }
        return respuesta;
    }
    
}
