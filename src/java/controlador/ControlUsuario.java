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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
