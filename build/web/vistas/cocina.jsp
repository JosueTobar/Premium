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
        <link rel="stylesheet" href="../resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="../resources/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="../resources/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="../resources/dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="../resources/dist/css/skins/skin-blue.min.css">

        <link rel="stylesheet" href="../resources/css/estilo.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
   </head>
   <body class="skin-blue skin-blue sidebar-mini sidebar-collapse-mini sidebar-collapse" style="height: auto; min-height: 100%;">
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
    
    <li class="treeview active menu-open">
      
      <ul class="treeview-menu">
        <li></li> 
      </ul>
    </li>
    
     <li class="treeview active">
      
      <ul class="treeview-menu" style="display: none;">
        <li><a href="../vistas/categorias.jsp"><i class="fa fa-circle-o"></i>Categorias</a></li> 
        <li><a href="../vistas/productos.jsp"><i class="fa fa-circle-o"></i>Productos</a></li> 
      
      </ul>
    </li>
    <li class="treeview active menu-open">
      
      <ul class="treeview-menu">
        <li></li> 
      </ul>
    </li>
     
    
  </ul>
</section>
            <!-- /.sidebar -->
        </aside>
        <div class="content-wrapper" style="min-height: 993px;">
            <!-- Main content -->
            <div class="row">
              <div class="col-lg-5">. </div>
              <div class="col-lg-2"> </div>
              <div class="col-lg-5">
                  
                  
              </div>
            </div>
            <div class="row">
              <div class="col-lg-5"> </div>
              <div class="col-lg-2">  <button class="btn btn-danger pull-right" id="btnBuscar">Actualizar</button> </div>
              <div class="col-lg-5">
              </div>
            </div>
            <div class="row">
                
              <div class="col-lg-4"> 
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
                                
                                <button class="btn btn-danger pull-right" id="btnAddPedido">Enviar</button>
                                <input type="text" style="display: none"  >
                               
                                
                            </div>
                        </div>
              
              </div>
              
              
              <div class="col-lg-4">
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
                                
                                <button class="btn btn-danger pull-right" id="btnAddPedido">Enviar</button>
                                <input type="text" style="display: none"  >
                               
                                
                            </div>
                        </div></div>
              <div class="col-lg-4">
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
                                
                                <button class="btn btn-danger pull-right" id="btnAddPedido">Enviar</button>
                                <input type="text" style="display: none"  >
                               
                                
                            </div>
                        </div></div>
              
              </div>
            </div>
            <!-- /.box-body -->
        </div>
    </div>
    <!-- /.row -->

<!-- /.Val-table -->

<!-- /.content -->

<!-- /.content-wrapper -->
<!-- jQuery bootstrap -->
<script src="../resources/bower_components/jquery/dist/jquery.min.js"></script>
<script src="../resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../resources/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../resources/dist/js/demo.js"></script>
<script src="../resources/js/mantenimientos/ceuntas.js"></script> 

</body>
</html>
