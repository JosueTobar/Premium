/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TOBAR
 */
public class Conexion {

   
   
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/restaurante";
    private String user = "root";
    private String contra = "";
    private Connection con = null;
    
    public Conexion() {
        try {
            Class.forName(this.driver);
            this.con = (Connection) DriverManager.getConnection(this.url, this.user, this.contra);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error DB: " + e.getMessage());
        }
    }
    public Connection getConexion() { 
        return con;
    }
}
