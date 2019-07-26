<%-- 
    Document   : layout
    Created on : 06-jul-2019, 18:33:25
    Author     : TOBAR
--%>

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
        <li><a href="../vistas/usuario.jsp"><i class="fa fa-circle-o"></i>Usuarios</a></li> 
      </ul>
    </li>
    
     <li class="treeview active menu-open">
      <a href="#">
        <i class="fa fa-table"></i> <span>PRODUCTOS</span>
        <span class="pull-right-container">
          <i class="fa fa-angle-left pull-right"></i>
        </span>
      </a>
      <ul class="treeview-menu">
        <li><a href="../vistas/categorias.jsp"><i class="fa fa-circle-o"></i>Categorias</a></li> 
        <li><a href="../vistas/productos.jsp"><i class="fa fa-circle-o"></i>Productos</a></li> 
      
      </ul>
    </li>
    <li class="treeview active menu-open">
      <a href="#">
        <i class="fa fa-table"></i> <span>MESAS</span>
        <span class="pull-right-container">
          <i class="fa fa-angle-left pull-right"></i>
        </span>
      </a>
      <ul class="treeview-menu">
        <li><a href="../vistas/mesas.jsp"><i class="fa fa-circle-o"></i>Mesas</a></li> 
      </ul>
    </li>
     <li class="header">SERVICIO</li>
    <li class="treeview active menu-open">
      <a href="#">
        <i class="fa fa-table"></i> <span>Cuentas</span>
        <span class="pull-right-container">
          <i class="fa fa-angle-left pull-right"></i>
        </span>
      </a>
      <ul class="treeview-menu">
        <li><a href="../vistas/cuentas.jsp"><i class="fa fa-circle-o"></i>Neuva Cuenta</a></li> 
          <li><a href="../vistas/cocina.jsp"><i class="fa fa-circle-o"></i>Cocina </a></li> 
      </ul>
    </li>
    
  </ul>
</section>