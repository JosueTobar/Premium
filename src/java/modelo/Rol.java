package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author TOBAR
 */
public class Rol {

    private Integer id;
    private String nombre;
    
    private Conexion conn = new Conexion();
    private java.sql.Connection con = null;
    private java.sql.PreparedStatement ps;
    private ResultSet rs;

    public Rol() {
        this.con = this.conn.getConexion();
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
    public ArrayList<Rol> listaRoles() {
        ArrayList<Rol> listRol = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("SELECT * FROM TIPO_USUARIO;"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Rol obj = new Rol();
                obj.setId(rs.getInt("ID"));
                obj.setNombre(rs.getString("DESCRIPCION"));
                listRol.add(obj);          //Agrehar el objeto Rol a la listas Sucurlases
            }
        } catch (SQLException e) { 
            System.out.println("RolDao"+e.toString());
        }

        return listRol;
    }
}
