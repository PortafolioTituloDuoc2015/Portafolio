/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TrabajadorDto;
import java.sql.*;
import sql.Conexion;

/**
 *
 * @author Yoyin
 */
public class LoginDao {
    
    static Connection conn=null;
    
    public static boolean login(String user, String pass)
    {
        boolean login = false;
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM trabajador WHERE usuario = ? AND clave = ?";
            PreparedStatement loginQuery = conexion.prepareStatement(query);
            loginQuery.setString(1, user);
            loginQuery.setString(2, pass);
            ResultSet rs = loginQuery.executeQuery();
            if(rs.next())
            {
                login = true;
            }else
            {
                javax.swing.JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta");
            }
            loginQuery.close();
            conexion.close();
        }catch(SQLException z)
        {
            System.out.println("Error SQL al login: "+z.getMessage());
        }catch(Exception e)
        {
            System.out.println("Error al login:"+e.getMessage());
        }
        return login;
    }
    
    public static TrabajadorDto retornarDto(String user, String pass)
    {
        TrabajadorDto dto = new TrabajadorDto();
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM trabajador WHERE usuario = ? AND clave = ?";
            PreparedStatement retornaDto = conexion.prepareStatement(query);
            retornaDto.setString(1, user);
            retornaDto.setString(2, pass);
            ResultSet rs = retornaDto.executeQuery();
            if(rs.next())
            {
                dto.setCodigoTrabajador(rs.getInt("idtrabajador"));
                dto.setRut(rs.getString("rut"));
                dto.setNombre(rs.getString("nombre"));
                dto.setApellidoP(rs.getString("apellidop"));
                dto.setApellidoM(rs.getString("apellidom"));
                dto.setUsuario(rs.getString("usuario"));
                if(rs.getInt("vigente") == 1)
                    {
                        dto.setVigente(true);
                    }else if(rs.getInt("vigente") == 0)
                    {
                        dto.setVigente(false);
                    }
                dto.setSucursal(rs.getInt("idsucursal"));
                dto.setCargo(rs.getInt("idCargo"));
            }
            retornaDto.close();
            conexion.close();
        }catch(SQLException z)
        {
            System.out.println("Error SQL al retornarDto: "+z.getMessage());
        }catch(Exception e)
        {
            System.out.println("Error al retornarDto:"+e.getMessage());
        }
        return dto;
    }
    
}
