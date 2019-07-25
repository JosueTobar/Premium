/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        MesaDao mes = new MesaDao();
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
                 Pedido ped = new Pedido();
                 ped.setFecha(Date.valueOf(data.get("pFecha").getAsString()));
                 ped.setEstado("A");
                 ped.setIdMesa(Integer.parseInt(data.get("pMesa").getAsString()));
                 ped.setIdUsuario(Integer.parseInt(data.get("pUsurio").getAsString()));
                 json = new Gson().toJson("add");
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
