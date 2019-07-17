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
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

/**
 *
 * @author josue.tobarfgkss
 */
public class ControlLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String username = request.getParameter("txtUsuario");
            String contra = request.getParameter("txtContra");
            String sucursal = request.getParameter("selSucursal");

            RequestDispatcher res;
            Usuario obj_b = new Usuario();
                
            if (!username.equals("") && !contra.equals("")) {

                switch (obj_b.validar(username, contra, sucursal)) {
                    case 1:
                        HttpSession ses = request.getSession();
                        ses.setAttribute("user",username);
                        ses.setAttribute("nivel","1");
                        request.getRequestDispatcher("indexAdmin.jsp").forward(request, response);
        
                        break;
                    case 2:
                        
                        request.getSession().setAttribute("usuario",username);
                        request.getSession().setAttribute("nivel","2");
                        request.getSession().setAttribute("sucursal",sucursal);
                        request.getRequestDispatcher("views/indexCaja.jsp").forward(request, response);
                        break;
                    case 3:
                        request.getSession().setAttribute("usuario",username);
                        request.getSession().setAttribute("nivel","3");
                        request.getSession().setAttribute("sucursal",sucursal);
                        request.getRequestDispatcher("views/indexMesero.jsp").forward(request, response);
                        break;
                    default:
                          request.getRequestDispatcher("index.jsp").forward(request, response);
                        break;
                }
            }
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
        String sucursals = data.get("pNombre").getAsString();//Optener datos de la petición 

        SucursalDao obj = new SucursalDao();         //Istancia de la clase SusursalDao 
        List lista = obj.listaSucursales();          //Metodo que debuelbe lista de sucursales
        String json = new Gson().toJson(lista);      //Combertir la lista en un tipo deato Json 
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);            //Retornar los datos tipo Json 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
