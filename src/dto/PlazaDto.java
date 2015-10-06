
package dto;

/**
 *
 * @author pamela.navarro
 */
public class PlazaDto {
    private int IdPlaza;
    private char pasillo;
    private boolean estado;
    private boolean vigente;

    public PlazaDto(int IdPlaza, char pasillo, boolean estado, boolean vigente) {
        this.IdPlaza = IdPlaza;
        this.pasillo = pasillo;
        this.estado = estado;
        this.vigente = vigente;
    }

    public int getIdPlaza() {
        return IdPlaza;
    }

    public void setIdPlaza(int IdPlaza) {
        this.IdPlaza = IdPlaza;
    }

    public char getPasillo() {
        return pasillo;
    }

    public void setPasillo(char pasillo) {
        this.pasillo = pasillo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    @Override
    public String toString() {
        return "PlazaDto{" + "IdPlaza=" + IdPlaza + ", pasillo=" + pasillo + ", estado=" + estado + ", vigente=" + vigente + '}';
    }
    
    
}
