<%--
    Document    : usuarios
    Created on  : 07-08-2019, 08:46:24 AM
    Author      : Josué.Tobar
    Descripción : Mantenimiento de la tabla usuarios 
--%>

<%@page import="modelo.Rol"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"  %>
<%
    Usuario usu = new Usuario();//Intancia de Objento 
    ArrayList<Usuario> list = usu.mostrar();
    Rol rol = new Rol();
    ArrayList<Rol> listRol = rol.listaRoles();
    
    Integer id =null;
    
   
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
                            <div class="box-body ">

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
                                    <button class="btn btn-info pull-right" id="btnImprimirPDF"
                                            style="display: none;">IMPRIMIR PDF</button>
                                    <a class="btn btn-primary" href="../../SUsuario.do?accion=select">Buscar</a>


                                </div>
                            </div>
                        </div>

                        <div class="box-body">
                            <div class="Val-Table" style="display: none;">
                                <table id="dataTable" class="display table" style="width:100%">
                                    <thead>

                                        <tr>
                                            <th>ACCION</th>
                                            <th>nombre</th>
                                            <th>apellido</th>
                                            <th>sucursal</th>
                                            <th>usuario</th>
                                            <th>tipo</th>
                                        </tr>
                                    </thead>
                                    
                                        <% 
                                            String accionModificar = "usuarios.jsp?id=";
                                            String accionEliminar = "../SUsuario.do?accion=eliminar&id=";
                                            for (Usuario us : list){
                                        %>
                                        <tr>
                                            <td>
                                                <div class='row ValAcc'>
                                                    <div class='col-xs-12 Val-UDP'><a class='btn btn-info btn-sm'
                                                                                      id='btnModificar' href="<%=accionModificar%><%=us.getId()%>">
                                                            <span class='glyphicon glyphicon-wrench'></span></a> <a
                                                            class='btn btn-danger btn-sm' id='btnEliminar'
                                                            href="<%=accionEliminar%><%=us.getId()%>"><span
                                                                class='glyphicon glyphicon-remove'></span></a> </div>
                                                </div>
                                            </td>
                                            <td><%=us.getNombre()%></td>
                                            <td><%=us.getApellido()%></td>
                                            <td><%=us.getSucursal()%></td>
                                            <td><%=us.getUsername()%></td>
                                            <td><%=us.getRol()%></td>
                                        </tr>
                                        <%}%>
                                    
                                    <tfoot>
                                        <tr>
                                            <th>ACCION</th>
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
                                <form role="form" action="../SUsuario.do" method="POST">
                                    <input type="hidden" name="accion" value="add">
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <label for="selSucursal">Sucursal</label>
                                            <select class="form-control" id="selSucursal" name="selSucursal">
                                                <option values="-1">Cargando... </option>
                                            </select>
                                        </div>
                                        <div class="col-lg-6">                   
                                            <label for="txtNombre">Nombres</label>
                                            <input type="text" class="form-control" id="txtNombre" name="txtNombre"  placeholder="Nombre">
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <label for="txtApellidos">Apellidos</label>
                                            <input type="text" class="form-control" id="txtApellidos" name="txtApellidos" placeholder="Apellidos">
                                        </div>
                                        <div class="col-lg-6">
                                            <label for="txtUsuario">Usuario</label>
                                            <input type="text" class="form-control" id="txtUsuario" name="txtUser"
                                                   placeholder="Usuario">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                            <label for="txtContra">Contraseña</label>
                                            <input type="password" class="form-control" id="txtContra" name="txtPASS"
                                                   placeholder="Password">
                                        </div>
                                        <div class="col-lg-6">
                                            <label for="txtConfirmaContra">Confirmar</label>
                                            <input type="password" class="form-control" id="txtConfirmaContra"
                                                   placeholder="Password">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-lg-6">
                                          <label for="selSucursal">Tipo</label>
                                            <select class="form-control" id="selSucursal" name="selTipo">
                                                <% for(Rol obj : listRol){ 
                                                    out.print("<option values='"+obj.getId()+"'>"+obj.getNombre()+" </option>"); 
                                                   }%>
                                            </select>
                                        </div>
                                        <div class="col-lg-6">
                                            
                                        </div>
                                    </div>
                                   
                                <div class="form-group">
                                    <div class="col-lg-6">
                                        <div class="btnAdd" style="display: nome;">
                                            <input type="submit"  />

                                        </div>
                                        <div class="btnEdit" style="display: nome;">
                                            <a class="btn btn-warning" href="../SUsuario.do?accion=edit">Modificar</a>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <button type="button" id="btnCancelarForm pull-left" value="" class="btn btn-danger">Cancelar</button>
                                    </div>
                            </div>
                         </form>
                    </div>
                            
                            
                           
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
<script src="http://localhost:8080/Preminum/resources/bower_components/jquery/dist/jquery.min.js"></script>
<script
src="http://localhost:8080/Preminum//resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://localhost:8080/Preminum/resourcesDataTables/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://localhost:8080/Preminum/resourcesDataTables/dataTables.bootstrap4.min.js"></script>

<!-- SlimScroll -->
<script
src="http://localhost:8080/Preminum/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="http://localhost:8080/Preminum/resources/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="http://localhost:8080/Preminum/resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="http://localhost:8080/Preminum/resources/dist/js/demo.js"></script>
<script src="http://localhost:8080/Preminum/resources/js/mantenimientos/usuarios.js"></script>
<script>
    //dataTable
    
     $(function () {
                $('#dataTable').DataTable({
                    'paging': true,
                    'lengthChange': false,
                    'searching': false,
                    'ordering': true,
                    'info': true,
                    'autoWidth': false
                });
            });
  
</script>
</body>

</html>
