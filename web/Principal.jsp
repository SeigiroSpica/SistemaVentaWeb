<%-- 
    Document   : Principal
    Created on : 24/08/2019, 18:31:06
    Author     : ale_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Principal</title>
    </head>
    <body>
        <%@include  file="WEB-INF/jspf/menu.jspf"%>
        <div class="m-4" style="height: 850px;">
            <iframe name="myFrame"style=" border: none; height: 100%; width: 100%;"></iframe>
        </div>
        <%@include  file="WEB-INF/jspf/pie.jspf"%>
    </body>
</html>
