
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Categoria_Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String estado;

    public Categoria_Producto(int id, String nombre, String descripcion, String imagen, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estado = estado;
    }

    public Categoria_Producto() {
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

    public Conex getC() {
        return c;
    }

    public void setC(Conex c) {
        this.c = c;
    }
    
    private PreparedStatement ps;           //variable PreparedStatement para ejecutar una consilta a la BD
    private ResultSet rs;                   //variable ResultSet para optener resultados de conexion   
    Conex c = new Conex();                  //instancia de la clase Conex

    Connection con() throws SQLException, ClassNotFoundException {
        Class.forName(c.getDriver());
        return DriverManager.getConnection(c.getUrl(), c.getUser(), c.getContra());
    }
    
     public ArrayList<Categoria_Producto> listaCategoria_Productos() {
        ArrayList<Categoria_Producto> listCategoria_Producto = new ArrayList<>();
        try {
            ps = con().prepareStatement("SELECT * FROM categoria WHERE ESTADO = 'A';"); //consulta para optener el nivel del usuario 
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
        } catch (ClassNotFoundException | SQLException e) { System.out.println("Categoria_ProductoDao"+e.toString());}

        return listCategoria_Producto;
    }
    
   
            
}
