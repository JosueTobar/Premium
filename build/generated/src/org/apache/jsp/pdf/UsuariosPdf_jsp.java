package org.apache.jsp.pdf;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import util.Conexion;
import com.lowagie.text.Document;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class UsuariosPdf_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center><h1>----------------------------------Reporte de usuarios----------------------------------</h1></center>\n");
      out.write("    <center><h6><a href=\"usuarios.jsp\">Ir al usuario</a></h6></center>\n");
      out.write("        ");

            //LINK DEL SITIO CONSULTADO:
            /*
                http://shashikantvaidyamydiscovery.blogspot.com/2012/11/how-to-create-simple-report-in-jsp-with.html
            */
            //Declarando variables para PDF
            String str = "pdf";
            
            //Declarando variables a ocupar

            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            //Try Catch para mandar a llamar los datos guardados en nuestra base de datos para despues mostrarlo en un pdf
            try {
                Document document = new Document();
                

                Conexion objCon = new Conexion();
                conn = objCon.getConexion();
                

                if (str.equals("pdf")) {
                    response.setContentType("application/pdf");
                    PdfWriter.getInstance(document, response.getOutputStream());
                }

                String query = "select * from usuario";          //Fetching data from table
                ps = conn.prepareStatement(query);                // executing query
                rs = ps.executeQuery();

                document.open();

                /* new paragraph instance initialized and add function write in pdf file*/
               
                
                document.addCreationDate();
                
                
             
                
                PdfPTable table2 = new PdfPTable(1);  
                    table2.addCell("                                      REPORTE USUARIO                         ");
                                    
                PdfPTable table = new PdfPTable(4);  
                    table.addCell("ID");
                    table.addCell("NOMBRE");
                    table.addCell("APELLIDO");
                    table.addCell("ESTADO");
                    
                 PdfPTable pie = new PdfPTable(1);  
                    pie.addCell("                      Restaurante Premium El Salvador, CentroAmerica                 ");
            
                    
                while (rs.next()) {
                    // fetch & writing records in pdf files
                    table.addCell(""+ rs.getString(1).toString());
                   // table.addCell(""+rs.getString(5).toString());
                    table.addCell(""+rs.getString(2).toString());
                    table.addCell(""+rs.getString(3).toString());
                    //document.add(new Paragraph("\nNOMBRE ::" + rs.getString(1) + "\n APELLIDO ::" + rs.getString(5) + "\n USUARIO ::" + rs.getString(2) + "\n CONTRA ::" + rs.getString(3)));
                }
                document.add(table2);
                document.add(table);
                document.add(pie);
                
                document.close(); //document instance closed
                conn.close();  //db connection close
            } catch (Exception de) {
                de.printStackTrace();
                System.err.println("document: " + de.getMessage());

            }

        
      out.write("\n");
      out.write("</body>\n");
      out.write("</html> \n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
