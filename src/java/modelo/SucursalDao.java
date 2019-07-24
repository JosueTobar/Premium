package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conex;
import modelo.Sucursal;
import java.util.*;

/**
 *
 * @author TOBAR
 */
public class SucursalDao {

    private PreparedStatement ps;           //variable PreparedStatement para ejecutar una consilta a la BD
    private ResultSet rs;                   //variable ResultSet para optener resultados de conexion   
    Conex c = new Conex();                  //instancia de la clase Conex
    Sucursal objSucursal = new Sucursal();  //instancia de la clase sucursal

    Connection con() throws SQLException, ClassNotFoundException {
        Class.forName(c.getDriver());
        return DriverManager.getConnection(c.getUrl(), c.getUser(), c.getContra());
    }

    public ArrayList<Sucursal> listaSucursales() {
        ArrayList<Sucursal> listSucursal = new ArrayList<>();
        try {
            ps = con().prepareStatement("SELECT * FROM CATEGORIA;"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs

            while (rs.next()) {
                Sucursal obj = new Sucursal();
                obj.setId(rs.getString("id"));
                obj.setNombre(rs.getString("nombre")); 
                System.out.println(obj);
                listSucursal.add(obj);          //Agrehar el objeto Sucursal a la listas Sucurlases
            }
        } catch (ClassNotFoundException | SQLException e) { System.out.println("SucursalDao"+e.toString());}

        return listSucursal;
    }

}
