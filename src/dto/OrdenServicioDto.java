package dto;

/**
 *
 * @author pamela.navarro
 */
public class OrdenServicioDto {

    private int idOrdenServicio;
    private String observacion;

    public OrdenServicioDto(int idOrdenServicio, String observacion) {
        this.idOrdenServicio = idOrdenServicio;
        this.observacion = observacion;
    }

    public int getIdOrdenServicio() {
        return idOrdenServicio;
    }

    public void setIdOrdenServicio(int idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "OrdenServicioDto{" + "idOrdenServicio=" + idOrdenServicio + ", observacion=" + observacion + '}';
    }
    
    
}
