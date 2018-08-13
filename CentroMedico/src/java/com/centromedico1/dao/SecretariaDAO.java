package com.centromedico1.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.centromedico1.modelo.Conexion;
import com.centromedico1.modelo.Secretaria;

public class SecretariaDAO extends Conexion {

	private String lineSql;
	private PreparedStatement ejecutar;
	private String respuesta;

	// AGREGAR UNA NUEVA SECRE
	public String nuevaSecretaria(Secretaria secretariaN) {
		respuesta = null;
		try {
			this.Conector();

			lineSql = "INSERT INTO persona VALUES (?,?,?,?,?,?,?,?,?,?)";

			ejecutar = this.getMiconexion().prepareStatement(lineSql);

			ejecutar.setInt(1, secretariaN.getCui());
			ejecutar.setString(2, secretariaN.getpNombre());
			ejecutar.setString(3, secretariaN.getpApellido());
			ejecutar.setString(4, secretariaN.getsNombre());
			ejecutar.setString(5, secretariaN.getsApellido());
			ejecutar.setString(6, secretariaN.getGenero());
			ejecutar.setString(7, secretariaN.getFechaNac());
			ejecutar.setString(8, secretariaN.getDireccion());
			ejecutar.setInt(9, secretariaN.getTelefono());
			ejecutar.setString(10, secretariaN.getEmail());

			ejecutar.executeUpdate();

			lineSql = "INSERT INTO Secretaria VALUES (?,?,?,?,?)";
			ejecutar = this.getMiconexion().prepareStatement(lineSql);

			ejecutar.setInt(1, secretariaN.getCod_Secretaria());
			ejecutar.setString(2, secretariaN.getUser());
			ejecutar.setString(3, secretariaN.getPass());
			ejecutar.setInt(4,  secretariaN.getCui());
			ejecutar.setInt(5, secretariaN.getCod_Puesto());

			ejecutar.executeUpdate();

			respuesta = "Registro Almacenado";
		} catch (SQLException ex) {
			System.out.println("Error en Statement" + ex);
			respuesta = "No se pudo almacenar el registro";
		} finally {
			this.cerrarConexion();
		}

		return respuesta;
	}

	// BUSCAR
	public ArrayList<Secretaria> listaSecretarias() {
		ArrayList<Secretaria> lista = null;
		ResultSet resultado;
		try {
			this.Conector();
			lineSql = "SELECT * FROM persona INNER JOIN secretaria WHERE cui = ?";
			ejecutar = this.getMiconexion().prepareStatement(lineSql);
			resultado = ejecutar.executeQuery();
			lista = new ArrayList();
			while (resultado.next()) {
				Secretaria secretariaN = new Secretaria();
				
				// Datos de persona
				secretariaN.setCui(resultado.getInt("cui"));
				secretariaN.setpNombre(resultado.getString("pNombre"));
				secretariaN.setpApellido(resultado.getString("pApellido"));
				secretariaN.setsNombre(resultado.getString("sNombre"));
				secretariaN.setsApellido(resultado.getString("sApellido"));
				secretariaN.setGenero(resultado.getString("genero"));
				secretariaN.setFechaNac(resultado.getString("fechaNacimiento"));
				secretariaN.setDireccion(resultado.getString("direccion"));
				secretariaN.setTelefono(resultado.getInt("telefono"));
				secretariaN.setEmail(resultado.getString("email"));
				//Datos de secretaria
				secretariaN.setCod_Secretaria(resultado.getInt("cod_Secretaria"));
				secretariaN.setUser(resultado.getString("usuario"));
				secretariaN.setPass(resultado.getString("pass"));
				secretariaN.setCod_Puesto(resultado.getInt("cod_Puesto"));

				lista.add(secretariaN);

			}
		} catch (Exception e) {
			System.out.println("Error" + e);
		} finally {
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
			// Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error en Conexion: " + ex);
			respuesta = "Error, no se puede eliminar el registro";
		}
		return respuesta;
	}
	
	//MODIFICAR SECRETARIA
	public String modificarSecre(Secretaria datos) {
		try {
			this.Conector();
			lineSql = "UPDATE secretaria SET cui = ?, pNombre = ?, pApellido = ?, sNombre = ?, sApellido = ?, "
					+ "genero = ?, fechaNacimiento = ?, direccion = ?, telefono = ?, email = ?, "
					+ "cod_secretaria = ?, usuario = ?, pass = ?, cod_puesto WHERE cod_secretaria = ?";
			
			ejecutar = this.getMiconexion().prepareStatement(lineSql);
			
			//Datos de persona
			ejecutar.setInt(1, datos.getCui());
			ejecutar.setString(2, datos.getpNombre());
			ejecutar.setString(3,  datos.getpApellido());
			ejecutar.setString(4,  datos.getsNombre());
			ejecutar.setString(5,  datos.getsApellido());
			ejecutar.setString(6,  datos.getGenero());
			ejecutar.setDate(7,  datos.getFechaNacimiento());
			ejecutar.setString(8,  datos.getDireccion());
			ejecutar.setInt(9,  datos.getTelefono());
			ejecutar.setString(10,  datos.getEmail());
			// Datos de secretaria
			ejecutar.setInt(11,  datos.getCod_Secretaria());
			ejecutar.setString(12,  datos.getUser());
			ejecutar.setString(13,  datos.getPass());
			ejecutar.setInt(14, datos.getCod_Puesto() );
			
			respuesta = "Datos modificados con éxito!";
					
		} catch (SQLException ex) {
			//Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en conexion: " + ex);
            respuesta="No se puede modificar";
		}finally {
			this.cerrarConexion();			
		}
		return respuesta;
		
	}

}
