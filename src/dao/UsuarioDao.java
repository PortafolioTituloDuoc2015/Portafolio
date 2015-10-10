
package dao;

import dto.TrabajadorDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import sql.Conexion;

/**
 *
 * @author pamela.navarro
 */
public class UsuarioDao {
    
    static Connection conn=null;
    public static boolean addUsuario(TrabajadorDto dto){
        boolean agrego = false;
        try{
            
            Connection conexion= Conexion.Enlace(conn);
            String query="INSERT INTO trabajador(rut, nombre, apellidoP, apellidoM, usuario, clave, vigente, idsucursal, idcargo) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement agregar = conexion.prepareStatement(query);
                agregar.setString(1, dto.getRut());
                agregar.setString(2,dto.getNombre());
                agregar.setString(3, dto.getApellidoP());
                agregar.setString(4, dto.getApellidoM());
                agregar.setString(5, dto.getUsuario());
                agregar.setString(6, dto.getClave());
                if(dto.isVigente())
                {
                    agregar.setInt(7, 1);
                }else if(!dto.isVigente())
                {
                    agregar.setInt(7, 1);
                }
                agregar.setInt(8, dto.getSucursal());
                agregar.setInt(9, dto.getCargo());
                agregar.execute();
                agregar.close();
                conexion.close();
                agrego = true;
            }catch(SQLException z){
            System.out.println("Error SQL al addUsuario: "+z.getMessage());
            }catch(Exception e){
                System.out.println("Error al addUsuario:"+e.getMessage());
            }
        return agrego;
    }
    
    /**
     * ESTA FUNCION ES PARA LISTAR LAS SUCURSALES.
     * LA DEJE EN ESTE DAO, PQ CREO QUE SOLO LA UTILIZAREMOS PARA ESTA VISTA, 
     * DE NO SER ASI DEBEMOS CAMBIARLA A UN NUEVO DAO.
     * 
     * 
     * @return 
     */
    public static DefaultComboBoxModel listarSucursal(){
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        try{
            Connection conexion= Conexion.Enlace(conn);
            Statement stmt = conexion.createStatement();
            String query="SELECT * FROM sucursal";
            ResultSet listar = stmt.executeQuery(query);
            modeloCombo.addElement("Seleccione");
            while(listar.next())
            {
                modeloCombo.addElement(listar.getString("nombresucursal"));
            }
            listar.close();
            conexion.close();
        }catch(SQLException z)
        {
            System.out.println("Error SQL al listarSucursal: "+z.getMessage());
        }catch(Exception e)
        {
            System.out.println("Error al listarSucursal:"+e.getMessage());
        }
        
        return modeloCombo;
    }
    /**
     * BUSCA EL ID DE UNA SUCURSAL SEGUN EL NOMBRE DE ESTA OBTENIDA DESDE UN 
     * COMBOBOX
     * 
     * @param nombre
     * @return 
     */
    public static int buscarIDSucursal(String nombre)
    {
        int id = -1;
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query = "SELECT * FROM sucursal WHERE nombresucursal = ?";
            PreparedStatement buscarId = conexion.prepareStatement(query);
            buscarId.setString(1, nombre);
            ResultSet rs = buscarId.executeQuery();
            while(rs.next())
            {
                int idsalida = rs.getInt("idsucursal");
                id = idsalida;
            }
            buscarId.close();
            conexion.close();
            
        }catch(SQLException z)
        {
            System.out.println("Error SQL al buscarIDSucursal: "+z.getMessage());
        }catch(Exception e)
        {
                System.out.println("Error al buscarIDSucursal:"+e.getMessage());
        }
        return id;
    }
    
    
    /**
     * VALIDA QUE EL TRABAJADOR NO ESTE CREADO
     * VALIDANDO POR RUT.
     * 
     * @param trabajador
     * @return 
     */
    public static boolean validarTrabajador(String trabajador){
        boolean valido = true;
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM trabajador WHERE rut=?";
            PreparedStatement validar = conexion.prepareStatement(query);
            validar.setString(1, trabajador);
            ResultSet rs = validar.executeQuery();
            if (rs.next()) {
                valido = false;
            }
            validar.close();
            conexion.close();
        }catch(SQLException z){
            System.out.println("Error SQL al validarTrabajador: "+z.getMessage());
        }catch(Exception e){
            System.out.println("Error al validarTrabajador:"+e.getMessage());
        }
        return valido;
    }
    
    
    /**
     * LISTA TODOS LOS TRABAJADORES
     * @return 
     */
    public static ArrayList<TrabajadorDto> listarTodos(){
        ArrayList<TrabajadorDto> lista = new ArrayList<TrabajadorDto>();
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "SELECT * FROM trabajador";
                PreparedStatement listar = conexion.prepareStatement(query);
                ResultSet rs = listar.executeQuery();
                while (rs.next()) {
                    TrabajadorDto dto = new TrabajadorDto();
                    dto.setRut(rs.getString("rut"));
                    dto.setNombre(rs.getString("nombre"));
                    dto.setApellidoP(rs.getString("apellidoP"));
                    dto.setApellidoM(rs.getString("apellidoM"));
                    dto.setUsuario(rs.getString("usuario"));
                    dto.setClave(rs.getString("clave"));
                    dto.setVigente(rs.getBoolean("vigente"));
                    dto.setCargo(rs.getInt("idcargo"));
                    dto.setSucursal(rs.getInt("idsucursal"));
                    dto.setCodigoTrabajador(rs.getInt("idtrabajador"));
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
    
    
    /**
     * ELIMINA UN TRABAJADOR POR RUT
     * @param trabajador 
     */
    public static boolean eliminarTrabajador(String trabajador){
        boolean elimino = false;
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "DELETE FROM trabajador WHERE rut=?";
                PreparedStatement eliminar = conexion.prepareStatement(query);
                eliminar.setString(1, trabajador);
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
    
    
    /**
     * lista los usuarios por el id de cargo.
     * @param cargo
     * @return 
     */
    public static ArrayList<TrabajadorDto> listarPorCargo(int cargo){
        ArrayList<TrabajadorDto> lista = new ArrayList<TrabajadorDto>();
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "SELECT * FROM trabajador where idCargo = ?";
                PreparedStatement listar = conexion.prepareStatement(query);
                listar.setInt(1, cargo);
                ResultSet rs = listar.executeQuery();
                while (rs.next()) {
                    TrabajadorDto dto = new TrabajadorDto();
                    dto.setRut(rs.getString("rut"));
                    dto.setNombre(rs.getString("nombre"));
                    dto.setApellidoP(rs.getString("apellidoP"));
                    dto.setApellidoM(rs.getString("apellidoM"));
                    dto.setUsuario(rs.getString("usuario"));
                    dto.setClave(rs.getString("clave"));
                    dto.setVigente(rs.getBoolean("vigente"));
                    dto.setCargo(rs.getInt("idcargo"));
                    dto.setSucursal(rs.getInt("idsucursal"));
                    dto.setCodigoTrabajador(rs.getInt("idtrabajador"));
                    lista.add(dto);
                    System.out.println("dto." + dto.toString());
                }
                listar.close();
                conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al listarPorCargo: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al listarPorCargo:"+e.getMessage());
        }
        return lista;
    }
    
    public static ArrayList<TrabajadorDto> listarPorSucursal(int sucursal){
        ArrayList<TrabajadorDto> lista = new ArrayList<TrabajadorDto>();
        try{
                Connection conexion = Conexion.Enlace(conn);
                String query = "SELECT * FROM trabajador where idsucursal = ?";
                PreparedStatement listar = conexion.prepareStatement(query);
                listar.setInt(1, sucursal);
                ResultSet rs = listar.executeQuery();
                while (rs.next()) {
                    TrabajadorDto dto = new TrabajadorDto();
                    dto.setRut(rs.getString("rut"));
                    dto.setNombre(rs.getString("nombre"));
                    dto.setApellidoP(rs.getString("apellidoP"));
                    dto.setApellidoM(rs.getString("apellidoM"));
                    dto.setUsuario(rs.getString("usuario"));
                    dto.setClave(rs.getString("clave"));
                    if(rs.getInt("vigente") == 1)
                    {
                        dto.setVigente(true);
                    }else if(rs.getInt("vigente") == 0)
                    {
                        dto.setVigente(false);
                    }
                    dto.setSucursal(rs.getInt("idsucursal"));
                    dto.setCargo(rs.getInt("idCargo"));
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
    
    /**
     * BUSCAR TRABAJADOR POR RUT
     * 
     * 
     * @param rut
     * @return 
     */
    public static dto.TrabajadorDto buscarTrabajador(String rut)
    {
        TrabajadorDto dto = new TrabajadorDto();
        try{
            Connection conexion = Conexion.Enlace(conn);
            String query = "SELECT * FROM trabajador where rut = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, rut);
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                dto.setCodigoTrabajador(rs.getInt("idtrabajador"));
                dto.setRut(rs.getString("rut"));
                dto.setNombre(rs.getString("nombre"));
                dto.setApellidoP(rs.getString("apellidop"));
                dto.setApellidoM(rs.getString("apellidom"));
                dto.setUsuario(rs.getString("usuario"));
                dto.setClave(rs.getString("clave"));
                dto.setSucursal(rs.getInt("idsucursal"));
                dto.setCargo(rs.getInt("idcargo"));
                if(rs.getInt("vigente") == 1)
                {
                    dto.setVigente(true);
                }else if(rs.getInt("vigente") == 0)
                {
                    dto.setVigente(false);
                }
            }
            buscar.close();
            conexion.close();
        }catch(SQLException s){
                System.out.println("Error SQL al buscarTrabajador: "+s.getMessage());
        }catch(Exception e){
                System.out.println("Error al buscarTrabajador:"+e.getMessage());
        }
        return dto;
    }
    
    /**
     * Modificar el usuario selecionado
     * 
     * @param dto 
     */
    public static void modificarUsuario(TrabajadorDto dto){
        try{
            Connection conexion= Conexion.Enlace(conn);
            String query="UPDATE trabajador SET nombre = ? , apellidop = ?, "
                    + "apellidom = ?, usuario = ?, clave = ?, vigente = ?,"
                    + "idsucursal = ?, idcargo = ? where idtrabajador = ?";
            PreparedStatement modificar = conexion.prepareStatement(query);
                modificar.setString(1,dto.getNombre());
                modificar.setString(2, dto.getApellidoP());
                modificar.setString(3, dto.getApellidoM());
                modificar.setString(4, dto.getUsuario());
                modificar.setString(5, dto.getClave());
                if(dto.isVigente())
                {
                    modificar.setInt(6, 1);
                }else if(!dto.isVigente())
                {
                    modificar.setInt(6, 0);
                }
                modificar.setInt(7, dto.getSucursal());
                modificar.setInt(8, dto.getCargo());
                modificar.setInt(9, dto.getCodigoTrabajador());
                modificar.execute();
                modificar.close();
                conexion.close();
            }catch(SQLException z){
            System.out.println("Error SQL al modificarUsuario: "+z.getMessage());
            }catch(Exception e){
                System.out.println("Error al modificarUsuario:"+e.getMessage());
            }
    }
    
}
