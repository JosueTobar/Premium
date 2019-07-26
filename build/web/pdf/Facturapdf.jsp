<%-- 
    Document   : Facturapdf
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

                String query = "SELECT * FROM factura INNER JOIN pedido ON factura.ID = pedido.ID";          //Fetching data from table
                ps = conn.prepareStatement(query);                // executing query
                rs = ps.executeQuery();

                document.open();

                /* new paragraph instance initialized and add function write in pdf file*/
                document.addCreationDate();

                PdfPTable table2 = new PdfPTable(1);
                table2.addCell("                                      REPORTE USUARIO                         ");

                PdfPTable table = new PdfPTable(12);
                table.addCell("ID");
                table.addCell("nume");
                table.addCell("serie");
                table.addCell("subto");
                table.addCell("iva");
                table.addCell("total");
                table.addCell("estad");
                table.addCell("tipo");
                table.addCell("pedid");
                table.addCell("fecha");
                table.addCell("mesa");
                table.addCell("user");

                PdfPTable pie = new PdfPTable(1);
                pie.addCell("                      Restaurante Premium El Salvador, CentroAmerica                 ");

                while (rs.next()) {
                    // fetch & writing records in pdf files
                    table.addCell("" + rs.getString(1));
                    table.addCell("" + rs.getString(2));
                    table.addCell("" + rs.getString(3));
                    table.addCell("" + rs.getDouble(4));

                    table.addCell("" + rs.getDouble(5));
                    table.addCell("" + rs.getDouble(6));
                    table.addCell("" + rs.getString(7));
                    table.addCell("" + rs.getString(8));
                    table.addCell("" + rs.getDate(9).toString());
                    table.addCell("" + rs.getString(10));
                    table.addCell("" + rs.getString(11));
                    table.addCell("" + rs.getString(12));

                }

                document.add(table);

                document.close(); //document instance closed
                conn.close();  //db connection close
            } catch (Exception de) {
                de.printStackTrace();
                System.err.println("document: " + de.getMessage());

            }

        %>
    </body>
</html>
