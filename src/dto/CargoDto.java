package dto;

/**
 *
 * @author pamela.navarro
 */
public class CargoDto {

    private int idCargo;
    private String nombreCargo;

    public CargoDto(int idCargo, String nombreCargo) {
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    @Override
    public String toString() {
        return "CargoDto{" + "idCargo=" + idCargo + ", nombreCargo=" + nombreCargo + '}';
    }
    
    
}
