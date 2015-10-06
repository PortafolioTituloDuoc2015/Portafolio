package dto;

/**
 *
 * @author pamela.navarro
 */
public class PagoServicioDto {

    private int idPagoServicios;

    public PagoServicioDto(int idPagoServicios) {
        this.idPagoServicios = idPagoServicios;
    }

    public int getIdPagoServicios() {
        return idPagoServicios;
    }

    public void setIdPagoServicios(int idPagoServicios) {
        this.idPagoServicios = idPagoServicios;
    }

    @Override
    public String toString() {
        return "PagoServicioDto{" + "idPagoServicios=" + idPagoServicios + '}';
    }
    
    
}
