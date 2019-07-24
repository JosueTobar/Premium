<%-- 
    Document   : nuevaOrden
    Created on : 18-jul-2019, 16:57:46
    Author     : TOBAR
--%>
<%@page import="modelo.Categoria_Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true" %>
<%@page import="modelo.Mesa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Mesa mes = new Mesa();
    ArrayList<Mesa> listaMes = mes.listaMesas();
    Categoria_Producto cat = new Categoria_Producto();
    ArrayList<Categoria_Producto> listaCat = cat.listaCategoria_Productos();
%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Premium | SV</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="../resources/bower_components/bootstrap/dist/css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="../resources/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="../resources/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="../resources/dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="../resources/dist/css/skins/skin-blue.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <link rel="stylesheet" href="../resources/css/estilo.css">    </head>
</head>
<body class="skin-blue sidebar-mini sidebar-collapse" style="height: auto; min-height: 100%;">

    <div class="wrapper" style="height: auto; min-height: 100%;">

        <header class="main-header">
            <%@ include file="../resources/header.jsp" %>
        </header>

        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <%@ include file="../resources/menu.jsp" %>
            <!-- /.sidebar -->
        </aside>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper" style="min-height: 739px;">
            <!-- Content Header (Page header) --> 
            <section class="content">
                <dvi class="row" id="contenPedido">
                    <div class="col-sm-4" id="mesas">
                        <div class="form-group">
                            <label for="selFiltroModulos">MESA</label>
                            <select class="form-control" onchange=" getProductos(this.value);" id="selFiltro">
                                <%
                                    for (Mesa m : listaMes) {
                                %><option Value="<%=m.getId()%>"><%=m.getNombre()%> </option><%
                                          }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-4" id="productos">
                        <div class="form-group">
                            <label for="selFiltroModulos">PROSUCTO</label>
                            <select class="form-control" onchange=" getProductos(this.value);" id="selFiltro" >
                                <option Value="TODOS">TODOS</option>
                                <%
                                    for (Categoria_Producto c : listaCat) {
                                        %><option  Value="<%=c.getId()%>" ><%=c.getNombre()%> </option><% }
                                %>
                            </select>
                        </div>
                            <dii id="contenedorProductos">
                                
                                
                            </dii>
                    </div>
                    <div class="col-sm-4" id="pedido">
                        <div class="form-group">
                            <label for="selFiltroModulos">PEDIDO</label>
                            <select class="form-control" id="selFiltro">
                                <option Value="TODOS">TODOS</option>
                                <option Value="NUNFACTURA">NUMERO DE FACTURA</option>
                            </select>
                        </div>
                    </div>
                    </div>
            </section>
        </div>
    </div>
    <!-- /.content-wrapper -->
    <!-- jQuery bootstrap -->
    <script src="../resources/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="../resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- DataTables -->
    <script type="text/javascript"  src="../resourcesDataTables/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src="../resourcesDataTables/dataTables.bootstrap4.min.js"></script>

    <!-- SlimScroll -->
    <script src="../resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="../resources/bower_components/fastclick/lib/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="../resources/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../resources/dist/js/demo.js"></script>
    <script src="../resources/js/mantenimientos/usuarios.js"></script>
    <script src="../script/mesa.js"></script>  

    <SCRIPT LANGUAGE="JavaScript">
       function getProductos(id){
           var data = {pAccion: "listaPro", pID:id};
    $("#contenedorProductos").remove().end();
    $.ajax({
        type: "POST", //Metodo por el que se realiza la petición 
        url: "../Poductos.do", //url del servlet al que apunta la petición
        contentType: "application/json", // NOT dataType!
        data: JSON.stringify(data),
        success: function (response) {
            if (!response['error']) {
                $.each(response, function (ind) {
                    $("#contenedorProductos").append("" + response[ind].id + "___" + response[ind].nombre + " ");
                });
            }
        }
    });
        } 
       function setMesa(id){
    
           
       }

    </SCRIPT>

</body>
</body>

</html>
