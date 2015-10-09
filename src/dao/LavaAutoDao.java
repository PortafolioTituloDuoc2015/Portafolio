/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import javax.swing.*;
import sql.Conexion;

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
            System.out.println("error 1");
        }catch(Exception e)
        {
                System.out.println("Error al buscarIdLavaAuto:"+e.getMessage());
                System.out.println("error 2");
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
    
}
