package modelo;

/**
 *
 * @author josue.tobarfgkss
 */
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao {

    private PreparedStatement ps;   //variable PreparedStatement para ejecutar una consilta a la BD
    private ResultSet rs;           //variable ResultSet para optener resultados de conexion   
    Conex c = new Conex();          //instancia de la clase Conex
    Usuario objU = new Usuario();

    Connection con() throws SQLException, ClassNotFoundException {
        Class.forName(c.getDriver());
        return DriverManager.getConnection(c.getUrl(), c.getUser(), c.getContra());
    }

    public int validar(String username, String pass, String sucursal) {
        int nivel = 0;
        try {
            ps = con().prepareStatement("SELECT ROL FROM usuarios WHERE USERNAME = ? and PASS = ?;"); //consulta para optener el nivel del usuario  
            ps.setString(1, username);  //Enviar parametros a la consulta
            ps.setString(2, pass);      //Enviar parametros a la consulta 
            rs = ps.executeQuery();       //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                nivel = Integer.parseInt(rs.getString(1));
                return nivel;            //Retornar el nivel del susuario

            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
        }
        return nivel;
    }

    public ArrayList<Usuario> mostrar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            ps = con().prepareStatement("select id, nombre,apellido,id_sucursales,username,pass,rol from usuarios;"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Usuario obj = new Usuario();
                obj.setId(rs.getInt("id"));
                obj.setSucursal(rs.getInt("id_sucursales"));
                obj.setNombre(rs.getString("nombre"));
                obj.setApellido(rs.getString("apellido"));
                obj.setUsername(rs.getString("username"));
                obj.setPass(rs.getString("pass"));
                obj.setRol(rs.getInt("rol"));
                lista.add(obj);          //Agrehar el objeto  a la listas 
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("SucursalDao" + e.toString());
        }
        return lista;
    }

    public boolean ingresar(Usuario objU) {
        try {
            ps = con().prepareStatement("INSERT INTO usuarios (id,Nombre,Apellido,id_sucursales,rol,username,pass ) VALUES (NULL,?,?,?,?,?,?)"); //consulta para optener el nivel del usuario  
            ps.setInt(1, objU.getId());             //Enviar parametros a la consulta
            ps.setString(2, objU.getNombre());      //Enviar parametros a la consulta 
            ps.setString(3, objU.getApellido());    //Enviar parametros a la consulta 
            ps.setInt(4, objU.getSucursal());       //Enviar parametros a la consulta 
            ps.setInt(5, objU.getRol());            //Enviar parametros a la consulta 
            ps.setString(6, objU.getUsername());    //Enviar parametros a la consulta 
            ps.setString(7, objU.getPass());       //Enviar parametros a la consulta 
            ps.executeQuery();       //Ejecucuion de la consulta y dar el valor a rs

        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
        return true;
    }

    public boolean modificar(Usuario objU) {
        try {
            ps = con().prepareStatement("INSERT INTO usuarios ( id,Nombre,Apellido,id_sucursales,rol,username,pass ) VALUES (NULL,?,?,?,?,?,?)"); //consulta para optener el nivel del usuario  
            ps.setInt(1, objU.getId());             //Enviar parametros a la consulta
            ps.setString(2, objU.getNombre());      //Enviar parametros a la consulta 
            ps.setString(3, objU.getApellido());    //Enviar parametros a la consulta 
            ps.setInt(4, objU.getSucursal());       //Enviar parametros a la consulta 
            ps.setInt(5, objU.getRol());            //Enviar parametros a la consulta 
            ps.setString(6, objU.getUsername());    //Enviar parametros a la consulta 
            ps.setString(7, objU.getPass());       //Enviar parametros a la consulta 
            ps.executeQuery();       //Ejecucuion de la consulta y dar el valor a rs

        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
        return true;
    }

    public boolean eliminar(int id) {
        try {
            ps = con().prepareStatement("INSERT INTO usuarios ( id,Nombre,Apellido,id_sucursales,rol,username,pass ) VALUES (NULL,?,?,?,?,?,?)"); //consulta para optener el nivel del usuario  
            ps.setInt(1, id);           //Enviar parametros a la consulta 
            ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs

        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
        return true;
    }

}
