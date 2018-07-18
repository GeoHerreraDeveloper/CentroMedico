
package com.centromedico1.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private Connection conexion;
    private static final String URL = "jdbc:mysql://localhost:3306/clinica_medica";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    
    public Connection getMiconexion(){
        return conexion;
    }
    public void setMiconexion(Connection conexion){
        this.conexion = conexion;
    }
    public void Conector() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex){
            System.out.println("Error en conexion" + ex);
        }
    }
    public void cerrarConexion(){
        try{
            if (conexion != null) {
                if (conexion.isClosed()==false){
                    conexion.close();
                }
            }
        } catch (SQLException ex){
            System.out.println("Error al cerrar" + ex);
        }
    }
    
}
