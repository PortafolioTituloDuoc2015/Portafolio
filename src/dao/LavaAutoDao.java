/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import javax.swing.*;
import sql.Conexion;
import dto.*;

/**
 *
 * @author Yoyin
 */
public class LavaAutoDao {
    
    static Connection conn = null;
    
    public static DefaultComboBoxModel listarLavaAuto(){
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        try{
            Connection conexion= Conexion.Enlace(conn);
            Statement listar = conexion.createStatement();
            String query="SELECT * FROM lavaauto";
            ResultSet rs = listar.executeQuery(query);
            modeloCombo.addElement("Seleccione");
            while(rs.next())
            {
                modeloCombo.addElement(rs.getString("nombre"));
            }
            listar.close();
            conexion.close();
        }catch(SQLException z)
        {
            System.out.println("Error SQL al listarLavaAuto: "+z.getMessage());
        }catch(Exception e)
        {
            System.out.println("Error al listarLavaAuto:"+e.getMessage());
        }
        
        return modeloCombo;
    }
    
    
    /**
     * Obtener el ID desde el nombre del combobox
     *
     * @param nombre
     * @return 
     */
    public static int buscarIdLavaAuto(String nombre)
    {
        int id = -1;
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query = "SELECT * FROM lavaauto WHERE nombre = ?";
            PreparedStatement buscarId = conexion.prepareStatement(query);
            buscarId.setString(1, nombre);
            ResultSet rs = buscarId.executeQuery();
            while(rs.next())
            {
                int idsalida = rs.getInt("idlavaauto");
                id = idsalida;
            }
            buscarId.close();
            conexion.close();
            
        }catch(SQLException z)
        {
            System.out.println("Error SQL al buscarIdLavaAuto: "+z.getMessage());
        }catch(Exception e)
        {
            System.out.println("Error al buscarIdLavaAuto:"+e.getMessage());
        }
        return id;
    }
    
    public static String obtenerLavaauto(int id)
    {
        String lavaAuto = "";
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT nombre FROM lavaauto where idlavaauto = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                lavaAuto = rs.getString("nombre");
            }
            buscar.close();
            conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al obtenerLavaauto: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al obtenerLavaauto:"+e.getMessage());
        }
        
        return lavaAuto;
    }
    
    public static boolean AgregarLavaAuto(LavaAutoDto dto)
    {
        boolean salida = false;
        
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query="insert into lavaauto (encargado, correo,"
                    + "idsucursal, nombre) values (?,?,?,?)";
            PreparedStatement agregar = conexion.prepareStatement(query);
            agregar.setString(1, dto.getEncargado());
            //System.out.println("1 " + dto.getNombreServicio());
            agregar.setString(2, dto.getCorreo());
            //System.out.println("2 " + dto.getDescripcion());
            agregar.setInt(3, dto.getIdSucursal());
            //System.out.println("3 " + dto.getPrecio());
            agregar.setString(4, dto.getNombre());
            //System.out.println("4 " + dto.getIdLavaauto());
            agregar.execute();
            agregar.close();
            conexion.close();
            salida = true;
        }catch(SQLException z)
            {
                System.out.println("Error SQL al agregarServicio: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al agregarServicio:"+e.getMessage());
            }
        
        return salida;
    }
    
    public static LavaAutoDto obtenerLavaautoOBJ(int id)
    {
        LavaAutoDto dto = new LavaAutoDto();
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM lavaauto where idlavaauto = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                dto.setNombre(rs.getString("nombre"));
                dto.setEncargado(rs.getString("encargado"));
                dto.setCorreo(rs.getString("correo"));
                dto.setIdSucursal(rs.getInt("idsucursal"));
                dto.setIdLavaAuto(rs.getInt("idlavaauto")); 
            }
            buscar.close();
            conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al obtenerLavaauto: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al obtenerLavaauto:"+e.getMessage());
        }
        
        return dto;
    }
    
    public static boolean updateLavaAuto(LavaAutoDto dto)
    {
        boolean resp = false;
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "UPDATE lavaauto set "
                    + "encargado = ?,"
                    + "correo = ?,"
                    + "nombre = ? "
                    + "where idlavaauto = ?";
            PreparedStatement update = conexion.prepareStatement(query);
            update.setString(1, dto.getEncargado());
            update.setString(2, dto.getCorreo());
            update.setString(3, dto.getNombre());
            update.setInt(4, dto.getIdLavaAuto());
            update.execute();
            update.close();
            conexion.close();
            resp = true;
        }catch(SQLException s){
                System.out.println("Error SQL al updateLavaAuto: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al updateLavaAuto:"+e.getMessage());
        }
        
        return resp;
    }
    
}
