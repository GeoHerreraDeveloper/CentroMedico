package com.centromedico1.modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecretariaDAO extends Conexion{
	
	private String lineSql;
	private PreparedStatement ejecutar;
	private String respuesta;
	
	//Agregar una secretaria
	public String nuevaSecretaria(Secretaria secretariaN) {
		respuesta = null;
		try {
			this.Conector();
			lineSql = "INSERT INTO Secretaria VALUES (?,?,?,?,?)";
			ejecutar = this.getMiconexion().prepareStatement(lineSql);
			ejecutar.setInt(1, secretariaN.getCod_Secretaria());
            ejecutar.setString(2, secretariaN.getUser());
            ejecutar.setString(3, secretariaN.getPass());
            ejecutar.setInt(4, secretariaN.getCui());
            ejecutar.setInt(5, secretariaN.getCod_Puesto());
            
            ejecutar.executeUpdate();
            
            respuesta = "Registro Almacenado";
		}catch (SQLException ex) {
         System.out.println("Error en Statement" + ex);
         respuesta="No se pudo almacenar el registro";
     } finally {
         this.cerrarConexion();
     }
		
		return respuesta;
	}
	//BUSCAR
	public ArrayList<Secretaria> listaSecretarias(){
		ArrayList<Secretaria> lista = null;
		ResultSet resultado;
		try {
			this.Conector();
			lineSql = "SELECT * FROM secretaria";
			ejecutar = this.getMiconexion().prepareStatement(lineSql);
			resultado = ejecutar.executeQuery();
			lista = new ArrayList();
			while (resultado.next()) {
				Secretaria secretariaN = new Secretaria();
				secretariaN.setCod_Secretaria(resultado.getInt("cod_Secretaria"));
				secretariaN.setUser(resultado.getString("ususario"));
				secretariaN.setPass(resultado.getString("pass"));
				secretariaN.setCui(resultado.getInt("cui"));
				secretariaN.setCod_Puesto(resultado.getInt("cod_Puesto"));
				
				lista.add(secretariaN);
				
			}
		} catch (Exception e) {
			System.out.println("Error" + e);
		}finally {
			this.cerrarConexion();
		}
		return lista;
	}
	public String eliminarSecretaria(int cod_Secretaria) {
		try {
			this.Conector();
			lineSql = "DELETE FROM secretaria WHERE Cod_Secretaria = ?";
			ejecutar = this.getMiconexion().prepareStatement(lineSql);
			ejecutar.setInt(1, cod_Secretaria);
			ejecutar.executeUpdate();
			respuesta = "Registro Eliminado";
		} catch (SQLException ex) {
			//Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en Conexion: " + ex);
            respuesta="Error, no se puede eliminar el registro";	
		}
		return respuesta;		
	}
	
	
}
