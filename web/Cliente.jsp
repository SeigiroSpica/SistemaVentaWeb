<%-- 
    Document   : Clietes
    Created on : 26/08/2019, 00:48:58
    Author     : ale_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
         <div class="d-flex">
            <div class="card col-sm-6 col-lg-3">
                <div class="card-body">
                    <form action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" value="${test.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${test.getNombres()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${test.getDir()}" name="txtDir" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${test.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div>
                <table class="table col-sm-8 col-lg-auto">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>DIRECCION</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cl" items="${clientes}">
                        <tr>
                            <td>${cl.getId()}</td>
                            <td>${cl.getDni()}</td>
                            <td>${cl.getNombres()}</td>
                            <td>${cl.getDireccion()}</td>
                            <td>${cl.getEstado()}</td>
                            <td>
                                <a class="btn btn-warning text-white" href="Controlador?menu=Cliente&accion=Editar&id=${cl.getId()}">Editar</a>
                                <a class="btn btn-danger"href="Controlador?menu=Cliente&accion=Eliminar&id=${cl.getId()}">Eliminar</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include  file="WEB-INF/jspf/pie.jspf"%>
    </body>
</html>
