/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dao.*;
import static dao.UsuarioDao.conn;
import java.sql.*;
import javax.swing.*;
import sql.Conexion;
import dto.*;
import java.util.ArrayList;
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
    
    public static void modificarServicio(ServicioDto dto){
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query=("UPDATE servicio SET nombre=?, descripcion=?,"
                    + "precio=?");
            PreparedStatement modificar = conexion.prepareStatement(query);
                modificar.setString(1,dto.getNombreServicio());
                modificar.setString(2, dto.getDescripcion());
                modificar.setInt(3, dto.getPrecio());
                modificar.execute();
                modificar.close();
                conexion.close();
            }catch(SQLException z){
            System.out.println("Error SQL al modificarServicio: "+z.getMessage());
            System.out.println("Error SQL al modificarServicio: "+z.getCause());
            }catch(Exception e){
                System.out.println("Error al modificarServicio:"+e.getMessage());
                System.out.println("Error al modificarServicio:"+e.getCause());
            }
    }
    
    public static ArrayList<ServicioDto> listarTodos(){
        ArrayList<ServicioDto> lista = new ArrayList<ServicioDto>();
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "SELECT * FROM servicio";
                PreparedStatement listar = conexion.prepareStatement(query);
                ResultSet rs = listar.executeQuery();
                while (rs.next()) {
                    ServicioDto dto = new ServicioDto();
                    dto.setIdServicio(rs.getInt("idServicio"));
                    dto.setNombreServicio(rs.getString("nombreServicio"));
                    dto.setDescripcion(rs.getString("descripcion"));
                    dto.setPrecio(rs.getInt("precio"));
                    lista.add(dto);
}
                listar.close();
                conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al listarTodos: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al listarTodos:"+e.getMessage());
        }
        return lista;
    }
    
    
    public static boolean eliminarServicio(String servicio){
        boolean elimino = false;
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "DELETE FROM servicio WHERE idServicio=?";
                PreparedStatement eliminar = conexion.prepareStatement(query);
                eliminar.setString(1, servicio);
                eliminar.execute();
                eliminar.close();
                conexion.close();
                elimino = true;
            }catch(SQLException z){
            System.out.println("Error SQL al eliminarTrabajador: "+z.getMessage());
            }catch(Exception e){
                System.out.println("Error al eliminarTrabajador:"+e.getMessage());
            }
        return elimino;
    }
    
}
