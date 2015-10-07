package dto;

/**
 *
 * @author pamela.navarro
 */
public class ServicioDto {

    private int idServicio;
    private String nombreServicio;
    private String descripcion;
    private int precio;
    private int idLavaauto;

    public ServicioDto(int idServicio, String nombreServicio, String descripcion, int precio, int idLavaauto) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idLavaauto = idLavaauto;
    }
    
    public ServicioDto(){}

    public int getIdLavaauto() {
        return idLavaauto;
    }

    public void setIdLavaauto(int idLavaauto) {
        this.idLavaauto = idLavaauto;
    }

    
    
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ServicioDto{" + "idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", descripcion=" + descripcion + ", precio=" + precio + ", idLavaauto=" + idLavaauto + '}';
    }

    
    
    
}
