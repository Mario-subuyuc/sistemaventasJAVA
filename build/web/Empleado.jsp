
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Empleado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-5">
                <div class="card-body">
                    <form  action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group " >
                            <label>Dpi</label>
                            <input type="text"  value="${empleado.getDpi()}" name="txtDpi" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>nombres</label>
                            <input type="text"  value="${empleado.getNombre()}" name="txtNombre" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text"  value="${empleado.getTelefono()}" name="txtTelefono" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text"  value="${empleado.getUsuario()}" name="txtUsuario" class="form-control" >
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
                    <th>Telefono</th>
                    <th>Estado</th>
                    <th>Usuario</th>
                    </thead>
                    <tbody>
                    <c:forEach  var="em" items="${empleados}">
                            <tr scope="row" >
                                <td>${em.getId()}</td>
                                <td>${em.getDpi()}</td>
                                <td>${em.getNombre()}</td>
                                <td>${em.getTelefono()}</td>
                                <td>${em.getEstado()}</td>
                                <td>${em.getUsuario()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&Id=${em.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&Id=${em.getId()}">Eliminar</a>
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