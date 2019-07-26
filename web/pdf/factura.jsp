<%-- 
    Document   : Facturapdf
    Created on : 07-25-2019, 02:21:21 PM
    Author     : amilcar.floresfgkss
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PedidoDao"%>
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

        <%

            String str = "pdf";     
            try {
                Document document = new Document();

                if (str.equals("pdf")) {
                    response.setContentType("application/pdf");
                    PdfWriter.getInstance(document, response.getOutputStream());
                }
                PedidoDao pedD = new PedidoDao();
                ArrayList<ArrayList<String>> lista = pedD.ListarPedidosA(1);
                
                lista.forEach(cnsmr);
                
                document.open();

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

                
                

                
                  

                

                document.add(table);

                document.close();
              
            } catch (Exception de) {
                de.printStackTrace();
                System.err.println("document: " + de.getMessage());

            }

        %>

