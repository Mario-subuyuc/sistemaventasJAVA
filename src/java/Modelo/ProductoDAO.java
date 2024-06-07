package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MarioST
 */
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto buscar(int id) {
        Producto pro = new Producto();
        String sql = "SELECT * FROM producto WHERE IdProducto = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getFloat(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
            }
        }catch(Exception e){
            
        }
        return pro;
    }
    
    public Producto buscarp(int id) {
    Producto pro = new Producto();
    String sql = "SELECT * FROM producto WHERE IdProducto = ?";
    try {
        con = cn.getConexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);  // Aquí es donde debes establecer el parámetro
        rs = ps.executeQuery();
        while (rs.next()) {
            pro.setId(rs.getInt(1));
            pro.setNombre(rs.getString(2));
            pro.setPrecio(rs.getFloat(3));
            pro.setStock(rs.getInt(4));
            pro.setEstado(rs.getString(5));
        }
    } catch (Exception e) {
        // Es recomendable imprimir el error para ayudarte en la depuración
        e.printStackTrace();
    }
    return pro;
}

    public int actualizarStock (int id, int stock){
        String sql = "UPDATE producto SET Stock= ? WHERE IdProducto=?" ;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    //operaciones CRUD//
    public List listar() {
        String sql = "execute mostrarp";//procedimientos
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getFloat(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
                lista.add(pro);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    public int Agregar(Producto pro) {
        String sql = "INSERT INTO producto (Nombre, Precio, Stock, Estado) VALUES (?,?,?,?);";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setFloat(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public Producto listarId(int id) {
        Producto pro = new Producto();
        String sql = "SELECT * FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getFloat(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
            }

        } catch (Exception e) {
        }
        return pro;
    }

    public int actualizar(Producto pro) {
        String sql = "UPDATE producto SET Nombre=? , Precio=? , Stock=? , Estado=? WHERE IdProducto=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setFloat(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.setInt(5, pro.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "DELETE FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    
}
