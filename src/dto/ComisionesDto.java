/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author Pamelota
 */
public class ComisionesDto {
    
    private int idComisiones;
    private int idOrdenServicio;
    private Date fecha;
    private int total;
    private int diezPorCiento;
    private int cincoPorCiento;

    public ComisionesDto(int idComisiones, int idOrdenServicio, Date fecha, int total, int diezPorCiento, int cincoPorCiento) {
        this.idComisiones = idComisiones;
        this.idOrdenServicio = idOrdenServicio;
        this.fecha = fecha;
        this.total = total;
        this.diezPorCiento = diezPorCiento;
        this.cincoPorCiento = cincoPorCiento;
    }

    public ComisionesDto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdComisiones() {
        return idComisiones;
    }

    public void setIdComisiones(int idComisiones) {
        this.idComisiones = idComisiones;
    }

    public int getIdOrdenServicio() {
        return idOrdenServicio;
    }

    public void setIdOrdenServicio(int idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
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

    public int getDiezPorCiento() {
        return diezPorCiento;
    }

    public void setDiezPorCiento(int diezPorCiento) {
        this.diezPorCiento = diezPorCiento;
    }

    public int getCincoPorCiento() {
        return cincoPorCiento;
    }

    public void setCincoPorCiento(int cincoPorCiento) {
        this.cincoPorCiento = cincoPorCiento;
    }

    @Override
    public String toString() {
        return "ComisionesDto{" + "idComisiones=" + idComisiones + ", idOrdenServicio=" + idOrdenServicio + ", fecha=" + fecha + ", total=" + total + ", diezPorCiento=" + diezPorCiento + ", cincoPorCiento=" + cincoPorCiento + '}';
    }
    
    
  
}
