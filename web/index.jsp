<%-- 
    Document   : index
    Created on : 16-jul-2019, 5:31:04
    Author     : TOBAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <% 
       HttpSession ses =request.getSession();
       if(ses.getAttribute("s1")!= null){
       }else{
           response.sendRedirect("login.jsp");
       }
    
    %>
      <% 
//        if(request.getParameter("buttonName") != null) {
//              out.print("Hola ");
//        }
    %>

    <FORM NAME="form1" METHOD="POST">
        <INPUT TYPE="HIDDEN" NAME="buttonName">
        <INPUT TYPE="BUTTON" VALUE="Button1" ONCLICK="button1()">
    </FORM>

    <SCRIPT LANGUAGE="JavaScript">
        
        function button1()
        {
            document.form1.buttonName.value = "yes";
            //form1.submit();
        } 
        
    </SCRIPT>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
