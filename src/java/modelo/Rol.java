/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TOBAR
 */
public class Rol {
    private Integer id;
    private String nombre;

    public Rol() {
    }

    public Rol(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private PreparedStatement ps;           //variable PreparedStatement para ejecutar una consilta a la BD
    private ResultSet rs;                   //variable ResultSet para optener resultados de conexion   
    Conex c = new Conex();                  //instancia de la clase Conex
    Sucursal objSucursal = new Sucursal();  //instancia de la clase sucursal

    Connection con() throws SQLException, ClassNotFoundException {
        Class.forName(c.getDriver());
        return DriverManager.getConnection(c.getUrl(), c.getUser(), c.getContra());
    }

  public ArrayList<Rol> listaRoles() {
        ArrayList<Rol> listRol = new ArrayList<>();
        try {
            ps = con().prepareStatement("SELECT ID, DESCRIPCION NOMBRE FROM ROLES;"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Rol obj = new Rol();
                obj.setId(rs.getInt("ID"));
                obj.setNombre(rs.getString("NOMBRE")); 
                System.out.println(obj);
                listRol.add(obj);          //Agrehar el objeto Rol a la listas Sucurlases
            }
        } catch (ClassNotFoundException | SQLException e) { System.out.println("RolDao"+e.toString());}

        return listRol;
    }
    
}
