package dto;

import java.sql.Date;

/**
 *
 * @author pamela.navarro
 */
public class BoletaOrdenServicioDto {

    private int idBoletaOrdenServicio;
    private Date fecha;
    private int total;
    private int numeroBoleta;

    public BoletaOrdenServicioDto(int idBoletaOrdenServicio, Date fecha, int total, int numeroBoleta) {
        this.idBoletaOrdenServicio = idBoletaOrdenServicio;
        this.fecha = fecha;
        this.total = total;
        this.numeroBoleta = numeroBoleta;
    }

    public int getIdBoletaOrdenServicio() {
        return idBoletaOrdenServicio;
    }

    public void setIdBoletaOrdenServicio(int idBoletaOrdenServicio) {
        this.idBoletaOrdenServicio = idBoletaOrdenServicio;
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

    public int getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(int numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    @Override
    public String toString() {
        return "BoletaOrdenServicioDto{" + "idBoletaOrdenServicio=" + idBoletaOrdenServicio + ", fecha=" + fecha + ", total=" + total + ", numeroBoleta=" + numeroBoleta + '}';
    }
    
    
}
