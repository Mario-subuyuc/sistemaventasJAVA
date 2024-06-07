<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Ventas</title>
        <!--generarimpresion-->
        <style>
            @media print{
                .Parte01, .btn, .accion{
                    display: none;                    
                }  
            }            
        </style>       
    </head>
    <body>
        <div class="d-flex" >
            <div class="col-lg-5 Parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <!-- Mensaje de error -->
                            <c:if test="${not empty errorMensaje}">
                                <div class="alert alert-danger">${errorMensaje}</div>
                            </c:if>
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex flex-wrap">
                                <div class="col-sm-4 d-flex mb-3">
                                    <input type="text" name="codigocliente" value="${cli.getDpi()}" class="form-control me-2" placeholder="#">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-danger ms-2">
                                </div>
                                <div class="col-sm-6 mb-3 ms-2">
                                    <input type="text" name="nombrescliente" value="${cli.getNombre()}" placeholder="Datos clientes" class="form-control" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos Productos</label>
                            </div>                        
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="#Pro">  
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-danger ms-2">Buscar</button>                          
                                </div>                                                   
                                <div class="col-sm-6">
                                    <input type="text" name="nombreproducto" value="${producto.getNombre()}" placeholder="Datos productos" class="form-control" readonly>
                                </div> 
                            </div>                            
                            <div class="form-group d-flex">
                                <div class="col-sm-3">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="Q/.0.00" readonly>  
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cant" placeholder="Cantidad" class="form-control btn-warning" >
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control" readonly>
                                </div> 
                            </div>
                            <div>
                                <div class="form-group"><br>
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-warning mt-2">Agregar Producto</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body" >
                        <div class="d-flex justify-content-end">
                            <div class="col-sm-6">
                                <label class="text-end">Numero.Serie</label>
                                <input type="text" name="NroSerie" value="${nserie}" class="form-control" disabled>
                            </div>
                        </div>
                        <br>

                        <table class="table table-hover" >
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>

                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach  var="v" items="${lista}">
                                    <tr>
                                        <td>${v.item}</td>
                                        <td name="CodigoPro">${v.idproducto}</td>
                                        <td>${v.descripcion}</td>
                                        <td>${v.precio}</td>
                                        <td>${v.cantidad}</td>
                                        <td>${v.subtotal}</td>

                                    </tr>
                                </c:forEach>
                            </tbody>

                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-warning">Generar Venta</a>
                            <a href="Controlador?menu=NuevaVenta&accion=Cancelar"type="submit" name="accion" value="Cancelar" class="btn btn-warning">Cancelar</a>
                        </div>
                        <div class="col-sm-4 ml-auto" justify-content-end>
                            <input type="text" name="txtTotal" value="Q.${totalpagar}0" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>

</html>
