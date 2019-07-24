package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TOBAR
 */
public class Imagen {
    private Integer id;
    private String descripcion;
    private String url;
    
    private Conexion conn = new Conexion();
    private java.sql.Connection con = null;
    private java.sql.PreparedStatement ps;
    private ResultSet rs;
    
     public Imagen() {
        this.con = this.conn.getConexion();
    }

    public Imagen(Integer id, String descripcion, String url, PreparedStatement ps, ResultSet rs) {
        this.id = id;
        this.descripcion = descripcion;
        this.url = url;
        this.ps = ps;
        this.rs = rs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
     public ArrayList<Imagen> ListarImagen() {
        ArrayList<Imagen> lista = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("SELECT * FROM imagen;"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();
            while (rs.next()) {
                Imagen img = new Imagen();
                img.setId(rs.getInt("ID"));
                img.setDescripcion(rs.getString("DESCRIPCION"));
                img.setUrl(rs.getString("URL"));
                lista.add(img);
            }
        } catch (Exception e) {
            System.out.println("SucursalDao" + e.toString());
        }
        return lista;
    }
    
}
