package dto;

import java.sql.Date;

/**
 *
 * @author pamela.navarro
 */
public class BoletaEstacionamientoDto {

    private int idBoletaEstacionamiento;
    private Date fecha;
    private int total;

    public BoletaEstacionamientoDto(int idBoletaEstacionamiento, Date fecha, int total) {
        this.idBoletaEstacionamiento = idBoletaEstacionamiento;
        this.fecha = fecha;
        this.total = total;
    }

    public int getIdBoletaEstacionamiento() {
        return idBoletaEstacionamiento;
    }

    public void setIdBoletaEstacionamiento(int idBoletaEstacionamiento) {
        this.idBoletaEstacionamiento = idBoletaEstacionamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BoletaEstacionamientoDto{" + "idBoletaEstacionamiento=" + idBoletaEstacionamiento + ", fecha=" + fecha + ", total=" + total + '}';
    }
    
    
}
