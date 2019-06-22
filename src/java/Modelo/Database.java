/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author TOBAR
 * @Fecha 16/06/219
 */
public class Database {
   private String url;
   private String user;
   private String contra;
   private String driver;

    public Database() {
        this.url = "jdbc:mysql://mysql:3306/restaurante";
        this.user =  "root";
        this.contra = "";
        this.driver = "com.mysql.jdbc.Driver";
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
