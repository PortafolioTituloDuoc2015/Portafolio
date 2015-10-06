
package dto;

/**
 *
 * @author pamela.navarro
 */
public class SucursalDto {
   private int idSucursal;
   private String nombreSucursal;
   private String fono;
   private String direccion;
   private int comuna;
   
   public SucursalDto(){
       
   }

    public SucursalDto(int idSucursal, String nombreSucursal, String fono, String direccion, int comuna) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.fono = fono;
        this.direccion = direccion;
        this.comuna = comuna;
    }

    

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }
    
    

    @Override
    public String toString() {
        return "SucursalDto{" + "idSucursal=" + idSucursal + ", nombreSucursal=" + nombreSucursal + ", fono=" + fono + ", direccion=" + direccion + ", comuna=" + comuna + '}';
    }

    
   
   
}
