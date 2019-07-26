<%-- 
    Document   : mesero
    Created on : 20-jul-2019, 22:57:14
    Author     : TOBAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Premium | SV</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet"
              href="../resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="../resources/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet"
              href="../resources/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="../resources/dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="../resources/dist/css/skins/skin-blue.min.css">

        <link rel="stylesheet" href="../resources/css/estilo.css">    </head>


    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="skin-blue sidebar-mini" style="height: auto; min-height: 100%;">
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

                </dvi>
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title" id="tituloForm">Caja</h3>
                    </div>
                   

                    <!-- Mostrar -->
                    <div class="box-body">
                        <div class="Val-Table" >
                            <table id="example" class="display table" style="width:100%">
                                <thead>

                                    <tr>
                                        <th>ACCIÓN</th>
                                        <th>NOMBRE</th>
                                        <th>ESTADO</th>
                                    </tr>
                                </thead>
                                <tbody id="tablaC">
                                    
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>ACCIÓN</th>
                                        <th>NOMBRE</th>
                                        <th>ESTADO</th> 
                                    </tr>
                                </tfoot>
                            </table>


                        </div>
                    </div>
                </div>
                <div class="Val-Add-Pa">
                    
                </div>
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

<!-- SlimScroll -->
<script
src="../resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../resources/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../resources/dist/js/demo.js"></script>
<script src="../resources/js/mantenimientos/caja.js"></script> 
</body>
</html>