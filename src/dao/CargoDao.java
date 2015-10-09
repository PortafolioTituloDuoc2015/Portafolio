/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//import static dao.UsuarioDao.conn;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import sql.Conexion;


/**
 *
 * @author Yoyin
 */
public class CargoDao {
    
    static Connection conn=null;
    
    
    /**
     * agregar cargo
     */
    public static void agregarCargo(String cargo){
        try{
               conn = sql.Conexion.Enlace(conn);
               String sqlinsertar="insert into cargo (nombrecargo) values (?)";
               PreparedStatement agregar=conn.prepareStatement(sqlinsertar);
               agregar.setString(1, cargo);
               agregar.execute();
               agregar.close();
               conn.close();
            } catch(SQLException z)
            {
                System.out.println("Error SQL al agregarCargo: "+z.getMessage());
            }catch(Exception e)
            {
                System.out.println("Error al agregarCargo:"+e.getMessage());
            }
    }
    /**
     * ESTE MEODO ESTA PARA LLENAR EL COMBOBOX DE CARGOS 
     * DONDE SEA NECESARIO USARLO.
     * LO QUE HACE ESCREAR UNA LISTA DEFAULT DE COMBOBOX LA CUAL SE LE
     * ASIGNA EN LA PARTE GRAFICA.
     * @return 
     */
    public static DefaultComboBoxModel listar(){
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        try{
            Connection conexion= Conexion.Enlace(conn);
            Statement stmt = conexion.createStatement();
            String query="SELECT * FROM CARGO";
            ResultSet listar = stmt.executeQuery(query);
            modeloCombo.addElement("Seleccione");
            while(listar.next())
            {
                modeloCombo.addElement(listar.getString("NOMBRECARGO"));
            }
            listar.close();
            conexion.close();
        }catch(SQLException z)
        {
            System.out.println("Error SQL al listar cargo: "+z.getMessage());
        }catch(Exception e)
        {
                System.out.println("Error al listar cargo:"+e.getMessage());
        }
        
        return modeloCombo;
    }
    
    /**
     * EL METODO BUSCAR ID LO QUE HACE ES TOMAR EL VALOR QUE SE SACA DEL COMBOBOX
     * Y RETORNA EL ID DEL CARGO.
     * @param nombre
     * @return 
     */
    public static int buscarID(String nombre)
    {
        int id = -1;
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query = "SELECT IDCARGO FROM CARGO WHERE NOMBRECARGO = ?";
            PreparedStatement buscarId = conexion.prepareStatement(query);
            buscarId.setString(1, nombre);
            ResultSet rs = buscarId.executeQuery();
            while(rs.next())
            {
                int idsalida = rs.getInt("idcargo");
                System.out.println(idsalida);
                id = idsalida;
            }
            buscarId.close();
            conexion.close();
            
        }catch(SQLException z)
        {
            System.out.println("Error SQL al buscarID cargo: "+z.getMessage());
        }catch(Exception e)
        {
                System.out.println("Error al buscarID cargo:"+e.getMessage());
        }
        return id;
        
    }

    /**
     * VALIDA QUE EL CARGO NO ESTE CREADO YA EN EL SISTEMA
     * NO SE SI LO OCUPEMOS, YA QUE NO TENEMOS MANTENEDOR DE CARGO :)
     * 
     * CREO QUE ESTE CODIGO ESTA MAL, YA QUE ESTA PIDIENDO UN STRING Y 
     * ESTA ELIMINANDO POR ID QUE ES UN INTEGER
     * SE DEBE ARREGLAR!!!!!!!!!
     * @param cargo
     * @return 
     */
     public static boolean validarCargo(String cargo){
        boolean valido = true;
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM cargo WHERE idCargo=?";
            PreparedStatement validar = conexion.prepareStatement(query);
            validar.setString(1, cargo);
            ResultSet rs = validar.executeQuery();
            if (rs.next()) {
                valido = false;
            }
            validar.close();
            conexion.close();
        }catch(SQLException z){
            System.out.println("Error SQL al validarCargo: "+z.getMessage());
        }catch(Exception e){
            System.out.println("Error al validarCargo:"+e.getMessage());
        }
        return valido;
    }
    
    /**
     * FUNCION QUE ELIMINA EL CARGO MEDIANTE EL NOMBRE. 
     * CREO QUE ESTE CODIGO ESTA MAL, YA QUE ESTA PIDIENDO UN STRING Y 
     * ESTA ELIMINANDO POR ID QUE ES UN INTEGER
     * SE DEBE ARREGLAR!!!!!!!!!
     * @param cargo 
     */
    public static void eliminarCargo(String cargo){
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "DELETE FROM cargo WHERE idCargo=?";
                PreparedStatement eliminar = conexion.prepareStatement(query);
                eliminar.setString(1, cargo);
                eliminar.close();
                conexion.close();
            }catch(SQLException z){
            System.out.println("Error SQL al eliminarCargo: "+z.getMessage());
            }catch(Exception e){
                System.out.println("Error al elimeliminarCargoinar:"+e.getMessage());
            }
    }
    
    public static String obtenerCargo(int id)
    {
        String cargo = "";
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT nombrecargo FROM cargo where idcargo = ?";
            PreparedStatement buscarCargo = conexion.prepareStatement(query);
            buscarCargo.setInt(1, id);
            ResultSet rs = buscarCargo.executeQuery();
            while (rs.next()) {
                cargo = rs.getString("nombrecargo");
            }
            buscarCargo.close();
            conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al obtenerCargo: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al obtenerSucursal:"+e.getMessage());
        }
        
        return cargo;
    }
    
    public static ResultSet listarTodos()
    {
        ResultSet rs = null;
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM cargo";
            PreparedStatement listarCargo = conexion.prepareStatement(query);
            rs = listarCargo.executeQuery();
            listarCargo.close();
            conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al listarTodos los cargo: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al listarTodos los cargo:"+e.getMessage());
        }
        
        return rs;
    }
    
}
