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

public class ProductoDao {
    private Conexion conn = new Conexion();
    private java.sql.Connection con = null;
    private java.sql.PreparedStatement ps;
    private ResultSet rs;

public ProductoDao() {
        this.con = this.conn.getConexion();
    }

public ArrayList<Producto> listaProductos() {
        ArrayList<Producto> listProducto = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("SELECT * FROM PRODUCTO"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Producto obj = new Producto();
                obj.setId(rs.getInt("ID"));
                obj.setCantidad(rs.getInt("CANTIDAD"));
                obj.setCategoria(rs.getString("CATEGORIA_ID"));
                obj.setNombre(rs.getString("NOMBRE"));
                obj.setPrecio(rs.getString("PRECIO"));
                obj.setDescripcio(rs.getString("DESCRIPCION")); 
                obj.setImagen(rs.getString("IMAGEN")); 
                obj.setEstado(rs.getString("ESTADO")); 
                System.out.println(obj);
                listProducto.add(obj);          //Agrehar el objeto Producto a la listas Sucurlases
            }
        } catch (SQLException e) { System.out.println("ProductoDao"+e.toString());}

        return listProducto;
    }
    
      public ArrayList<Producto> listaProductosPorCategoria(int id) {
        ArrayList<Producto> listProducto = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("SELECT * FROM PRODUCTO WHERE CATEGORIA_ID ="+id+";"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Producto obj = new Producto();
                obj.setId(rs.getInt("ID"));
                obj.setCantidad(rs.getInt("CANTIDAD"));
                obj.setCategoria(rs.getString("CATEGORIA_ID"));
                obj.setNombre(rs.getString("NOMBRE"));
                obj.setPrecio(rs.getString("PRECIO"));
                obj.setDescripcio(rs.getString("DESCRIPCION")); 
                obj.setImagen(rs.getString("IMAGEN")); 
                obj.setEstado(rs.getString("ESTADO")); 
                System.out.println(obj);
                listProducto.add(obj);          //Agrehar el objeto Producto a la listas Sucurlases
            }
        } catch (SQLException e) { System.out.println("ProductoDao"+e.toString());}
        return listProducto;
    }
      public boolean agregar(Producto pro) {
        boolean add = false;
        try {
            ps = this.con.prepareStatement("INSERT INTO `restaurante`.`producto` (`NOMBRE`, `DESCRIPCION`, `CANTIDAD`, `PRECIO`, `ESTADO`, `CATEGORIA_ID`) VALUES ('"+pro.getNombre()+"', '"+pro.getDescripcio()+"', '"+pro.getCantidad()+"', '"+pro.getPrecio()+"', '"+pro.getEstado()+"', '"+pro.getCategoria()+"');"); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            add = true;
        } catch (Exception e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        return add;
    }
     public boolean modificar(Producto pro) {
        boolean edit = false;
        try {
            ps = this.con.prepareStatement("UPDATE producto SET NOMBRE = '"+pro.getNombre()+"', DESCRIPCION = '"+pro.getDescripcio()+"', CANTIDAD = "+pro.getCantidad()+", PRECIO = "+pro.getPrecio()+" , ESTADO = '"+pro.getCategoria()+"', CATEGORIA_ID = "+pro.getCategoria()+" WHERE ID ="+pro.getId()+""); 
            ps.executeUpdate();
            edit = true;
        } catch (Exception e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        return edit;
    }
    public boolean eliminar(int id) {
        boolean delete = false;
        try {

            ps = this.con.prepareStatement("DELETE FROM producto WHERE ID = "+id+";"); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            delete = true;
        } catch (Exception e) {
            System.out.println("Error SQL-Delete: " + e.getMessage());
        }
        return delete;
    } 
}
