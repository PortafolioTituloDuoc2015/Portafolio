/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import static dao.UsuarioDao.conn;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import sql.Conexion;
import dto.*;
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
            System.out.println("Error SQL al agregar: "+z.getMessage());
        }catch(Exception e)
        {
                System.out.println("Error al agregar:"+e.getMessage());
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
            JOptionPane.showMessageDialog(null, "Sucursal creada correctamente");
        }catch(SQLException z)
        {
            System.out.println("Error SQL al agregar: "+z.getMessage());
        }catch(Exception e)
        {
                System.out.println("Error al agregar:"+e.getMessage());
        }
        return id;
        
    }
    
    /**
     * AGREGA SUCURSAL A LA BASE DE DATOS.
     * 
     * 
     * @param dto 
     */
    public static void addSucursal(SucursalDto dto){
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
                
            }catch(SQLException z){
            System.out.println("Error SQL al agregar: "+z.getMessage());
            System.out.println("Error SQL al agregar: "+z.getCause());
            System.out.println("error 1 add sucursal");
            }catch(Exception e){
                System.out.println("Error al agregar:"+e.getMessage());
                System.out.println("Error al agregar:"+e.getCause());
                System.out.println("error 2 add sucursal");
            }
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
            System.out.println("Error SQL al validar: "+z.getMessage());
        }catch(Exception e){
            System.out.println("Error al validar:"+e.getMessage());
        }
        return valido;
    }
    
    
    /**
     * ELIMINA SUCURSAL SELECCIONADA
     * 
     * ESTA MAL
     * @param sucursal 
     */
    public static void eliminarSucursal(String sucursal){
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "DELETE FROM sucursal WHERE idSucursal=?";
                PreparedStatement eliminar = conexion.prepareStatement(query);
                eliminar.setString(1, sucursal);
                eliminar.close();
                conexion.close();
            }catch(SQLException z){
            System.out.println("Error SQL al eliminar: "+z.getMessage());
            }catch(Exception e){
                System.out.println("Error al eliminar:"+e.getMessage());
            }
    }
    
    
    public static String obtenerSucursal(int id)
    {
        System.out.println("obtenerSucursal");
        String sucursal = "";
        try{
            System.out.println("try");
            System.out.println("id " + id);
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT nombresucursal FROM sucursal where idSucursal = ?";
            PreparedStatement buscarSucursal = conexion.prepareStatement(query);
            buscarSucursal.setInt(1, id);
            ResultSet rs = buscarSucursal.executeQuery();
            while (rs.next()) {
                sucursal = rs.getString("nombresucursal");
                System.out.println("sads" + sucursal);
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
    
}
