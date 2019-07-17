package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 * @author JOSUE TOBAR
 * @comentario Controlador de usuarios
 * @version 1.0
 */
public class SUsuario extends HttpServlet {
         Integer id = null;
         Usuario user = new Usuario();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("accion");
            int rol = 0; 
            rol =  Integer.parseInt(request.getParameter("selRol"));
            switch (action) {
                case "add":
                    user.setNombre(request.getParameter("txtNombre"));
                    user.setApellido( request.getParameter("txtApellidos"));
                    user.setSucursal(Integer.parseInt(request.getParameter("selSucursal")));
                    user.setRol(rol);
                    user.setUsername(request.getParameter("txtUser"));
                    user.setPass(request.getParameter("txtPASS"));
                   

                    if (user.agregar()) {
                        response.sendRedirect("views/usuario.jsp");
                    } else {
                        response.sendRedirect("views/usuario.jsp");
                    }
                    break;
                case "update":
                    user.setId(Integer.parseInt(request.getParameter("id")));
                    user.setNombre(request.getParameter("usuario"));
                    user.setApellido(request.getParameter("clave"));
                    user.setSucursal(Integer.parseInt(request.getParameter("sucursal")));
                    user.setPass(request.getParameter("clave"));
                    user.setRol(1);

                    if (user.modificar()) {
                        response.sendRedirect("views/usuario.jsp");
                    } else {
                        response.sendRedirect("views/usuario.jsp");
                    }
                    break;

                case "eliminar":
                   id = Integer.parseInt(request.getParameter("id"));

                    if (user.eliminar(id)) {
                        response.sendRedirect("views/usuario.jsp");
                    } else {
                        response.sendRedirect("views/usuario.jsp");
                    }
                    break;
                case "getID":
                    id = Integer.parseInt(request.getParameter("id"));

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}