<%-- 
    Document   : cuentas
    Created on : 07-22-2019, 10:43:20 AM
    Author     : josue.tobarfgkss
--%>

<%@page import="modelo.Mesa"%>
<%@page import="modelo.Categoria_Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.MesaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    MesaDao mes = new MesaDao();
    Categoria_Producto catp = new Categoria_Producto();
    ArrayList<Mesa> listaM = mes.listaMesas();
    ArrayList<Categoria_Producto> listaCat = catp.listaCategoria_Productos();
%>
<!DOCTYPE html>
<html>

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

        <link rel="stylesheet" href="../resources/css/estilo.css">
    </head>


    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
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
        <div class="content-wrapper" style="min-height: 1741px;">
            <!-- Main content -->
            <section class="content">
                <dvi class="row">

                    <div class="col-lg-3">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title" id="tituloForm">Mesa</h3>
                            </div>
                            <div class="box-body">
                                <select class="form-control" id="selMesa" name="selMesa">
                                    <% for (Mesa m : listaM) {%>
                                    <option value="<%=m.getId()%>"> <%=m.getNombre()%> </option>
                                    <%}%>
                                </select>
                                <div class="contenedorM">
                                    <table class="table" id="tableP">
                                        <tbody id="mesas">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div> 

                    </div>
                    <div class="col-lg-4">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title" id="tituloForm">Platos</h3>
                            </div>
                            <div class="box-body">

                                <select class="form-control" id="selCategoria" name="selCategoria">
                                    <% for (Categoria_Producto cp : listaCat) {%>
                                    <option value="<%=cp.getId()%>"> <%=cp.getNombre()%> </option>
                                    <%}%>
                                </select>
                                <div class="contenedorP">
                                    <table class="table" id="tableP">
                                        <tbody id="productos">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>  

                    </div>
                    <div class="col-lg-5">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title" id="tituloForm">Cuenta</h3>
                            </div>
                            <div class="box-body">
                                <div class="contenedorP">
                                    <table class="table" id="tableP">
                                        <tbody id="pedido">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="box-footer">
                                <input type="button" id="btnAddPedido"  class="btn btn-success pull-right" value="Enviar"  />
                               
                                <input type="text" style="display: none"  >
                               
                                
                            </div>
                        </div>

                    </div>
                </dvi>
            </section>
            <!-- /.box-body -->
        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.Val-table -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<!-- jQuery bootstrap -->
<script src="../resources/bower_components/jquery/dist/jquery.min.js"></script>
<script
src="../resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script
src="../resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../resources/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../resources/dist/js/demo.js"></script>
<script src="../resources/js/mantenimientos/ceuntas.js"></script> 
</body>
</html>