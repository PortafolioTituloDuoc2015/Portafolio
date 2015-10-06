package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;
import java.sql.*;
import javax.swing.*;



public class Conexion {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    
 
    
    static String bd="XE";
    static String login="estacionamiento";
    static String password="root";
    static String url="jdbc:oracle:thin:@localhost:1521:XE";
    
    public static Connection Enlace(Connection conn)throws SQLException    {
        try {
         Class.forName("oracle.jdbc.OracleDriver");
         conn=DriverManager.getConnection(url, login, password);
        }
        catch(ClassNotFoundException e )
        {
            System.out.print("Clase no encontrada");
        }
        return conn;
    }
}
