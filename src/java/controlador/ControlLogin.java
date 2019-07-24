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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

public class ControlLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Usuario obj_b = new Usuario();
            HttpSession ses = request.getSession();
            switch (obj_b.validar(request.getParameter("txtUsuario"), request.getParameter("txtContra"))) {
                case 1:
                    ses.setAttribute("user", request.getParameter("txtUsuario"));
                    ses.setAttribute("nivel", "1");
                    response.sendRedirect("vistas/admin.jsp");
                    break;
                case 2:
                    ses.setAttribute("user", request.getParameter("txtUsuario"));
                    request.getSession().setAttribute("nivel", "2");

                    request.getRequestDispatcher("views/indexCaja.jsp").forward(request, response);
                    break;
                case 3:
                    ses.setAttribute("user", request.getParameter("txtUsuario"));
                    request.getSession().setAttribute("nivel", "3");
                    request.getRequestDispatcher("views/indexMesero.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
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
       //Retornar los datos tipo Json 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
