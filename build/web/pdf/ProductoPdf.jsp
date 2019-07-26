<%-- 
    Document   : ProductoPDF
    Created on : 07-25-2019, 02:21:21 PM
    Author     : amilcar.floresfgkss
--%>

<%@page import="com.lowagie.text.pdf.PdfPTable"%>
<%@page import="com.lowagie.text.pdf.PdfPTable"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="util.Conexion"%>
<%@page import="com.lowagie.text.Document"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
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

                
                ps = conn.prepareStatement("SELECT * FROM producto;");                // executing query
                rs = ps.executeQuery();

                document.open();

                /* new paragraph instance initialized and add function write in pdf file*/
                document.addCreationDate();

                PdfPTable table2 = new PdfPTable(1);
                table2.addCell("                                      REPORTE PRODUCTO                         ");

                PdfPTable table = new PdfPTable(3);
                table.addCell("ID");
                table.addCell("Nombre");
                table.addCell("Descripcion");
               
               

                PdfPTable pie = new PdfPTable(1);
                pie.addCell("                      Restaurante Premium El Salvador, CentroAmerica                 ");

                while (rs.next()) {
                    // fetch & writing records in pdf files
                    table.addCell(""+ rs.getString(1).toString());
                    table.addCell(""+rs.getString(2).toString());
                    table.addCell(""+rs.getString(3).toString());
  		 
		   

                }

                document.add(table);

                document.close(); //document instance closed
                conn.close();  //db connection close
            } catch (Exception de) {
                de.printStackTrace();
                System.err.println("document: " + de.getMessage());

            }

        %>
    </body
</html>
