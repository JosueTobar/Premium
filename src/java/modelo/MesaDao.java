package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author TOBAR
 */
public class MesaDao {

    private final Conexion conn = new Conexion();
    private java.sql.Connection con = null;
    private java.sql.PreparedStatement ps;
    private ResultSet rs;

    public MesaDao() {
        this.con = this.conn.getConexion();
    } 
     public ArrayList<Mesa> listaMesas() {
        ArrayList<Mesa> listMesa = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("SELECT * FROM MESA"); 
            rs = ps.executeQuery();        
            while (rs.next()) {
                Mesa obj = new Mesa();
                obj.setId(rs.getInt("ID"));
                obj.setNombre(rs.getString("NOMBRE"));
                obj.setEstado(rs.getString("ESTADO")); 
                System.out.println(obj);
                listMesa.add(obj);        
            }
        } catch (SQLException e) { System.out.println("MesaDao"+e.toString());}

        return listMesa;
    }
     public ArrayList<Mesa> listaMesasByID(int id) {
        ArrayList<Mesa> listMesa = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("SELECT * FROM MESA WHERE ID = "+id+";"); 
            rs = ps.executeQuery();      
            while (rs.next()) {
                Mesa obj = new Mesa();
                obj.setId(rs.getInt("ID"));
                obj.setNombre(rs.getString("NOMBRE"));
                obj.setEstado(rs.getString("ESTADO")); 
                System.out.println(obj);
                listMesa.add(obj);   
            }
        } catch (SQLException e) { System.out.println("MesaDao"+e.toString());}

        return listMesa;
    }
    
      public boolean agregar(Mesa obj) {
        boolean add = false;
        try {
            ps = this.con.prepareStatement("INSERT INTO `restaurante`.`mesa` (`NOMBRE`, `ESTADO`) VALUES ('"+obj.getNombre()+"', '"+obj.getEstado()+"');"); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            add = true;
        } catch (SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        return add;
    }
     public boolean modificar(Mesa obj) {
        boolean edit = false;
        try {
            ps = this.con.prepareStatement("UPDATE mesa SET NOMBRE='"+obj.getNombre()+"', ESTADO='"+obj.getEstado()+"' WHERE ID="+obj.getId()+";"); 
            ps.executeUpdate();
            edit = true;
        } catch (SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        return edit;
    }
    public boolean eliminar(int id) {
        boolean delete = false;
        try {

            ps = this.con.prepareStatement("DELETE FROM mesa WHERE ID = "+id+";"); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            delete = true;
        } catch (SQLException e) {
            System.out.println("Error SQL-Delete: " + e.getMessage());
        }
        return delete;
    } 

}
