/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author TOBAR
 */
import java.sql.*;
public class Acceso {
    
    Database db = new Database();
    String sql ="";
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public Acceso() {
    }
    
   public int validar(String username, String pass ){
       int nivel =0;
       
       try {
           Class.forName(db.getDriver());
           con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getContra());
           sql ="SELECT ROL FROM usuario WHERE USERNAME = '"+username+"' and PASS ='"+pass+"';";
           pst = con.prepareStatement(sql);
           rs=pst.executeQuery();
           while(rs.next()){
              nivel = rs.getInt(1); 
           }
           con.close();
           rs.close();
           return nivel;
       } catch (SQLException | ClassNotFoundException e) {
           return nivel;
       }
   }
    
    
}
