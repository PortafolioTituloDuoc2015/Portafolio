package dto;

import java.sql.Date;

/**
 *
 * @author pamela.navarro
 */
public class TicketDto {
    private int idTicket;
    private Date ingreso;
    private Date salida;
    private char pagado;

    public TicketDto(int idTicket, Date ingreso, Date salida, char pagado) {
        this.idTicket = idTicket;
        this.ingreso = ingreso;
        this.salida = salida;
        this.pagado = pagado;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public char getPagado() {
        return pagado;
    }

    public void setPagado(char pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "TicketDto{" + "idTicket=" + idTicket + ", ingreso=" + ingreso + ", salida=" + salida + ", pagado=" + pagado + '}';
    }
    
    
}
