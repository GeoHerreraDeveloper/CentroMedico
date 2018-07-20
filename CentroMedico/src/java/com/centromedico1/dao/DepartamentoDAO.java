package com.centromedico1.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.centromedico1.modelo.Conexion;
import com.centromedico1.modelo.Departamento;

public class DepartamentoDAO extends Conexion{
	
	private String lineSQL;
	private PreparedStatement ejecutar;
	private String respuesta;
	
	
	//AGREGAR UN DEPARTAMENTO
	
	public String nuevoDepto(Departamento depto) {
		respuesta = null;
		try {
			this.Conector();
			
			lineSQL = "INSERT INTO departamento VALUES (?, ?, ?);";
			
			ejecutar = this.getMiconexion().prepareStatement(lineSQL);
			
			ejecutar.setInt(1, depto.getCodDepartamento());
			ejecutar.setString(2, depto.getNombre());
			ejecutar.setString(3, depto.getDescripcion());

			ejecutar.executeUpdate();

			respuesta = "Registro almacenado con exito!";

		} catch (SQLException ex) {
			System.out.println("Error en Statement" + ex);
			respuesta = "No se pudo almacenar el registro";
		} finally {
			this.cerrarConexion();
		}
		return respuesta;
	}

	
	// BUSCAR
	
	public ArrayList<Departamento> listaDeptos() {
		ArrayList<Departamento> lista = null;
		ResultSet resultado;
		try {
			this.Conector();

			lineSQL = "SELECT * FROM departamento WHERE Cod-Departamento = ?;";
			ejecutar = this.getMiconexion().prepareStatement(lineSQL);
			resultado = ejecutar.executeQuery();
			lista = new ArrayList();
			while (resultado.next()) {
				Departamento nuevoDepto = new Departamento();
				nuevoDepto.setCodDepartamento(resultado.getInt("Cod_Departamneto"));
				nuevoDepto.setNombre(resultado.getString("Nombre"));
				nuevoDepto.setDescripcion(resultado.getString("Descripcion"));

				lista.add(nuevoDepto);
			}
		} catch (Exception e) {
			System.out.println("Error " + e);
		} finally {
			this.cerrarConexion();
		}
		return lista;

	}
	
	
	//MODIFICAR DEPARTAMENTO

	public String modificarDepto(Departamento datos) {
		try {
			this.Conector();
			lineSQL = "UPDATE Departamento SET Cod_Departamento = ?, Nombre = ?, Descripcion = ? WHERE Cod_Depto = ?";

			ejecutar = this.getMiconexion().prepareStatement(lineSQL);

			ejecutar.setInt(1, datos.getCodDepartamento());
			ejecutar.setString(2, datos.getNombre());
			ejecutar.setString(3, datos.getDescripcion());

			respuesta = "Datos modificados con éxito!";
		} catch (SQLException ex) {
			// Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error en conexion: " + ex);
			respuesta = "No se puede modificar";
		} finally {
			this.cerrarConexion();
		}
		return respuesta;
	}


}
