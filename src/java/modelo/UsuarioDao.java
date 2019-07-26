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
import java.sql.*;
import java.util.*;
import modelo.Conex;
import modelo.Conex;

public class UsuarioDao {

    private PreparedStatement ps;   //variable PreparedStatement para ejecutar una consilta a la BD
    private ResultSet rs;           //variable ResultSet para optener resultados de conexion   
    Conex c = new Conex();          //instancia de la clase Conex

    Connection con()throws SQLException, ClassNotFoundException{
            Class.forName(c.getDriver());
            return DriverManager.getConnection(c.getUrl(), c.getUser(), c.getContra());
    } 
    
    
    public int validar(String username, String pass, String sucursal){
        int nivel =0 ;
        try {
            ps =con().prepareStatement("SELECT ROL FROM usuarios WHERE USERNAME ='"+username+"'and PASS ='"+pass+"';"); //consulta para optener el nivel del usuario 
            rs=ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while(rs.next()){
              nivel = Integer.parseInt( rs.getString(1));
              return nivel;            //Retornar el nivel del susuario
              
           }
        } catch (Exception e) {
        }
        return nivel;
            
    }
}
