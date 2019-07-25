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
import modelo.Usuario;

/**
 *
 * @author TOBAR
 */
public class ControlUsuario extends HttpServlet {

    Integer id = null;
    Usuario user = new Usuario();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           if (request.getParameter("accion") != null) {
                String action = request.getParameter("accion");
                switch (action) {
                    case "add":
                        user.setNombre(request.getParameter("txtNombre"));
                        user.setApellido(request.getParameter("txtApellidos"));
                        user.setRol(Integer.parseInt(request.getParameter("selTipo")));
                        user.setUsername(request.getParameter("txtUser"));
                        user.setPass(request.getParameter("txtPASS"));
                        user.setEstado("A");
                        if (user.agregar()) {
                            response.sendRedirect("vistas/usuario.jsp");
                        } else {
                            response.sendRedirect("vistas/usuario.jsp");
                        }
                        break;
                    case "edit":
                        user.setId(Integer.parseInt(request.getParameter("Id")));
                        user.setNombre(request.getParameter("txtNombre"));
                        user.setApellido(request.getParameter("txtApellidos"));
                        user.setUsername(request.getParameter("txtUser"));
                        user.setRol(Integer.parseInt(request.getParameter("selTipo")));
                        user.setEstado(request.getParameter("selEstado"));
                        if (user.modificar()) {
                            response.sendRedirect("vistas/usuario.jsp");
                        } else {
                            response.sendRedirect("vistas/usuario.jsp");
                        }
                        break;

                    case "eliminar":
                        id = Integer.parseInt(request.getParameter("id"));

                        if (user.eliminar(id)) {
                            response.sendRedirect("vistas/usuario.jsp");
                        } else {
                            response.sendRedirect("vistas/usuario.jsp");
                        }
                        break;
                    default:
                        response.sendRedirect("vistas/usuario.jsp");
                        break;
                }
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
