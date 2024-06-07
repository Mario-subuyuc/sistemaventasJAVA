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
public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String Usuario, String Dpi) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM empleado WHERE Usuario=? AND Dpi=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Usuario);
            ps.setString(2, Dpi);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUsuario(rs.getString("Usuario"));
                em.setDpi(rs.getString("Dpi"));
                em.setNombre(rs.getString("Nombre"));
                em.setTelefono(rs.getString("Telefono"));
                em.setEstado(rs.getString("Estado"));
            }
            return em;
        } catch (Exception e) {
        }
        return em;
    }

    //operaciones CRUD//
    public List listar() {
        String sql = "SELECT * FROM empleado";
        List<Empleado> lista = new ArrayList<>();
        try {    
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("entre a listar sql ");
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDpi(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUsuario(rs.getString(6));
                lista.add(em);
            }
        } catch (SQLException e) {
            System.out.println("error");
        }
        return lista;
    }

    public int Agregar(Empleado em) {
        String sql = "INSERT INTO empleado (Dpi, Nombre, Telefono, Estado, Usuario) VALUES (?,?,?,?,?);";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDpi());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTelefono());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUsuario());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM empleado WHERE IdEmpleado=" + id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDpi(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUsuario(rs.getString(6));
            }

        } catch (Exception e) {
        }
        return emp;
    }

    public int actualizar(Empleado em) {
        String sql = "UPDATE empleado SET Dpi=?, Nombre=? , Telefono=? , Estado=? , Usuario=? WHERE IdEmpleado=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDpi());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTelefono());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUsuario());
            ps.setInt(6, em.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "DELETE FROM empleado WHERE IdEmpleado=" + id;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
