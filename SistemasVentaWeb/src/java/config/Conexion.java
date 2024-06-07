package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=bd_ventas";
    private String user = "usersql";
    private String pass = "root";

    public Connection getConexion() {
        try {
            Class.forName(driver);
            System.out.println("entre a la base de datos exitosamente");
            return (DriverManager.getConnection(url, user, pass));
            

        } catch (Exception e) {

            System.out.println("error de conexion" + e);

        }
       return null;
    }
}
