<%-- 
    Document   : mesas
    Created on : 16-jul-2019, 21:08:37
    Author     : TOBAR
--%>

<%@page import="modelo.MesaDao"%>
<%@page import="modelo.Mesa"%>
<%@page import="modelo.Categoria_Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    MesaDao mes = new MesaDao();
    ArrayList<Mesa> listaM = mes.listaMesas();
%>
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
                        <h3 class="box-title" id="tituloForm">Mantenimiento Mesas</h3>
                    </div>
                    <div class="box-body">
                        <form role="form" action="../ControlMesa.do" method="POST">
                            <input type="hidden" name="accion" value="add">
                            <div class="form-group">

                                <div class="col-lg-6">                   
                                    <label for="txtNombre">Nombres</label>
                                    <input type="text" class="form-control"  name="txtNombre"  placeholder="Nombre" required>
                                </div>
                                <div class="col-lg-6 "> 
                                    <label for="Estado">Estado</label>
                                    <select class="form-control" id="selEstado" name="selEstado">
                                        <option value="A">ACTIVO</option>
                                        <option value="I">INACTIVO</option>
                                        <option value="B">BLOQUEADO</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group" style="margin-top: 15px;">
                                <div class="col-lg-6">  
                                </div>
                                <div class="col-lg-6">
                                    <input type="submit"  class="btn btn-success pull-right" value="Agregar"  />
                                </div>
                            </div>

                        </form>
                    </div>

                    <!-- Mostrar -->
                    <div class="box-body">
                        <div class="Val-Table" >
                            <table id="dataTable" class="display table" style="width:100%">
                                <thead>

                                    <tr>
                                        <th>ACCIÓN</th>
                                        <th>NOMBRE</th>
                                        <th>ESTADO</th>
                                    </tr>
                                </thead>

                                <%
                                    for (Mesa m : listaM) {
                                %>
                                <tr>
                                    <td>
                                        <div class='row ValAcc'>
                                            <div class='col-xs-12 Val-UDP'>
                                                <a onclick="cargarform(<%=m.getId()%>, '<%=m.getNombre()%>', '<%=m.getEstado()%>');"  href="#nuevo" class='btn btn-info btn-sm'  data-toggle="modal"  >
                                                    <span class='glyphicon glyphicon-wrench'></span></a> 
                                                <a class='btn btn-danger btn-sm' id='btnEliminar'
                                                   href="../ControlMesa.do?accion=eliminar&id=<%=m.getId()%>"><span
                                                        class='glyphicon glyphicon-remove'></span></a> </div>
                                        </div>
                                    </td>
                                    <th><%=m.getNombre()%></th>
                                    <th><%=m.getEstado()%></th>
                                </tr>
                                <%}%>
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
                    <div class="box box-primary">

                        <!-- Modificar  -->
                        <div id="nuevo" class="modal animated bounceIn fullscreen-modal" tabindex="-1"  role="dialog"  aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">

                                <div class="modal-content">

                                    <div class="modal-header">						
                                        <h4 class="modal-title">Editar Producto</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    </div>
                                    <form action="../ControlMesa.do"  method="Post" name="Update">
                                        <input type="hidden" name="accion" value="edit">
                                        <input type="hidden" name="Id" id="Id">

                                        <div class="modal-body">
                                            <div class="form-group">
                                                <div class="col-lg-6">                   
                                                    <label for="txtNombre">Nombres</label>
                                                    <input type="text" class="form-control" id="txtNombre"  name="txtNombre"  placeholder="Nombre" required>
                                                </div>
                                                <div class="col-lg-6 "> 
                                                    <label for="Estado">Estado</label>
                                                    <select class="form-control" id="selEstado" name="selEstado">
                                                        <option value="A">ACTIVO</option>
                                                        <option value="I">INACTIVO</option>
                                                        <option value="B">BLOQUEADO</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group">

                                                <div class="col-lg-6 "> 
                                                    <input type="submit" class="btn btn-primary  pull-right" value="Guardar cambios">
                                                </div>
                                                <div class="col-lg-6 "> 
                                                    <input type="button" class="btn btn-danger pull-left" data-dismiss="modal" value="Cancelar">
                                                </div>
                                            </div>

                                        </div>
                                        <div class="modal-footer">
                                        </div>
                                    </form>

                                </div>

                            </div>
                            <!-- dialog -->
                        </div>
                    </div>
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
<script src="../resources/js/mantenimientos/mesas.js"></script> 
</body>
</html>
