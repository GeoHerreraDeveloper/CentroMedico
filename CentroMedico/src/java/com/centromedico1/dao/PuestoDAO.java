package com.centromedico1.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.centromedico1.modelo.Conexion;
import com.centromedico1.modelo.Puesto;

public class PuestoDAO extends Conexion {
	
	private String lineSQL;
	private PreparedStatement ejecutar;
	private String respuesta;
	
	//Agregar un Puesto
	public String nuevoPuesto (Puesto nPuesto) {
		respuesta = null;
		try {
			this.Conector();
			lineSQL = "INSERT INTO puesto VALUES ?, ?, ?, ?, ?, ?, ? ";
			
			ejecutar = this.getMiconexion().prepareStatement(lineSQL);
			
			ejecutar.setInt(1, nPuesto.getCod_puesto());
			ejecutar.setString(2, nPuesto.getNombre_Puesto());
			ejecutar.setDate(3, nPuesto.getHora_Inicio());
			ejecutar.setDate(4, nPuesto.getHora_Fin());
			ejecutar.setBoolean(5, nPuesto.getSalario());
			ejecutar.setDate(6, nPuesto.getInicia_Puesto());
			ejecutar.setInt(7, nPuesto.getCod_depto());
			
			ejecutar.executeUpdate();
			
			respuesta = "Puesto agreado con éxito!";
			
		} catch (SQLException ex) {
			System.out.print("Error en Statement" + ex);
			respuesta = "No se pudo almacenar el registro";
		} finally {
			this.cerrarConexion();
		}
		return respuesta;
	}
	
	// BUSCAR PUESTO
	public ArrayList<Puesto> listaPuestos() {
		ArrayList<Puesto> lista = null;
		ResultSet resultado;
		try {
			this.Conector();
			lineSQL = "SELECT * FROM puesto WHERE cod_puesto = ?";
			ejecutar = this.getMiconexion().prepareStatement(lineSQL);
			resultado = ejecutar.executeQuery();
			lista = new ArrayList();
			while(resultado.next()) {
				Puesto bPuesto = new Puesto();
				
				bPuesto.setCod_depto(resultado.getInt("cod_depto"));
				bPuesto.setNombre_Puesto(resultado.getString("nombre_puesto"));
				bPuesto.setHora_Inicio(resultado.getDate("hora_inicio"));
				bPuesto.setHora_Fin(resultado.getDate("hora_fin"));
				bPuesto.setSalario(resultado.getBoolean("salario"));
				bPuesto.setInicia_Puesto(resultado.getDate("inicia_puesto"));
				bPuesto.setCod_depto(resultado.getInt("cod_depto"));
				
				lista.add(bPuesto);
				
			}	
		} catch(Exception e) {
			System.out.print("Error " + e);
		}finally {
			this.cerrarConexion();
		}
		return lista;		
	}
	
	// MODIFICAR PUESTO
	
	public String modificarPuesto(Puesto datos) {
		try {
			this.Conector();
			lineSQL = "UPDATE puesto SET cod_puesto = ?, nombre_puesto = ?, hora_inicio = ?, hora_fin = ?, "
					+ "salario = ?, inicia_puesto = ?, cod_depto = ? WHERE cod_puesto = ?";
		
			ejecutar = this.getMiconexion().prepareStatement(lineSQL);
			
			ejecutar.setInt(1,  datos.getCod_puesto());
			ejecutar.setString(2,  datos.getNombre_Puesto());
			ejecutar.setDate(3, datos.getHora_Inicio());
			ejecutar.setDate(4,  datos.getHora_Fin());
			ejecutar.setBoolean(5,  datos.getSalario());
			ejecutar.setDate(6,  datos.getInicia_Puesto());
			ejecutar.setInt(7,  datos.getCod_depto());
			
			respuesta = "Datos modificados con éxito!";
			
		} catch (SQLException ex) {
			//Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en conexion: " + ex);
            respuesta="No se puede modificar";
		} finally {
			this.cerrarConexion();
		}
		return respuesta;
		
		
		
	}
		

}
