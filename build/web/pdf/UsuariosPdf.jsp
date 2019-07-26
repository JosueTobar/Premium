<%-- 
    Document   : UsuariosPdf
    Created on : 07-24-2019, 09:38:37 AM
    Author     : amilcar.floresfgkss
--%>


<%@page import="com.lowagie.text.pdf.PdfPTable"%>
<%@page import="com.lowagie.text.Paragraph"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="util.Conexion"%>
<%@page import="com.lowagie.text.Document"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>----------------------------------Reporte de usuarios----------------------------------</h1></center>
    <center><h6><a href="usuarios.jsp">Ir al usuario</a></h6></center>
        <%
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

        %>
</body>
</html> 
