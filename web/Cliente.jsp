
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cliente</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-5">
                <div class="card-body">
                    <form  action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group " >
                            <label>Dpi</label>
                            <input type="text"  value="${cliente.getDpi()}" name="txtDpi" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text"  value="${cliente.getNombre()}" name="txtNombre" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text"  value="${cliente.getDireccion()}" name="txtDireccion" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control" >
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-warning">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-warning">
                    </form>  
                </div>         
            </div>
            <div class="col-sm-7">
                <table class="table table-hover" >
                    <thead>
                    <th>Id</th>
                    <th>DPI</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Estado</th>
                    </thead>
                    <tbody>
                        <c:forEach  var="cli" items="${clientes}">
                            <tr scope="row" >
                                <td>${cli.getId()}</td>
                                <td>${cli.getDpi()}</td>
                                <td>${cli.getNombre()}</td>
                                <td>${cli.getDireccion()}</td>
                                <td>${cli.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&Id=${cli.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&Id=${cli.getId()}">Eliminar</a>
                                </td>
                            </tr> 

                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>