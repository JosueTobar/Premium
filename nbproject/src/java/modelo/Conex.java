/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author josue.tobarfgkss
 */
public class Conex {
   private String url;
   private String user;
   private String contra;
   private String driver;

    public Conex() {
        this.url = "jdbc:mysql://localhost:3306/restaurante";
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
