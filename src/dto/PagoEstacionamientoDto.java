package dto;

import java.sql.Date;

/**
 *
 * @author pamela.navarro
 */
public class PagoEstacionamientoDto {

    private int idPagoEstacionamiento;
    private int descuento;
    private char liberado;
    private String observacionPago;
    private Date tiempo;

    public PagoEstacionamientoDto(int idPagoEstacionamiento, int descuento, char liberado, String observacionPago, Date tiempo) {
        this.idPagoEstacionamiento = idPagoEstacionamiento;
        this.descuento = descuento;
        this.liberado = liberado;
        this.observacionPago = observacionPago;
        this.tiempo = tiempo;
    }

    public int getIdPagoEstacionamiento() {
        return idPagoEstacionamiento;
    }

    public void setIdPagoEstacionamiento(int idPagoEstacionamiento) {
        this.idPagoEstacionamiento = idPagoEstacionamiento;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public char getLiberado() {
        return liberado;
    }

    public void setLiberado(char liberado) {
        this.liberado = liberado;
    }

    public String getObservacionPago() {
        return observacionPago;
    }

    public void setObservacionPago(String observacionPago) {
        this.observacionPago = observacionPago;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "PagoEstacionamientoDto{" + "idPagoEstacionamiento=" + idPagoEstacionamiento + ", descuento=" + descuento + ", liberado=" + liberado + ", observacionPago=" + observacionPago + ", tiempo=" + tiempo + '}';
    }
    
    
    
}
