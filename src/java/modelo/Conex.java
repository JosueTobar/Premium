/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author josue.tobarfgkss
 */
public class Conex {

    private String url = "jdbc:mysql://localhost/restaurante";
    private String user = "root";
    private String contra = "";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection con;

    public Conex() {
        try {
            Class.forName(this.driver);
            this.con = (Connection) DriverManager.getConnection(this.url, this.user, this.contra);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error DB: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return this.con;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getContra() {
        return contra;
    }

    public String getDriver() {
        return driver;
    }

}
