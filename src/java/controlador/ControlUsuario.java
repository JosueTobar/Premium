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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.UsuarioDao;

/**
 *
 * @author TOBAR
 */
public class ControlUsuario extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class); //Instanciar objetos tipo Gson y resivir los datos de la petición 
        String accion = data.get("pAccion").getAsString();   //Optener datos de la petición 
               UsuarioDao objDao = new UsuarioDao();
               Usuario obju = new Usuario();
        switch (accion) {
            case "SELECT": //Isntanciar un objeto y solicitar una consulta 
                    //Istancia de la clase SusursalDao 
                List lista = objDao.mostrar();          //Metodo que debuelbe lista de sucursales
                String json = new Gson().toJson(lista);      //Combertir la lista en un tipo deato Json 
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);            //Retornar los datos tipo Json 
                break;
            case "INSERT":
                obju.setNombre(data.get("pNombre").getAsString());
                obju.setApellido(data.get("pApellido").getAsString());
                obju.setUsername(data.get("pUsuario").getAsString());
                obju.setPass(data.get("pContra").getAsString());
                obju.setSucursal(Integer.parseInt(data.get("pUsuario").getAsString()));
                obju.setRol(Integer.parseInt(data.get("pRol").getAsString()));
                objDao.ingresar(obju);
                break;
            case "UPDATE": //Instanciar un objeto y realizar una actualizacion 
                break;
            case "DELETE": // Eliminar 
                break;

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
