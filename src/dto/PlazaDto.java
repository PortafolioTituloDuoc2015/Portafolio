
package dto;

/**
 *
 * @author pamela.navarro
 */
public class PlazaDto {
    private int IdPlaza;
    private String pasillo;
    private boolean estado;
    private boolean vigente;
    private int idSucursal;

    public PlazaDto() {
    }

    public PlazaDto(int IdPlaza, String pasillo, boolean estado, boolean vigente, int idSucursal) {
        this.IdPlaza = IdPlaza;
        this.pasillo = pasillo;
        this.estado = estado;
        this.vigente = vigente;
        this.idSucursal = idSucursal;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdPlaza() {
        return IdPlaza;
    }

    public void setIdPlaza(int IdPlaza) {
        this.IdPlaza = IdPlaza;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
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
