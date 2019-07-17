<%-- 
    Document   : mesas
    Created on : 16-jul-2019, 21:08:37
    Author     : TOBAR
--%>

<%@page import="modelo.Categoria_Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true" %>
<%@page import="modelo.Mesa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Mesa mes = new Mesa();
    ArrayList<Mesa> listaM = mes.listaMesas();
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
        <link rel="stylesheet"
              href="http://localhost:8080/Preminum/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="http://localhost:8080/Preminum/resources/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet"
              href="http://localhost:8080/Preminum/resources/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="http://localhost:8080/Preminum/resources/dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="http://localhost:8080/Preminum/resources/dist/css/skins/skin-blue.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
        <!-- Google Font -->
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
</head>
<body class="skin-blue sidebar-mini sidebar-collapse" style="height: auto; min-height: 100%;">

    <div class="wrapper" style="height: auto; min-height: 100%;">

        <header class="main-header">



            <!-- Logo -->
            <a href="../../index2.html" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini"><b>P</b>SV</span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b>Premium</b>SV</span>
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top">
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">

                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="http://localhost:8080/Preminum/resources/img/icons/perfiles/admin.png" class="user-image" alt="User Image">
                                <span class="hidden-xs">Alexander Pierce</span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header">
                                    <img src="http://localhost:8080/Preminum/resources/img/icons/perfiles/admin.png" class="img-circle" alt="User Image">
                                    <p>
                                        Administrador
                                        <small>Member since Nov. 2012</small>
                                    </p>
                                </li>

                                <!-- Menu Footer-->
                                <li class="user-footer"> 
                                    <div class="pull-right">
                                        <a href="#" class="btn btn-default btn-flat">Cerrar Seción</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <!-- Control Sidebar Toggle Button -->

                    </ul>
                </div>
            </nav>
        </header>

        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->


            <section class="sidebar" style="height: auto;">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left image">
                        <img src="http://localhost:8080/Preminum/resources/img/icons/perfiles/admin.png" class="img-circle" alt="User Image">
                    </div>
                    <div class="pull-left info">
                        <p>Alexander Pierce</p>
                        <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                    </div>
                </div>
                <!-- search form -->
                <form action="#" method="get" class="sidebar-form">
                    <div class="input-group">


                    </div>
                </form>
                <!-- /.search form -->
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu tree" data-widget="tree">
                    <li class="header">MANTENIMIENTOS</li>
                    <li class="treeview active menu-open">
                        <a href="#">
                            <i class="fa fa-table"></i> <span>Usuarios</span>
                            <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                            </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="http://localhost:8080/Preminum/views/usuario.jsp"><i class="fa fa-circle-o"></i>Usuarios</a></li> 
                        </ul>
                    </li>

                    <li class="header">SERVICIO</li>
                    <li class="treeview active menu-open">
                        <a href="#">
                            <i class="fa fa-table"></i> <span>MESAS</span>
                            <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                            </span>
                        </a>
                        <ul class="treeview-menu" style="">
                            <li><a href="http://localhost:8080/Preminum/views/mesas.jsp"><i class="fa fa-circle-o"></i>Mesas</a></li> 
                        </ul>
                    </li>

                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper" style="min-height: 739px;">
            <!-- Content Header (Page header) -->

            <!-- Main content -->
            <section class="content">
                <dvi class="row" id="contenMesas">
                    <%if (request.getAttribute("oper") == null) {
                        for (Mesa m : listaM) {
                            String estado = m.getEstado();
                            if (estado.equals("A")) {
                                estado = "primary";
                            } else {
                                estado = "warning";;
                            };

                    %> 
                    <div class="col-md-4 mesas" >
                        <div class="box box-<%=estado%>" >

                            <div class="box-header with-border">
                                <i class="fa fa-bar-chart-o"></i>
                                <h3 class="box-title"> <%=m.getNombre()%> </h3>
                                <div class="box-tools pull-right">
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i> </button>
                                </div>
                            </div>
                            <div class="box-body" style="display: none;"> 
                                <FORM NAME="frmMesa" action="../CMesa.do?accion=add&estado=<%=estado%>&idmesa=<%=m.getId()%>&nom=<%=m.getNombre()%>" METHOD="POST">
                                    <INPUT class="btn btn-indo pull-right" TYPE="submit" VALUE="Button1" >


                                    <a class="btn btn-info "   id="nuevo" href="#nuevo" data-toggle="modal" >Agregar</a> 
                                </FORM>

                                <div id="area-chart" style="height: 50px; padding: 0px; position: relative;" class="full-width-chart"><canvas class="flot-base" width="100" height="355"></canvas><canvas class="flot-overlay" width="575" height="338"></canvas></div>
                            </div>
                        </div>
                    </div>
                    <%}
                        }%>

                </dvi>
                <dvi class="row" >

                    

                    <%
                        if (request.getAttribute("oper") != null) {
                            if (request.getAttribute("oper") == "listarC") {
                                String mesa = request.getAttribute("nom").toString();
                                String idmesa = request.getAttribute("idmesa").toString();
                                String estadoM = request.getAttribute("estado").toString();
                    %>
                    <style> .mesas { display: none;} </style>        
                    
                        <div class="box box-<%=estadoM%>">

                            <div class="box-header with-border">
                                <i class="fa fa-bar-chart-o"></i>
                                <h3 class="box-title"> <%=mesa + idmesa%> </h3>
                                <div class="box-tools pull-right">
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i> </button>
                                </div>
                            </div>
                            <div class="box-body"> 


                                <%
                                    Categoria_Producto cat = new Categoria_Producto();
                                    ArrayList<Categoria_Producto> listaCat = cat.listaCategoria_Productos();
                                    for (Categoria_Producto c : listaCat) {
                                %> 

                                <div class="col-lg-4 col-xs-6">
                                    <!-- small box -->
                                    <div class="small-box bg-aqua">
                                        <div class="inner">
                                            <h3><%=c.getNombre()%><sup style="font-size: 15px"></sup></h3>

                                            <p><%=c.getDescripcion()%></p>
                                        </div>
                                        <div class="icon">

                                            <i class="ion ion-stats-bars"></i>
                                        </div>

                                        <a href="#" class="small-box-footer"> <%=c.getDescripcion()%><i class="fa fa-arrow-circle-right"></i></a>
                                    </div>
                                </div>
                                <%
                                        }//for listaCat
                                    }//if ListarC
                                %>

                            </div>

                        </div>
                </dvi>

                <%
                    }
                %>



                <!-- Add Modal-->
                <div class="modal fade" id="nuevo">
                    <div class="modal-dialog">

                        <div class="modal-content modal-lg" >
                            <div class="modal-footer">
                                <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>

                </div>
            </section></div>
    </div>
    <!-- /.content-wrapper -->
    <!-- jQuery bootstrap -->
    <script src="http://localhost:8080/Preminum/resources/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="http://localhost:8080/Preminum//resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- DataTables -->
    <script type="text/javascript"  src="http://localhost:8080/Preminum/resourcesDataTables/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src="http://localhost:8080/Preminum/resourcesDataTables/dataTables.bootstrap4.min.js"></script>

    <!-- SlimScroll -->
    <script src="http://localhost:8080/Preminum/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="http://localhost:8080/Preminum/resources/bower_components/fastclick/lib/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="http://localhost:8080/Preminum/resources/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="http://localhost:8080/Preminum/resources/dist/js/demo.js"></script>
    <script src="http://localhost:8080/Preminum/resources/js/mantenimientos/usuarios.js"></script>
    <script src="http://localhost:8080/Preminum//script/mesa.js"></script>  

    <SCRIPT LANGUAGE="JavaScript">


    </SCRIPT>

</body>
</body>

</html>
