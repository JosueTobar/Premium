package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexion;

/**
 *
 * @author TOBAR
 */
public class PedidoDao {

    private final Conexion conn = new Conexion();
    private java.sql.Connection con = null;
    private java.sql.PreparedStatement ps;
    private ResultSet rs;

    
    public PedidoDao() {
         this.con = this.conn.getConexion();
    }
    //SELECT * FROM pedido; 
public ArrayList<Pedido> listaPedidosByEstado(String estado) {
        ArrayList<Pedido> listPedido = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("SELECT * FROM pedido WHERE ESTADO = "+estado+";"); //consulta para optener el nivel del usuario 
            rs = ps.executeQuery();         //Ejecucuion de la consulta y dar el valor a rs
            while (rs.next()) {
                Pedido obj = new Pedido();
                obj.setIdUsuario(rs.getInt("ID"));
                obj.setId(rs.getInt("MESA_ID"));
                obj.setIdMesa(rs.getInt("USAURIO_ID"));
                obj.setEstado(rs.getString("ESTADO")); 
                System.out.println(obj);
                listPedido.add(obj);          //Agrehar el objeto Pedido a la listas Sucurlases
            }
        } catch (SQLException e) { System.out.println("PedidoDao"+e.toString());}

        return listPedido;
    }
 public ArrayList<String> agregar(Pedido ped) {
     ArrayList<String> respuesta = new ArrayList<>();
        boolean add = false;
        try {
            ps = this.con.prepareStatement("INSERT INTO `restaurante`.`pedido` (`FECHA`, `ESTADO`, `MESA_ID`, `USUARIO_ID`) VALUES ('"+ped.getFecha()+"', '"+ped.getEstado()+"', '"+ped.getIdMesa()+"', '"+ped.getIdUsuario()+"');");
            ps.executeUpdate();
            respuesta.add("true");
        } catch (SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        try {
            ps = this.con.prepareStatement("SELECT MAX(ID)ACTUAL FROM PEDIDO; ");
            rs = ps.executeQuery();         
            while (rs.next()) {
              respuesta.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        
        return respuesta;
    }
     public boolean modificar(Pedido ped) {
        boolean edit = false;
        try {
            ps = this.con.prepareStatement("UPDATE pedido SET FECHA = '"+ped.getFecha()+"', ESTADO = '"+ped.getEstado()+"', USUARIO_ID = "+ped.getIdUsuario()+" WHERE  ID = "+ped.getId()+";"); 
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
            ps = this.con.prepareStatement(" UPDATE  PEDIDO SET ESTADO = 'I' WHERE ID ="+id+""); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            delete = true;
        } catch (SQLException e) {
            System.out.println("Error SQL-Delete: " + e.getMessage());
        }
        return delete;
    }
    //LISTAR PEDIDOS ACTIVOS 
    // select * from pedido where estado ="A"; 
    
    public ArrayList<ArrayList<String>> ListarPedidosA(int id) {
     ArrayList<ArrayList<String>> row = new ArrayList<>();
        try {
            ps = this.con.prepareStatement(" select * from vPEDIDO where  pedido_id = "+id+" and estado = 'A';");
            rs = ps.executeQuery();         
            while (rs.next()) {
                ArrayList<String> col = new ArrayList<>(); 
                col.add(rs.getString("mesa_id"));
                col.add(rs.getString("DESCRIPCION"));
                col.add(rs.getString("PRODUCTO_ID"));
                col.add(rs.getString("PEDIDO_ID"));
                col.add(rs.getString("ESTADO"));
                col.add(rs.getString("TOTAL"));
                col.add(rs.getString("PRECIO"));
                col.add(rs.getString("total_precio"));
                row.add(col);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        
        return row;
    }
    
    public ArrayList<ArrayList<String>> ListarMesaA() {
     ArrayList<ArrayList<String>> row = new ArrayList<>();
        try {
            ps = this.con.prepareStatement(" select * from pedido where estado ='A';");
            rs = ps.executeQuery();         
            while (rs.next()) {
                ArrayList<String> col = new ArrayList<>(); 
                col.add(rs.getString("id"));
                col.add(rs.getString("mesa_id"));
                row.add(col);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        
        return row;
    }
  // select distinct mesa_id,nombremesa, pedido_id from vPEDIDO; 
 public ArrayList<ArrayList<String>> ListarCuentas() {
     ArrayList<ArrayList<String>> row = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("select distinct mesa_id,nombremesa, pedido_id from vPEDIDO;");
            rs = ps.executeQuery();         
            while (rs.next()) {
                ArrayList<String> col = new ArrayList<>(); 
                col.add(rs.getString("mesa_id"));
                col.add(rs.getString("nombremesa"));
                col.add(rs.getString("pedido_id"));
                row.add(col);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        
        return row;
    }
}

  