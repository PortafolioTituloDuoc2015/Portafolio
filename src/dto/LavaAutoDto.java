package dto;

/**
 *
 * @author pamela.navarro
 */
public class LavaAutoDto {

    private int idLavaAuto;
    private String nombre;
    private String correo;
    private int idSucursal;

    public LavaAutoDto(int idLavaAuto, String nombre, String correo, int idSucursal) {
        this.idLavaAuto = idLavaAuto;
        this.nombre = nombre;
        this.correo = correo;
        this.idSucursal = idSucursal;
    }

    public LavaAutoDto() {
    }

    public int getIdLavaAuto() {
        return idLavaAuto;
    }

    public void setIdLavaAuto(int idLavaAuto) {
        this.idLavaAuto = idLavaAuto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public String toString() {
        return "LavaAutoDto{" + "idLavaAuto=" + idLavaAuto + ", nombre=" + nombre + ", correo=" + correo + ", idSucursal=" + idSucursal + '}';
    }

    
    
    
}
