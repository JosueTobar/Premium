/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author TOBAR
 */
public class Usuario {

    private Integer id;
    private Integer sucursal;
    private Integer rol;
    private String nombre;
    private String apellido;
    private String username;
    private String pass;

    private Conex conn = new Conex();
    private PreparedStatement ps;
    private ResultSet rs;

    public Usuario() {
    }

    public Usuario(Integer id, Integer sucursal, Integer rol, String nombre, String apellido, String username, String pass) {
        this.id = id;
        this.sucursal = sucursal;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.pass = pass;
    }

    Connection con() throws SQLException, ClassNotFoundException {
        Class.forName(conn.getDriver());
        return DriverManager.getConnection(conn.getUrl(), conn.getUser(), conn.getContra());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
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
    public int validar(String username, String pass, String sucursal) {
        int nivel = 0;
        try {
            ps = con().prepareStatement("SELECT TIPO_USUARIO_ID FROM USUARIO WHERE USUARIO=? AND CONTRA =?;"); //consulta para optener el nivel del usuario  
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
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setSucursal(rs.getInt("id_sucursales"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setUsername(rs.getString("username"));
                usu.setPass(rs.getString("pass"));
                usu.setRol(rs.getInt("rol"));
                lista.add(usu);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("SucursalDao" + e.toString());
        }
        return lista;
    }

   
    public boolean agregar() {
        boolean add = false;
        try {
            ps = con().prepareStatement("INSERT INTO usuarios (Nombre,Apellido,id_sucursales,rol,username,pass) VALUES('"+this.nombre+"','"+this.apellido+"',"+this.sucursal+","+this.rol+",'"+this.username+"','"+this.pass+"');"); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            add = true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        return add;
    }

    public boolean modificar() {
        boolean edit = false;
        try {
            ps = con().prepareStatement("INSERT INTO usuarios (id,Nombre,Apellido,id_sucursales,rol,username,pass ) VALUES (NULL,?,?,?,?,?,?)"); //consulta para optener el nivel del usuario  
            ps.setString(1, this.nombre);
            ps.setString(2, this.apellido);
            ps.setInt(3, this.sucursal);
            ps.setInt(4, this.rol);
            ps.setString(5, this.username);
            ps.setString(6, this.pass);
            ps.executeQuery();
            edit = true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        return edit;
    }

    public boolean eliminar(int id) {
        boolean delete = false;

        try {
            ps = con().prepareStatement("delete from usuarios where id="+id+";"); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            delete = true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error SQL-Delete: " + e.getMessage());
        }
        return delete;
    }
}
