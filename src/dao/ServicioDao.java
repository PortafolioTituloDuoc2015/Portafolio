/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dao.*;
import java.sql.*;
import javax.swing.*;
import sql.Conexion;
import dto.*;
/**
 *
 * @author Yoyin
 */
public class ServicioDao {
    
    static Connection conn = null;
    
    public static boolean agregarServicio(ServicioDto dto){
        boolean agrego = false;
        try{
            Connection conexion = Conexion.Enlace(conn);
            String sqlinsertar="insert into servicio (nombre, descripcion,"
                    + "precio, idlavaauto) values (?,?,?,?)";
            PreparedStatement agregar=conn.prepareStatement(sqlinsertar);
            agregar.setString(1, dto.getNombreServicio());
            agregar.setString(1, dto.getDescripcion());
            agregar.setInt(1, dto.getPrecio());
            agregar.setInt(1, dto.getIdLavaauto());
            agregar.execute();
            agregar.close();
            conexion.close();
            agrego = true;
        }catch(SQLException z)
            {
                System.out.println("Error SQL al agregarServicio: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al agregarServicio:"+e.getMessage());
            }
        return agrego;
    }
    
    public static boolean validarServicio(){
        boolean existe = true;
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query="SELECT * FROM servicio where nombre = ?"
                    + "and idlavaauto = ?";
            PreparedStatement validar = conexion.prepareStatement(query);
            ResultSet rs = validar.executeQuery(query);
            while(rs.next())
            {
                existe = false;
            }
            validar.close();
            conexion.close();
        }catch(SQLException z)
        {
            System.out.println("Error SQL al validarServicio: "+z.getMessage());
        }catch(Exception e)
        {
            System.out.println("Error al validarServicio:"+e.getMessage());
        }
        return existe;
    }
    
    
}
