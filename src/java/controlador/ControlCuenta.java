
package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;


/**
 *
 * @author TOBAR
 */
public class ControlCuenta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class); //Instanciar objetos tipo Gson y resivir los datos de la petición 
        String accion = data.get("pAccion").getAsString();   //Optener datos de la petición 
        String json = " ";
        ProductoDao pro = new ProductoDao();
        Pedido ped = new Pedido();
        PedidoDao pedDao = new PedidoDao();
        PedidoDetalle pedD = new PedidoDetalle();
        PedidoDetalleDao pedDDao = new PedidoDetalleDao();
        MesaDao mes = new MesaDao();
        ArrayList<String> respuesta = new ArrayList<>();
        switch (accion) {
            case "listProducto":
                ArrayList<Producto> producto = pro.listaProductosPorCategoria(Integer.parseInt(data.get("pId").getAsString()));
                json = new Gson().toJson(producto);
                break;
            case "ListarMesa":
                ArrayList<Mesa> mesas = mes.listaMesasByID(Integer.parseInt(data.get("pId").getAsString()));
                 json = new Gson().toJson(mesas);
                break;
            case "addPedido":
                 
                 ped.setFecha(Date.valueOf(data.get("pFecha").getAsString()));
                 ped.setEstado("A");
                 ped.setIdMesa(Integer.parseInt(data.get("pMesa").getAsString()));
                 ped.setIdUsuario(data.get("pUsurio").getAsInt());
                 respuesta = pedDao.agregar(ped);
                 json = new Gson().toJson(respuesta);
                break;  
                case "addPedidoDetalle":
                 pedD.setDescripcion(data.get("pDescripcion").getAsString());
                 pedD.setIdProducto(data.get("pProducto").getAsInt());
                 pedD.setIdPedido(Integer.parseInt(data.get("pPedido").getAsString()));
                 pedD.setCantidad(Integer.parseInt(data.get("pTotoal").getAsString()));
                 pedD.setTotal(Integer.parseInt(data.get("pTotoal").getAsString()));
                 pedD.setPrecio(Float.parseFloat(data.get("pPrecio").getAsString()));
                 pedD.setEstado("A");
                 pedDDao.agregar(pedD);
                 pedD.setComentario("hola mundo");
                 json = new Gson().toJson("hola");
                break;  
              
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
