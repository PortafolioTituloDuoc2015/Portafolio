/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import sql.Conexion;
import dao.*;
import dto.ComisionesDto;
/**
 *
 * @author Pamelota
 */
public class ComisionesDao {
    
    static Connection conn=null;
    
   
        public int comisionTotalDia(String fecha){
        int total = 0;
        try{
               Connection conexion= Conexion.Enlace(conn);
               String query="select sum(total) as suma from comisiones where fecha= ? ";
               PreparedStatement buscar=conexion.prepareStatement(query);
               buscar.setString(1, fecha);
               ResultSet rs = buscar.executeQuery();
               if(rs.next()){
               total = rs.getInt("suma");
                }
               buscar.close();
               conexion.close();
            } catch(SQLException z)
            {
                System.out.println("Error SQL al sumar: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al sumar:"+e.getMessage());
            }
        return total;
    }
    
    
    public int comisionDiariaDiezPorCiento(String fecha){
        int total = 0;
        try{
               Connection conexion= Conexion.Enlace(conn);
               String query="select sum(diezPorCiento) as sumaDiaDiez from comisiones where fecha= ? ";
               PreparedStatement buscar=conexion.prepareStatement(query);
               buscar.setString(1, fecha);
               ResultSet rs = buscar.executeQuery();
               if(rs.next()){
                    total = rs.getInt("sumaDiaDiez");
               }
               buscar.close();
               conexion.close();
            } catch(SQLException z)
            {
                System.out.println("Error SQL al sumar: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al sumar:"+e.getMessage());
            }
        return total;
    }
    
    
    
    public int comisionDiariaCincoPorCiento(String fecha){
        int total = 0;
        try{
               Connection conexion= Conexion.Enlace(conn);
               String query="select sum(cincoPorCiento) as sumaDiaCinco from comisiones where fecha= ? ";
               PreparedStatement buscar=conexion.prepareStatement(query);
               buscar.setString(1, fecha);
               ResultSet rs = buscar.executeQuery();
               if(rs.next()){
                    total = rs.getInt("sumaDiaCinco");
               }
               buscar.close();
               conexion.close();
            } catch(SQLException z)
            {
                System.out.println("Error SQL al sumar: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al sumar:"+e.getMessage());
            }
        return total;
    }    
    
    
        public int comisionTotalMes(String mes, String año){
            String fechaMesAño = "/"+mes+"/"+año;
            int total = 0;
        try{
               Connection conexion= Conexion.Enlace(conn);
               String query="select sum(total) as suma from comisiones where fecha like'%"+fechaMesAño+"' ";
               PreparedStatement buscar=conexion.prepareStatement(query);
               ResultSet rs = buscar.executeQuery();
               if(rs.next()){
               total = rs.getInt("suma");
                }
               buscar.close();
               conexion.close();
            } catch(SQLException z)
            {
                System.out.println("Error SQL al sumar: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al sumar:"+e.getMessage());
            }
        return total;
    }    

        
        
        
        public int comisionMesCincoPorCiento(String mes, String año){
            String fechaMesAño = "/"+mes+"/"+año;
            int total = 0;
        try{
               Connection conexion= Conexion.Enlace(conn);
               String query="select sum(cincoPorciento) as suma from comisiones where fecha like'%"+fechaMesAño+"' ";
               PreparedStatement buscar=conexion.prepareStatement(query);
               ResultSet rs = buscar.executeQuery();
               if(rs.next()){
               total = rs.getInt("suma");
                }
               buscar.close();
               conexion.close();
            } catch(SQLException z)
            {
                System.out.println("Error SQL al sumar: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al sumar:"+e.getMessage());
            }
        return total;
    }            
        
        public int comisionMesDiezPorCiento(String mes, String año){
            String fechaMesAño = "/"+mes+"/"+año;
            int total = 0;
        try{
               Connection conexion= Conexion.Enlace(conn);
               String query="select sum(diezPorciento) as suma from comisiones where fecha like'%"+fechaMesAño+"' ";
               PreparedStatement buscar=conexion.prepareStatement(query);
               ResultSet rs = buscar.executeQuery();
               if(rs.next()){
               total = rs.getInt("suma");
                }
               buscar.close();
               conexion.close();
            } catch(SQLException z)
            {
                System.out.println("Error SQL al sumar: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al sumar:"+e.getMessage());
            }
        return total;
    }            
    

}
