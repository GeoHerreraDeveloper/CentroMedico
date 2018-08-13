package com.centromedico1.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.centromedico1.modelo.Conexion;
import com.centromedico1.modelo.Medicamento;

public class MedicamentoDAO extends Conexion {
	
	private String lineSQL;
	private PreparedStatement ejecutar;
	private String respuesta;
	
	// AGREGAR UN MEDICAMENTO
	public String nuevoMedic(Medicamento nMedicamento) {
		respuesta = null;
		try {
			this.Conector();
			
			lineSQL = "INSERT INTO medicamento VALUES (?,?,?,?);";
			ejecutar = this.getMiconexion().prepareStatement(lineSQL);
			
			ejecutar.setInt(1,  nMedicamento.getCodMedicamento());
			ejecutar.setString(2,  nMedicamento.getNombre());
			ejecutar.setString(3,  nMedicamento.getDescripcion());
			ejecutar.setString(4,  nMedicamento.getPresentacion());
			
			ejecutar.executeUpdate();
			
			respuesta = "Medicamento Almacenado!";			
		} catch (SQLException ex) {
			System.out.println("Error en Statement" + ex);
			respuesta = "No se pudo almacenar el registro";
		} finally {
			this.cerrarConexion();
		} return respuesta;
		
	}
	
	
	// BUSCAR
	public ArrayList<Medicamento> listaMedicamentos(){
		ArrayList<Medicamento> lista = null;
		ResultSet resultado;
		try {
			this.Conector();
			
			lineSQL = "SELECT * FROM medicamento WHERE cod_medicamento = ?;";
			ejecutar = this.getMiconexion().prepareStatement(lineSQL);
			resultado = ejecutar.executeQuery();
			lista = new ArrayList();
			
			while(resultado.next()) {
				Medicamento nMedicamento = new Medicamento();
				
				nMedicamento.setCodMedicamento(resultado.getInt("cod_medicamento"));
				nMedicamento.setNombre(resultado.getString("nombre"));
				nMedicamento.setDescripcion(resultado.getString("descripcion"));
				nMedicamento.setPresentacion(resultado.getString("presentacion"));
				
				lista.add(nMedicamento);
			}
		} catch (Exception e) {
			System.out.print("Error " + e);
		} finally {
			this.cerrarConexion();
		}
		return lista;
	}

	// MODIFICAR MEDICAMENTO
	public String modiMedicamento(Medicamento datos) {
		try {
			this.Conector();
			lineSQL = "UPDATE medicamento SET cod_medicamento = ?, nombre = ?, descripcion = ?, "
					+ "presentacion = ? WHERE cod_medicamento = ?;";

			ejecutar = this.getMiconexion().prepareStatement(lineSQL);

			ejecutar.setInt(1, datos.getCodMedicamento());
			ejecutar.setString(2, datos.getNombre());
			ejecutar.setString(3, datos.getDescripcion());
			ejecutar.setString(4, datos.getPresentacion());

			respuesta = "Medicamento modificado con éxito!";
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
