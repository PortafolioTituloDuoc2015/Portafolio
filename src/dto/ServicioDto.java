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

    public ServicioDto(int idServicio, String nombreServicio, String descripcion, int precio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precio = precio;
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
        return "ServicioDto{" + "idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    
}
