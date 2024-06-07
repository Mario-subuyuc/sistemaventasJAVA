package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author MarioST
 */
public class VentaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "SELECT MAX(CAST(NumeroSerie AS INT)) FROM ventas";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroserie;
    }

    public String IdVentas() {
        String idventas = "";
        String sql = "SELECT MAX(Idventas) FROM ventas";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idventas = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idventas;
    }

    public int GuardarVenta(Venta ve) {
        String sql = "INSERT INTO ventas (IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) VALUES (?,?,?,?,?,?)";
        System.out.println("estamos en guaradar venta");
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie().replaceFirst("^0+(?!$)", ""));
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getMonto());
            ps.setString(6, ve.getEstado());
            r = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public int GuardarDetalVentas(Venta venta) {
        String sql = "INSERT INTO detalle_ventas (IdVentas,IdProducto,Cantidad,PrecioVenta) VALUES (?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            r = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return r;
    }
    
    //operaciones CRUD
    
    
}
