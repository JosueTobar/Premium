
package modelo;

import java.sql.*;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author TOBAR
 */
public class Usuario {

    private Integer id;
    private Integer rol;
    private String nombre;
    private String apellido;
    private String username;
    private String estado;
    private String pass;

    private Conexion conn = new Conexion();
    private java.sql.Connection con = null;
    private java.sql.PreparedStatement ps;
    private ResultSet rs;

    public Usuario() {
        this.con = this.conn.getConexion();
    }

    public Usuario(Integer id, String nombre, String apellido, String username, String estado, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.estado = estado;
        this.pass = pass;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int validar(String username, String pass) {
        int nivel = 0;
        try {
            ps = this.con.prepareStatement("SELECT TIPO_USUARIO_ID FROM USUARIO WHERE USUARIO=? AND CONTRA = ?"); //consulta para optener el nivel del usuario  
            ps.setString(1, username);  //Enviar parametros a la consulta
            ps.setString(2, pass);      //Enviar parametros a la consulta 
            rs = ps.executeQuery();       //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                nivel = Integer.parseInt(rs.getString(1));
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error SQL-validar: " + e.getMessage());
            System.out.println("Error SQL-validar: " + e.getStackTrace());
        }
        return nivel;
    }

    public ArrayList<Usuario> mostrar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("select *  from usuario;"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("ID"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setApellido(rs.getString("APELLIDO"));
                usu.setUsername(rs.getString("USUARIO"));
                usu.setEstado(rs.getString("ESTADO"));
                usu.setPass(rs.getString("CONTRA"));
                usu.setRol(rs.getInt("TIPO_USUARIO_ID"));
                lista.add(usu);
            }
        } catch (Exception e) {
            System.out.println("SucursalDao" + e.toString());
        }
        return lista;
    }
    public boolean agregar() {
        boolean add = false;
        try {
            ps = this.con.prepareStatement("INSERT INTO `restaurante`.`usuario` (`NOMBRE`, `APELLIDO`, `USUARIO`, `CONTRA`, `ESTADO`, `TIPO_USUARIO_ID`) VALUES ('"+this.nombre+"', '"+this.apellido+"', '"+this.username+"', '"+this.pass+"', '"+this.estado+"', '"+this.rol+"');"); //consulta para optener el nivel del usuario  
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
            ps = this.con.prepareStatement("UPDATE usuario SET NOMBRE = '"+this.nombre+"', APELLIDO = '"+this.apellido+"', USUARIO = '"+this.username+"', CONTRA = '"+this.pass+"', ESTADO = '"+this.estado+"' WHERE ID ="+this.id+";"); 
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
            ps = this.con.prepareStatement("delete from usuario where id="+id+";"); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            delete = true;
        } catch (Exception e) {
            System.out.println("Error SQL-Delete: " + e.getMessage());
        }
        return delete;
    }
}
