package modelo;

/**
 *
 * @author TOBAR
 */
public class PedidoDetalle {
    private int id;
    private int idPedido;
    private int idProducto;
    private String estado;

    public PedidoDetalle(int id, int idPedido, int idProducto, String estado) {
        this.id = id;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
    public PedidoDetalle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
    
    
}
