<%-- 
    Document   : login
    Created on : 22-jun-2019, 3:21:27
    Author     : TOBAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>Primium</b>SV</a>   
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">

    <p class="login-box-msg"> </p>

    <form action="SERVLOGIN" method="post">
      <div class="form-group has-feedback">
          <select class="form-control" >
              <option values=1" > sucuarsal 1 </option>
          </select>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" name="txtUsuario" placeholder="Usuario">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" naem="txtPass" placeholder="Contraseña">
        <span class="glyphicon glyphicon-lock form-control-feedback "></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
         
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
            <button type="submit" class="btn btn-primary btn-block btn-flat" name="btnLogin">Inicio</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    
    <%
        HttpSession sesion = request.getSession();
        int nivel = 0;
        String user = "";
        if(request.getAttribute("nivel")!=null){
            nivel = (Integer)request.getAttribute("nivel");
            user = (String)request.getAttribute("nivel");
            if(nivel == 1){
                sesion.setAttribute("nivel", nivel);
                sesion.setAttribute("user", nivel);
                response.sendRedirect("Admin/admin.jsp");
            }
        }
    %>

  </div>
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>
</body>
</html>
