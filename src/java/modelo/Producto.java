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
public class Producto {

    private int id;
    private String nombre;
    private int cantidad;
    private float precio;
    private String imagen;
    private String descripcio;
    private String estado;
    private int categoria;

    public Producto(int id, String nombre, int cantidad, float precio, String imagen, String descripcio, String estado, int categoria) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.imagen = imagen;
        this.descripcio = descripcio;
        this.estado = estado;
        this.categoria = categoria;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    
    public Producto() {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    private PreparedStatement ps;           //variable PreparedStatement para ejecutar una consilta a la BD
    private ResultSet rs;                   //variable ResultSet para optener resultados de conexion   
    Conex c = new Conex();                  //instancia de la clase Conex

    Connection con() throws SQLException, ClassNotFoundException {
        Class.forName(c.getDriver());
        return DriverManager.getConnection(c.getUrl(), c.getUser(), c.getContra());
    }
    
     public ArrayList<Producto> listaProductos() {
        ArrayList<Producto> listProducto = new ArrayList<>();
        try {
            ps = con().prepareStatement("SELECT * FROM Producto WHERE ESTADO ='A' OR ESTADO ='R';"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Producto obj = new Producto();
                obj.setId(rs.getInt("ID"));
                obj.setId(rs.getInt("CANTIDAD"));
                obj.setNombre(rs.getString("NOMBRE"));
                obj.setPrecio(rs.getFloat("PRECIO"));
                obj.setDescripcio(rs.getString("DESCRIPCION")); 
                obj.setImagen(rs.getString("IMAGEN")); 
                obj.setEstado(rs.getString("ESTADO")); 
                System.out.println(obj);
                listProducto.add(obj);          //Agrehar el objeto Producto a la listas Sucurlases
            }
        } catch (ClassNotFoundException | SQLException e) { System.out.println("ProductoDao"+e.toString());}

        return listProducto;
    }
     
        public ArrayList<Producto> listaProductosPorCategoria() {
        ArrayList<Producto> listProducto = new ArrayList<>();
        try {
            ps = con().prepareStatement("SELECT * FROM Producto WHERE ESTADO ='A' OR ESTADO ='R';"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Producto obj = new Producto();
                obj.setId(rs.getInt("ID"));
                obj.setId(rs.getInt("CANTIDAD"));
                obj.setNombre(rs.getString("NOMBRE"));
                obj.setPrecio(rs.getFloat("PRECIO"));
                obj.setDescripcio(rs.getString("DESCRIPCION")); 
                obj.setImagen(rs.getString("IMAGEN")); 
                obj.setEstado(rs.getString("ESTADO")); 
                System.out.println(obj);
                listProducto.add(obj);          //Agrehar el objeto Producto a la listas Sucurlases
            }
        } catch (ClassNotFoundException | SQLException e) { System.out.println("ProductoDao"+e.toString());}

        return listProducto;
    }
}
