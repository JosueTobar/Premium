/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Mesa;
import modelo.MesaDao;

/**
 *
 * @author TOBAR
 */
public class ControlMesa extends HttpServlet {

    Mesa mes = new Mesa();
    MesaDao mesD = new MesaDao();
    Integer id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("accion") != null) {
                String action = request.getParameter("accion");
                switch (action) {
                    case "add":
                        mes.setNombre(request.getParameter("txtNombre"));
                        mes.setEstado(request.getParameter("selEstado"));
                        if (mesD.agregar(mes)) {
                            response.sendRedirect("vistas/mesas.jsp");
                        } else {
                            response.sendRedirect("vistas/mesas.jsp");
                        }
                        break;
                    case "edit":                        
                        mes.setId(Integer.parseInt(request.getParameter("Id")));
                        mes.setNombre(request.getParameter("txtNombre"));
                        mes.setEstado(request.getParameter("selEstado"));
                        if (mesD.modificar(mes)) {
                            response.sendRedirect("vistas/mesas.jsp");
                        } else {
                            response.sendRedirect("vistas/mesas.jsp");
                        }
                        break;

                    case "eliminar":
                        id = Integer.parseInt(request.getParameter("id"));

                        if (mesD.eliminar(id)) {
                            response.sendRedirect("vistas/mesas.jsp");
                        } else {
                            response.sendRedirect("vistas/mesas.jsp");
                        }
                        break;
                    default:
                        response.sendRedirect("vistas/mesas.jsp");
                        break;
                }
            }else{
              response.sendRedirect("vistas/mesas.jsp");
            }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
