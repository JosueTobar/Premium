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
import modelo.Categoria_Producto;

/**
 *
 * @author TOBAR
 */
public class ControlCategoria extends HttpServlet {
    Categoria_Producto cat = new Categoria_Producto();
    Integer id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           if (request.getParameter("accion") != null) {
                String action = request.getParameter("accion");
                switch (action) {
                    case "add":
                        cat.setNombre(request.getParameter("txtNombre"));
                        cat.setImagen(request.getParameter("selImagen"));
                        cat.setDescripcion(request.getParameter("txtDescricion"));
                        cat.setEstado(request.getParameter("selEstado"));
                        
                        if (cat.agregar()) {
                            response.sendRedirect("vistas/categorias.jsp");
                        } else {
                            response.sendRedirect("vistas/categorias.jsp");
                        }
                        break;
                    case "edit":                        
                        cat.setId(Integer.parseInt(request.getParameter("Id")));
                        cat.setNombre(request.getParameter("txtNombre"));
                        cat.setImagen(request.getParameter("selImagen"));
                        cat.setDescripcion(request.getParameter("txtDescricion"));
                        if (cat.modificar()) {
                            response.sendRedirect("vistas/categorias.jsp");
                        } else {
                            response.sendRedirect("vistas/categorias.jsp");
                        }
                        break;

                    case "eliminar":
                        id = Integer.parseInt(request.getParameter("id"));

                        if (cat.eliminar(id)) {
                            response.sendRedirect("vistas/categorias.jsp");
                        } else {
                            response.sendRedirect("vistas/categorias.jsp");
                        }
                        break;
                    default:
                        response.sendRedirect("vistas/categorias.jsp");
                        break;
                }
            }else{
              response.sendRedirect("vistas/categorias.jsp");
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
