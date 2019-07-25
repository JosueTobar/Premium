
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexion;

public class PedidoDetalleDao {
    private final Conexion conn = new Conexion();
    private java.sql.Connection con = null;
    private java.sql.PreparedStatement ps;
    private ResultSet rs;

    public PedidoDetalleDao() {
         this.con = this.conn.getConexion();
    } 
    
    public ArrayList<PedidoDetalle> listaPedidoDetallesById(int id) {
        ArrayList<PedidoDetalle> listPedidoDetalle = new ArrayList<>();
        try {
            ps = this.con.prepareStatement("SELECT * FROM detalle_pedido where PEDIDO_ID = "+id+";");
            rs = ps.executeQuery();        
            while (rs.next()) {
                PedidoDetalle obj = new PedidoDetalle();
                obj.setId(rs.getInt("ID"));
                obj.setCantidad(rs.getInt("CANTIDAD"));
                obj.setTotal(rs.getInt("TOTAL"));
                obj.setIdPedido(rs.getInt("PEDIDO_ID"));
                obj.setIdProducto(rs.getInt("PRODUCTO_ID"));
                obj.setEstado(rs.getString("ESTADO"));
                obj.setDescripcion(rs.getString("DESCRIPCION"));
                obj.setDescripcion(rs.getString("COMENTARIO"));
                obj.setPrecio(rs.getFloat("PRECIO"));
                System.out.println(obj);
                listPedidoDetalle.add(obj); 
            }
        } catch (SQLException e) { System.out.println("PedidoDetalleDao"+e.toString());}

        return listPedidoDetalle;
    }
 public boolean agregar(PedidoDetalle ped) {
        boolean add = false;
        try {
            ps = this.con.prepareStatement("INSERT INTO `restaurante`.`detalle_pedido` (`DESCRIPCION`, `PRODUCTO_ID`, `PEDIDO_ID`, `ESTADO`, `CANTIDAD`, `TOTAL`, `PRECIO`, `COMENTARIO`) VALUES ('"+ped.getDescripcion()+"', '"+ped.getIdProducto()+"', '"+ped.getIdPedido()+"', '"+ped.getEstado()+"', '"+ped.getCantidad()+"', '"+ped.getTotal()+"', '"+ped.getPrecio()+"', '"+ped.getComentario()+"');");
            ps.executeUpdate();
            add = true;
        } catch (SQLException e) {
            System.out.println("Error SQL-Add: " + e.getMessage());
        }
        return add;
    }
     public boolean modificar(PedidoDetalle ped) {
        boolean edit = false;
        try {
            ps = this.con.prepareStatement("UPDATE detalle_pedido SET PRODUCTO_ID = "+ped.getIdProducto()+", PEDIDO_ID = "+ped.getIdPedido()+", ESTADO = '"+ped.getEstado()+"' WHERE ID = "+ped.getId()+";"); 
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
            ps = this.con.prepareStatement("UPDATE detalle_pedido SET ESTADO = 'I' WHERE ID ="+id+""); //consulta para optener el nivel del usuario  
            ps.executeUpdate();
            delete = true;
        } catch (SQLException e) {
            System.out.println("Error SQL-Delete: " + e.getMessage());
        }
        return delete;
    } 
    
    
}
