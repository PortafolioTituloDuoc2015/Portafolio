/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.PlazaDto;
import java.sql.*;
import sql.Conexion;

/**
 *
 * @author Yoyin
 */
public class PlazaDao {
    
    static Connection conn=null;
    
    public static boolean addPlaza(PlazaDto dto)
    {
        boolean agrego = false;
        
        try
        {
            Connection conexion = sql.Conexion.Enlace(conn);
            String query="INSERT INTO plaza (idsucursal, pasillo, estado, vigente) VALUES (?,upper(?),?,?)";
            PreparedStatement agregar = conexion.prepareStatement(query);
            agregar.setInt(1, dto.getIdSucursal());
            agregar.setString(2, dto.getPasillo());
            if(dto.isEstado())
                {
                    agregar.setInt(3, 1);
                }else if(!dto.isEstado())
                {
                    agregar.setInt(3, 1);
                }
            
            if(dto.isVigente())
                {
                    agregar.setInt(4, 1);
                }else if(!dto.isVigente())
                {
                    agregar.setInt(4, 1);
                }
            agregar.execute();
            agrego = true;
            agregar.close();
            conexion.close();
        } catch(SQLException z)
            {
                System.out.println("Error SQL al addPlaza: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al addPlaza:"+e.getMessage());
            }
        return agrego;
    }
    
    public static boolean updatePlaza(PlazaDto dto)
    {
        boolean actualizo = false;
        
        try
        {
            
            Connection conexion = sql.Conexion.Enlace(conn);
            String query="UPDATE plaza SET pasillo = upper(?), estado = ?"
                    + ", vigente = ? WHERE idplaza";
            PreparedStatement update = conexion.prepareStatement(query);
            update.setString(1, dto.getPasillo());
            if(dto.isEstado())
                {
                    update.setInt(2, 1);
                }else if(!dto.isEstado())
                {
                    update.setInt(2, 1);
                }
            
            if(dto.isVigente())
                {
                    update.setInt(3, 1);
                }else if(!dto.isVigente())
                {
                    update.setInt(3, 1);
                }
            update.setInt(4, dto.getIdPlaza());
            update.execute();
            update.close();
            conexion.close();
         
            actualizo = true;
        } catch(SQLException z)
            {
                System.out.println("Error SQL al updatePlaza: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al updatePlaza:"+e.getMessage());
            }
        return actualizo;
    }
    
    
    
}
