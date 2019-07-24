/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author TOBAR
 */
public class Categoria_Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String estado;
    
  private Conexion conn = new Conexion();
    private java.sql.Connection con = null;
    private java.sql.PreparedStatement ps;
    private ResultSet rs;
    
    public Categoria_Producto() {
        this.con = this.conn.getConexion();
    }
    
    public Categoria_Producto(int id, String nombre, String descripcion, String imagen, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
 
    public ArrayList<Categoria_Producto> listaCategoria_Productos() {
        ArrayList<Categoria_Producto> listCategoria_Producto = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("SELECT * FROM categoria WHERE ESTADO = 'A';"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Categoria_Producto obj = new Categoria_Producto();
                obj.setId(rs.getInt("ID"));
                obj.setNombre(rs.getString("NOMBRE")); 
                obj.setEstado(rs.getString("ESTADO")); 
                obj.setDescripcion(rs.getString("DESCRIPCION")); 
                obj.setImagen(rs.getString("IMAGEN")); 
                System.out.println(obj);
                listCategoria_Producto.add(obj);          //Agrehar el objeto Categoria_Producto a la listas Sucurlases
            }
        } catch (SQLException e) { System.out.println("Categoria_ProductoDao"+e.toString());}
        return listCategoria_Producto;
    }
    
    public boolean agregar() {
        boolean add = false;
        try {
            ps = this.con.prepareStatement("INSERT INTO `restaurante`.`categoria` (`NOMBRE`, `DESCRIPCION`, `ESTADO`) VALUES ('"+this.nombre+"', '"+this.descripcion+"', '"+this.estado+"');"); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            add = true;
        } catch (Exception e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        return add;
    }
     public boolean modificar() {
        boolean edit = false;
        try {
            ps = this.con.prepareStatement("UPDATE categoria SET NOMBRE = '"+this.nombre+"', DESCRIPCION = '"+this.descripcion+"', IMAGEN = "+this.imagen+", ESTADO = '"+this.estado+"' WHERE ID = "+this.id+";"); 
            ps.executeUpdate();
            edit = true;
        } catch (Exception e) {
            System.out.println("Error SQL-EDIT: " + e.getMessage());
        }
        return edit;
    }
    public boolean eliminar(int id) {
        boolean delete = false;
        try {

            ps = this.con.prepareStatement("DELETE FROM categoria WHERE ID = "+id+";"); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            delete = true;
        } catch (Exception e) {
            System.out.println("Error SQL-Delete: " + e.getMessage());
        }
        return delete;
    } 
   
}
