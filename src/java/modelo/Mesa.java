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
public class Mesa {
    private int id;
    private String nombre;
    private String estado;

    public Mesa(int id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Mesa() {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //conexion 
    
    private PreparedStatement ps;           //variable PreparedStatement para ejecutar una consilta a la BD
    private ResultSet rs;                   //variable ResultSet para optener resultados de conexion   
    Conex c = new Conex();                  //instancia de la clase Conex

    Connection con() throws SQLException, ClassNotFoundException {
        Class.forName(c.getDriver());
        return DriverManager.getConnection(c.getUrl(), c.getUser(), c.getContra());
    }
    
    public ArrayList<Mesa> listaMesas() {
        ArrayList<Mesa> listMesa = new ArrayList<>();
        try {
            ps = con().prepareStatement("SELECT * FROM MESA WHERE ESTADO ='A' OR ESTADO ='R';"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Mesa obj = new Mesa();
                obj.setId(rs.getInt("ID"));
                obj.setNombre(rs.getString("NOMBRE")); 
                obj.setEstado(rs.getString("ESTADO")); 
                System.out.println(obj);
                listMesa.add(obj);          //Agrehar el objeto Mesa a la listas Sucurlases
            }
        } catch (ClassNotFoundException | SQLException e) { System.out.println("MesaDao"+e.toString());}

        return listMesa;
    }
    
}
