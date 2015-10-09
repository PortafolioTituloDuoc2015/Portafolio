/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
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
            String query="insert into servicio (nombre, descripcion,"
                    + "precio, idlavaauto) values (?,?,?,?)";
            PreparedStatement agregar = conexion.prepareStatement(query);
            agregar.setString(1, dto.getNombreServicio());
            //System.out.println("1 " + dto.getNombreServicio());
            agregar.setString(2, dto.getDescripcion());
            //System.out.println("2 " + dto.getDescripcion());
            agregar.setInt(3, dto.getPrecio());
            //System.out.println("3 " + dto.getPrecio());
            agregar.setInt(4, dto.getIdLavaauto());
            //System.out.println("4 " + dto.getIdLavaauto());
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
    
    public static boolean validarServicio(String nombre, int sucursal){
        boolean existe = true;
        try{
            //System.out.println("nombre y sucursal: " + nombre + " " + sucursal);
            Connection conexion= Conexion.Enlace(conn);
            String query="SELECT * FROM servicio WHERE nombre = ? AND idlavaauto = ?";
            PreparedStatement validar = conexion.prepareStatement(query);
            validar.setString(1, nombre);
            validar.setInt(2, sucursal);
            ResultSet rs = validar.executeQuery();
            //System.out.println("se ejecuta la consulta y se guarda en rs");
            if(rs.next())
            {
            //    System.out.println("existe se cambia a verdadero!!!!");
                existe = false;
            }//else
             //   System.out.println("existe sigue falso!!!!");
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
    
    public static ServicioDto buscarServicio(String nombre, int sucursal){
        ServicioDto dto = new ServicioDto();
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query="SELECT * FROM servicio WHERE lower(nombre) = lower(?) AND idlavaauto = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, nombre);
            //System.out.println("1 " + nombre);
            buscar.setInt(2, sucursal);
            //System.out.println("2 " + sucursal);
            ResultSet rs = buscar.executeQuery();
            //System.out.println("buscar execute");
            if(rs.next())
            {
                System.out.println("entro al if");
                dto.setIdServicio(rs.getInt("idservicio"));
                System.out.println("id servicio " + rs.getInt("idservicio"));
                dto.setNombreServicio(rs.getString("nombre"));
                dto.setDescripcion(rs.getString("descripcion"));
                dto.setPrecio(rs.getInt("precio"));
                dto.setIdLavaauto(rs.getInt("idlavaauto"));
            }
            buscar.close();
            conexion.close();
        }catch(SQLException z)
        {
            System.out.println("Error SQL al bscarServicio: "+z.getMessage());
        }catch(Exception e)
        {
            System.out.println("Error al bscarServicio:"+e.getMessage());
        }
        return dto;
    }
    
    public static boolean modificarServicio(ServicioDto dto){
        boolean modifico = false;
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query=("UPDATE servicio SET nombre = ?, descripcion = ?,"
                    + "precio = ? , idlavaauto = ? where idservicio = ?");
            PreparedStatement modificar = conexion.prepareStatement(query);
                modificar.setString(1,dto.getNombreServicio());
                modificar.setString(2, dto.getDescripcion());
                modificar.setInt(3, dto.getPrecio());
                modificar.setInt(4, dto.getIdLavaauto());
                modificar.setInt(5, dto.getIdServicio());
                modificar.execute();
                modificar.close();
                conexion.close();
                modifico = true;
            }catch(SQLException z){
            System.out.println("Error SQL al modificarServicio: "+z.getMessage());
            System.out.println("Error SQL al modificarServicio: "+z.getCause());
            }catch(Exception e){
                System.out.println("Error al modificarServicio:"+e.getMessage());
                System.out.println("Error al modificarServicio:"+e.getCause());
            }
        return modifico;
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
                    dto.setNombreServicio(rs.getString("nombre"));
                    dto.setDescripcion(rs.getString("descripcion"));
                    dto.setPrecio(rs.getInt("precio"));
                    dto.setIdLavaauto(rs.getInt("idlavaauto"));
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
    
    public static ArrayList<ServicioDto> listarPorSucursal(int idSucursal){
        ArrayList<ServicioDto> lista = new ArrayList<ServicioDto>();
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "SELECT * FROM servicio where idlavaauto = ?";
                PreparedStatement listar = conexion.prepareStatement(query);
                listar.setInt(1, idSucursal);
                ResultSet rs = listar.executeQuery();
                while (rs.next()) {
                    ServicioDto dto = new ServicioDto();
                    dto.setIdServicio(rs.getInt("idServicio"));
                    dto.setNombreServicio(rs.getString("nombre"));
                    dto.setDescripcion(rs.getString("descripcion"));
                    dto.setPrecio(rs.getInt("precio"));
                    dto.setIdLavaauto(rs.getInt("idlavaauto"));
                    lista.add(dto);
                }
                listar.close();
                conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al listarPorSucursal: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al listarPorSucursal:"+e.getMessage());
        }
        return lista;
    }
    
    
    public static boolean eliminarServicio(int id){
        boolean elimino = false;
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "DELETE FROM servicio WHERE idServicio = ?";
                PreparedStatement eliminar = conexion.prepareStatement(query);
                eliminar.setInt(1, id);
                eliminar.execute();
                eliminar.close();
                conexion.close();
                elimino = true;
            }catch(SQLException z){
            System.out.println("Error SQL al eliminarServicio: "+z.getMessage());
            }catch(Exception e){
                System.out.println("Error al eliminarServicio: "+e.getMessage());
            }
        return elimino;
    }
    
}
