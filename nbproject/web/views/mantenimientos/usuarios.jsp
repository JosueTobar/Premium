<%--
    Document    : usuarios
    Created on  : 07-08-2019, 08:46:24 AM
    Author      : Josué.Tobar
    Descripción : Mantenimiento de la tabla usuarios 
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
    <link rel="stylesheet" href="../../resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../resources/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../resources/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../resources/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../../resources/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">



    <!-- Google Font -->
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="skin-blue sidebar-mini" style="height: auto; min-height: 100%;">
    <div class="wrapper" style="height: auto; min-height: 100%;">

        <header class="main-header">
            <%@ include file="../../resources/header.jsp" %>
        </header>
        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <%@ include file="../../resources/menu.jsp" %>
            <!-- /.sidebar -->
        </aside>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper" style="min-height: 1741px;">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <button type="button" id="btnAgregar" class="btn btn-primary">+</button>

            </section>


            <!-- Main content -->
            <section class="content">
                <dvi class="row">

                </dvi>
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title" id="tituloForm">Mantenimiento Usuarios</h3>
                    </div>
                    <div class="Val-Search">
                        <div class="box-body">

                            <div class="form-group" style="display: none;">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label>Fecha Inicial</label>
                                        <input type="date" class="form-control" id="txtInicial"
                                            placeholder="FECHA INICIAL" value="0">
                                    </div>
                                    <div class="col-xs-6">
                                        <label>Fecha Final</label>
                                        <input type="date" class="form-control" id="txtFinal" placeholder="FECHA FINAL"
                                            value="99999">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="selFiltroModulos">Filtrar por:</label>
                                <select class="form-control" id="selFiltro">
                                    <option Value="TODOS">TODOS</option>
                                    <option Value="NUNFACTURA">NUMERO DE FACTURA</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="txtFiltro">Filtro:</label>
                                <input id="txtFiltro" type="text" class="form-control" />
                            </div>

                            <div class="form-group">
                                <button class="btn btn-primary" id="btnbuscar">Buscar</button>
                                <button class="btn btn-info pull-right" id="btnImprimirPDF"
                                    style="display: none;">IMPRIMIR PDF</button>

                            </div>
                        </div>
                    </div>

                    <div class="box-body">
                        <div class="Val-Table" style="display: none;">
                            <table id="example" class="display" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>nombre</th>
                                        <th>apellido</th>
                                        <th>sucursal</th>
                                        <th>usuario</th>
                                        <th>tipo</th>
                                    </tr>
                                </thead>
                                <tbody id="TDatos">

                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>id</th>
                                        <th>nombre</th>
                                        <th>apellido</th>
                                        <th>sucursal</th>
                                        <th>usuario</th>
                                        <th>tipo</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="Val-Add-Pa" style="display: none;">
                    <div class="box box-primary">
                        <div class="box-body">
                            <form role="form">
                                <div class="form-group">
                                    <div class="col-lg-6">
                                        <label for="txtNombre">Sucursal</label>
                                        <select class="form-control" id="selSucursal" name="selSucursal">
                                            <option values="-1">Cargando... </option>
                                        </select>
                                    </div>
                                    <div class="col-lg-6">
                                        <label for="txtNombre">Nombres</label>
                                        <input type="text" class="form-control" id="txtNombre" placeholder="Nombre">
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="col-lg-6">
                                        <label for="txtApellidos">Apellidos</label>
                                        <input type="text" class="form-control" id="txtApellidos"
                                            placeholder="Apellidos">
                                    </div>
                                    <div class="col-lg-6">
                                        <label for="txtUsuario">Usuario</label>
                                        <input type="text" class="form-control" id="txtUsuario" placeholder="Usuario">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-6">
                                        <label for="exampleInputPassword1">Contraseña</label>
                                        <input type="password" class="form-control" id="txtContra"
                                            placeholder="Password">
                                    </div>
                                    <div class="col-lg-6">
                                        <label for="exampleInputPassword1">Confirmar</label>
                                        <input type="password" class="form-control" id="txtConfirmaContra"
                                            placeholder="Password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-6">
                                        <label for="txtRol">Tipo</label>
                                        <input type="text" class="form-control" id="txtRol" placeholder="Usuario">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-6">
                                        <button type="submit" id="btnSubmit" value="" class="btn btn-primary"></button>
                                        <button type="button" id="btnCancelarForm" value=""
                                            class="btn btn-danger">Cancelar</button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
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
    <script src="../../resources/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="../../resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- DataTables -->
    <script type="text/javascript" charset="utf8"
        src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

    <!-- SlimScroll -->
    <script src="../../resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="../../resources/bower_components/fastclick/lib/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="../../resources/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../../resources/dist/js/demo.js"></script>
    <script src="../../resources/js/mantenimientos/usuarios.js"></script>

</body>

</html>