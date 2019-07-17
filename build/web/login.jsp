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
        <title>Premium | SV</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="resources/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="resources/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
        <!-- iCheck -->

    </head>

    <body class="hold-transition login-page">

        <div class="login-box">
            <div class="login-logo">
                <a href="../../index2.html"><b>Premium</b>SV</a>   
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">

                <p class="login-box-msg"> </p>

                <form action="ControlLogin">
                       
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="txtUsuario" placeholder="Usuario">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" name="txtContra" placeholder="Contraseña">
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
                    if (request.getAttribute("nivel") != null) {
                        nivel = (Integer) request.getAttribute("nivel");
                        user = (String) request.getAttribute("nivel");
                        if (nivel == 1) {
                            sesion.setAttribute("nivel", nivel);
                            sesion.setAttribute("user", nivel);
                            response.sendRedirect("Admin/admin.jsp");
                        }
                    }
                %>

            </div>
        </div>

        <script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="resources/js/login.js"></script>
       
       

        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' /* optional */
                });
            });
        </script>
        <script>
//            $(document).ready(function () {
//                var data = { pAccion: "Login", pNombre: "Sucursal" };
//                $("#selSucursal").find('option').remove().end();
//                $.ajax({
//                    type: "POST",                    //Metodo por el que se realiza la petición 
//                    url: "ControlLogin",             //url del servlet al que apunta la petición
//                    contentType: "application/json", // NOT dataType!
//                    data:JSON.stringify(data),
//                    success: function (response) {
//                        if (!response['error']) {
//                             $.each(response, function (ind) {
//                                    $("#selSucursal").append("<option value=" + response[ind].id + ">" + response[ind].nombre + "</option>");
//                              });
//                        }
//                    }
//                });
//            });
        </script>
    </body>
</html>
