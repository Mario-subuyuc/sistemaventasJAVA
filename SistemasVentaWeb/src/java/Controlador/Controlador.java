package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//control fecha
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MarioST
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Producto pro = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    Cliente cli = new Cliente();
    ClienteDAO clidao = new ClienteDAO();
    VentaDAO vdao = new VentaDAO();
    int ide;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item, cod, cant;
    String descripcion, numeroserie;
    double precio, subtotal, totalpagar;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");


        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            List lista = edao.listar();
            switch (accion) {
                case "Listar":
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String Dpi = request.getParameter("txtDpi");
                    String Nombre = request.getParameter("txtNombre");
                    String Telefono = request.getParameter("txtTelefono");
                    String Estado = request.getParameter("txtEstado");
                    String Usuario = request.getParameter("txtUsuario");
                    em.setDpi(Dpi);
                    em.setNombre(Nombre);
                    em.setTelefono(Telefono);
                    em.setEstado(Estado);
                    em.setUsuario(Usuario);
                    edao.Agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("Id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String Dpi1 = request.getParameter("txtDpi");
                    String Nombre1 = request.getParameter("txtNombre");
                    String Telefono1 = request.getParameter("txtTelefono");
                    String Estado1 = request.getParameter("txtEstado");
                    String Usuario1 = request.getParameter("txtUsuario");
                    em.setDpi(Dpi1);
                    em.setNombre(Nombre1);
                    em.setTelefono(Telefono1);
                    em.setEstado(Estado1);
                    em.setUsuario(Usuario1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    int id = Integer.parseInt(request.getParameter("Id")); // Cambia "id" a "Id" para que coincida con el parámetro
                    edao.delete(id);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {
            List lista = clidao.listar();
            switch (accion) {
                case "Listar":
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String Dpi = request.getParameter("txtDpi");
                    String Nombre = request.getParameter("txtNombre");
                    String Direccion = request.getParameter("txtDireccion");
                    String Estado = request.getParameter("txtEstado");
                    cli.setDpi(Dpi);
                    cli.setNombre(Nombre);
                    cli.setDireccion(Direccion);
                    cli.setEstado(Estado);
                    clidao.Agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("Id"));
                    Cliente e = clidao.listarId(ide);
                    request.setAttribute("cliente", e);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar&Id=" + ide).forward(request, response);
                    break;

                case "Actualizar":
                    String Dpi1 = request.getParameter("txtDpi");
                    String Nombre1 = request.getParameter("txtNombre");
                    String Direccion1 = request.getParameter("txtDireccion");
                    String Estado1 = request.getParameter("txtEstado");
                    cli.setDpi(Dpi1);
                    cli.setNombre(Nombre1);
                    cli.setDireccion(Direccion1);
                    cli.setEstado(Estado1);
                    cli.setId(ide);
                    clidao.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Delete":
                    int id = Integer.parseInt(request.getParameter("Id")); // Cambia "id" a "Id" para que coincida con el parámetro
                    clidao.delete(id);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            List lista = pdao.listar();
            System.out.println("entramos a producto");
            System.out.println("accion que trigo es " + accion);
            switch (accion) {
                case "Listar":
                    request.setAttribute("productos", lista);
                    System.out.println("mande productos");
                    break;
                case "Agregar":
                    String Nombre = request.getParameter("txtNombre");
                    Float Precio = Float.parseFloat(request.getParameter("txtPrecio"));
                    int Stock = Integer.parseInt(request.getParameter("txtStock"));
                    String Estado = request.getParameter("txtEstado");
                    pro.setNombre(Nombre);
                    pro.setPrecio(Precio);
                    pro.setStock(Stock);
                    pro.setEstado(Estado);
                    pdao.Agregar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    System.out.println("entrea a editar producto" + request.getParameter("Id"));
                    ide = Integer.parseInt(request.getParameter("Id"));
                    Producto e = pdao.listarId(ide);
                    request.setAttribute("producto", e);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String Nombre1 = request.getParameter("txtNombre");
                    Float Precio1 = Float.parseFloat(request.getParameter("txtPrecio"));
                    int Stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String Estado1 = request.getParameter("txtEstado");
                    pro.setNombre(Nombre1);
                    pro.setPrecio(Precio1);
                    pro.setStock(Stock1);
                    pro.setEstado(Estado1);
                    pro.setId(ide);
                    pdao.actualizar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    System.out.println("entre a eliminar un producto");
                    int id = Integer.parseInt(request.getParameter("Id"));
                    System.out.println("el id que traigo es "+ id);
                    pdao.delete(id);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dpi = request.getParameter("codigocliente");
                    cli.setDpi(dpi);
                    cli = clidao.buscar(dpi);
                    request.setAttribute("cli", cli);
                    generarSerie(request);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pro = pdao.listarId(id);
                    request.setAttribute("cli", cli);
                    request.setAttribute("producto", pro);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalpagar);
                    generarSerie(request);
                    break;

                case "Agregar":
                    request.setAttribute("cli", cli);
                    totalpagar = 0.0;
                    item = item + 1;
                    cod = pro.getId();
                    descripcion = request.getParameter("nombreproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcion(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    System.out.println(lista.indexOf(v));
                    for (int i = 0; i < lista.size(); i++) {
                        totalpagar = totalpagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalpagar);
                    request.setAttribute("lista", lista);
                    generarSerie(request);
                    break;

                case "GenerarVenta":
                    //actualizar stock
                    
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdproducto();
                        ProductoDAO aO =new ProductoDAO();
                        pr = aO.buscarp(idproducto);
                        int sac = pr.getStock() - cantidad;
                        aO.actualizarStock(idproducto, sac);

                    }
                    //GuardarVenta
                    v.setIdcliente(cli.getId());
                    v.setIdempleado(8);
                    v.setNumserie(numeroserie);
                    // Obtener la fecha actual
                    LocalDate fechaActual = LocalDate.now();
                    // Formatear la fecha si es necesario (por ejemplo, "yyyy-MM-dd")
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String fechaFormateada = fechaActual.format(formatter);
                    v.setFecha(fechaFormateada);
                    v.setMonto(totalpagar);
                    v.setEstado("1");
                    System.out.println("Generar venta switch");
                    vdao.GuardarVenta(v);
                    //detalle venta
                    int idv = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        System.out.println("estoy  en generar venta NuevaVenta");
                        vdao.GuardarDetalVentas(v);
                    }
                    numeroserie = vdao.GenerarSerie();
                    lista.clear();
                    generarSerie(request);
                    break;
                default:
                    generarSerie(request);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    public void generarSerie(HttpServletRequest request) {
        numeroserie = vdao.GenerarSerie();        
        if (numeroserie == null || numeroserie.isEmpty()) {
            numeroserie = "00001";
            request.setAttribute("nserie", numeroserie);
        } else {
            int incrementar = Integer.parseInt(numeroserie);
            GenerarSerie gs = new GenerarSerie();
            numeroserie = gs.NumeroSerie(incrementar);
            request.setAttribute("nserie", numeroserie);
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
