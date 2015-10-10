/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import sql.Conexion;
import dto.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Yoyin
 */
public class SucursalDao {
    
    static Connection conn=null;
    
    /**
     * LISTAR COMUNAS LO QUE HACE ES GENERAR UN MODELO PARA EL COMBOBOX 
     * QUE SE DEBE LLENAR EN LA PARTE DE VISTA.
     * 
     * RETORNA UN MODELO DEFAULT DE COMBOBOX
     * @return 
     */
    public DefaultComboBoxModel listarComunas(){
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        try{
            Connection conexion= Conexion.Enlace(conn);
            Statement stmt = conexion.createStatement();
            String query="SELECT nombrecomuna FROM comuna";
            ResultSet listar = stmt.executeQuery(query);
            modeloCombo.addElement("Seleccione");
            while(listar.next())
            {
                modeloCombo.addElement(listar.getString("nombrecomuna"));
            }
            listar.close();
            conexion.close();
        }catch(SQLException z)
        {
            System.out.println("Error SQL al listarComunas: "+z.getMessage());
        }catch(Exception e)
        {
                System.out.println("Error al listarComunas:"+e.getMessage());
        }
        
        return modeloCombo;
    }
    
    /**
     * TOMA EL NOMBRE DE LA COMUNA DESDE EL COMBOBOX Y OBTIENE SU ID. 
     * PARA ENVIARLO A LA BD.
     * 
     * @param comuna
     * @return 
     */
    public static int buscarIDComuna(String comuna)
    {
        int id = -1;
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query = "SELECT idcomuna FROM comuna WHERE nombrecomuna = ?";
            PreparedStatement buscarId = conexion.prepareStatement(query);
            buscarId.setString(1, comuna);
            ResultSet rs = buscarId.executeQuery();
            while(rs.next())
            {
                int idsalida = rs.getInt("idcomuna");
                id = idsalida;
            }
            buscarId.close();
            conexion.close();
        }catch(SQLException z)
        {
            System.out.println("Error SQL al buscarIDComuna: "+z.getMessage());
        }catch(Exception e)
        {
                System.out.println("Error al buscarIDComuna:"+e.getMessage());
        }
        return id;
        
    }
    
    /**
     * AGREGA SUCURSAL A LA BASE DE DATOS.
     * 
     * 
     * @param dto 
     */
    public static boolean addSucursal(SucursalDto dto){
        boolean agrego = false;
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query="INSERT INTO sucursal(nombresucursal, "
                    + "fono, idcomuna, direccion) VALUES(?,?,?,?)";
            PreparedStatement agregar = conexion.prepareStatement(query);
                agregar.setString(1, dto.getNombreSucursal());
                agregar.setString(2, dto.getFono());
                agregar.setInt(3, dto.getComuna());
                agregar.setString(4, dto.getDireccion());
                agregar.execute();
                agregar.close();
                conexion.close();
                agrego = true;
            }catch(SQLException z){
            System.out.println("Error SQL al agregar: "+z.getMessage());
            System.out.println("Error SQL al agregar: "+z.getCause());
            }catch(Exception e){
                System.out.println("Error al agregar:"+e.getMessage());
                System.out.println("Error al agregar:"+e.getCause());
            }
        return agrego;
    }
    
    public static boolean modificarSucursal(SucursalDto dto){
        boolean modifico = false;
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query = "UPDATE sucursal SET nombresucursal = ?, fono = ?,"
                    + "idcomuna = ?, direccion = ? where idsucursal = ?";
            PreparedStatement modificar = conexion.prepareStatement(query);
                modificar.setString(1, dto.getNombreSucursal());
                modificar.setString(2, dto.getFono());
                modificar.setInt(3, dto.getComuna());
                modificar.setString(4, dto.getDireccion());
                modificar.setInt(5, dto.getIdSucursal());
                modificar.execute();
                modificar.close();
                conexion.close();
                modifico = true;
            }catch(SQLException z){
            System.out.println("Error SQL al modificarSucursal: "+z.getMessage());
            }catch(Exception e){
                System.out.println("Error al modificarSucursal:"+e.getMessage());
            }
        return modifico;
    }
    
    
    
    /**
     * VALIDA QUE LA SUCURSAL NO ESTE CREADA EN EL SISTEMA.
     * 
     * @param sucursal
     * @return 
     */
    public static boolean validarSucursal(String sucursal){
        boolean valido = true;
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM sucursal WHERE NOMBRESUCURSAL=?";
            PreparedStatement validar = conexion.prepareStatement(query);
            validar.setString(1, sucursal);
            ResultSet rs = validar.executeQuery();
            if (rs.next()) {
                valido = false;
            }
            validar.close();
            conexion.close();
        }catch(SQLException z){
            System.out.println("Error SQL al validarSucursal: "+z.getMessage());
        }catch(Exception e){
            System.out.println("Error al validarSucursal:"+e.getMessage());
        }
        return valido;
    }
    
    
    /**
     * ELIMINA SUCURSAL SELECCIONADA
     * 
     * ESTA MAL
     * @param sucursal 
     */
    public static boolean eliminarSucursal(int sucursal){
        boolean elimino = false;
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "DELETE FROM sucursal WHERE idSucursal=?";
                PreparedStatement eliminar = conexion.prepareStatement(query);
                eliminar.setInt(1, sucursal);
                eliminar.close();
                conexion.close();
                elimino = true;
            }catch(SQLException z){
            System.out.println("Error SQL al eliminarSucursal: "+z.getMessage());
            }catch(Exception e){
                System.out.println("Error al eliminarSucursal:"+e.getMessage());
            }
        return elimino;
    }
    
    
    public static String obtenerSucursal(int id)
    {
        System.out.println("obtenerSucursal");
        String sucursal = "";
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT nombresucursal FROM sucursal where idSucursal = ?";
            PreparedStatement buscarSucursal = conexion.prepareStatement(query);
            buscarSucursal.setInt(1, id);
            ResultSet rs = buscarSucursal.executeQuery();
            while (rs.next()) {
                sucursal = rs.getString("nombresucursal");
            }
            buscarSucursal.close();
            conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al obtenerSucursal: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al obtenerSucursal:"+e.getMessage());
        }
        
        return sucursal;
    }
    public static String obtenerComuna(int id)
    {
        String comuna = "";
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM comuna where idcomuna = ?";
            PreparedStatement buscarSucursal = conexion.prepareStatement(query);
            buscarSucursal.setInt(1, id);
            ResultSet rs = buscarSucursal.executeQuery();
            while (rs.next()) {
                comuna = rs.getString("nombrecomuna");
            }
            buscarSucursal.close();
            conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al obtenerComuna: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al obtenerComuna:"+e.getMessage());
        }
        return comuna;
    }
    
    public static SucursalDto buscarSucursal(String nombre)
    {
        System.out.println("obtenerSucursal");
        SucursalDto dto = new SucursalDto();
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM sucursal WHERE lower(nombresucursal) = lower(?)";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, nombre);
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                dto.setIdSucursal(rs.getInt("idsucursal"));
                dto.setNombreSucursal(rs.getString("nombresucursal"));
                dto.setFono(rs.getString("fono"));
                dto.setComuna(rs.getInt("idComuna"));
                dto.setDireccion(rs.getString("direccion"));
            }
            buscar.close();
            conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al buscarSucursal: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al buscarSucursal:"+e.getMessage());
        }
        return dto;
    }
    
    public static ArrayList<SucursalDto> listarTodos(){
        ArrayList<SucursalDto> lista = new ArrayList<SucursalDto>();
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "SELECT * FROM sucursal";
                PreparedStatement listar = conexion.prepareStatement(query);
                ResultSet rs = listar.executeQuery();
                while (rs.next()) {
                    SucursalDto dto = new SucursalDto();
                    dto.setIdSucursal(rs.getInt("idsucursal"));
                    dto.setNombreSucursal(rs.getString("nombresucursal"));
                    dto.setFono(rs.getString("fono"));
                    dto.setComuna(rs.getInt("idcomuna"));
                    dto.setDireccion(rs.getString("direccion"));
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
    
    public static ArrayList<SucursalDto> listarPorComuna(int idComuna){
        ArrayList<SucursalDto> lista = new ArrayList<SucursalDto>();
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "SELECT * FROM sucursal WHERE idcomuna = ?";
                PreparedStatement listar = conexion.prepareStatement(query);
                listar.setInt(1, idComuna);
                ResultSet rs = listar.executeQuery();
                while (rs.next()) {
                    SucursalDto dto = new SucursalDto();
                    dto.setIdSucursal(rs.getInt("idsucursal"));
                    dto.setNombreSucursal(rs.getString("nombresucursal"));
                    dto.setFono(rs.getString("fono"));
                    dto.setComuna(rs.getInt("idcomuna"));
                    dto.setDireccion(rs.getString("direccion"));
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
    
}
