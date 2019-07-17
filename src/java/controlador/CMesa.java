package controlador;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CMesa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher res;
            if(request.getParameter("accion") != null){
            String accion = request.getParameter("accion");
            switch (accion) {
                case "add":
                   request.setAttribute("oper","listarC");
               
                   //request.getRequestDispatcher("views/mesas.jsp").forward(request, response);
                   response.sendRedirect("views/mesas.jsp"); 
                    break;
                case "producto":

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
        processRequest(request, response);

        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
