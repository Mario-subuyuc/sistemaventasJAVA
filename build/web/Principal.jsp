<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-danger">
            <div class="container-fluid">

                <nav class="navbar navbar-expand-lg ">
                    <div class="container-fluid">
                        <a style="margin-left: 10px; border: none; color:black" class="btn " href="#">Home</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav">
                                <li>
                                    <a style="margin-left: 10px; border: none; color: white"
                                       class="btn btn-outline-warning"  href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                                </li>
                                <li>
                                    <a style="margin-left: 10px; border: none; color: white" 
                                       class="btn btn-outline-warning" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                                </li>
                                <li>
                                    <a style="margin-left: 10px; border: none; color: white" 
                                       class="btn btn-outline-warning" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Cliente</a>
                                </li>
                                <li>
                                    <a style="margin-left: 10px; border: none; color: white" 
                                       class="btn btn-outline-warning"  href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" style="margin-right: 100px;" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ${usuarios.getUsuario()}                      
                    </button>
                    <div class="dropdown-menu text-center" >
                        <a class="dropdown-item" href="#">                            
                            <img src="img/icons/user.png" alt="120" width="120"/>
                        </a>                        
                        <a class="dropdown-item" href="#">${usuarios.getUsuario()}
                        </a>
                        <a class="dropdown-item" href="#">usuario@gmail.com
                        </a>

                        <form class="dropdown-item"  action="Validar" method="POST">
                            <button name ="accion" value ="Salir" class="btn btn-danger" type="submit" >Cerar Sesion</button>
                        </form>
                    </div>
                </div>

            </div>
        </nav>
        <div class="m-4" style="height: 620px">
            <iframe name="myFrame" style="height: 100%; width: 100%;border: 2px solid red;"></iframe>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
