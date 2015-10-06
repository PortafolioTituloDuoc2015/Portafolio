
package dto;

/**
 *
 * @author pamela.navarro
 */
public class ComunaDto {
    private int codigoComuna;
    private String nombreComunaa;

    public ComunaDto(int codigoComuna, String nombreComunaa) {
        this.codigoComuna = codigoComuna;
        this.nombreComunaa = nombreComunaa;
    }

    public int getCodigoComuna() {
        return codigoComuna;
    }

    public void setCodigoComuna(int codigoComuna) {
        this.codigoComuna = codigoComuna;
    }

    public String getNombreComunaa() {
        return nombreComunaa;
    }

    public void setNombreComunaa(String nombreComunaa) {
        this.nombreComunaa = nombreComunaa;
    }

    @Override
    public String toString() {
        return "Comuna{" + "codigoComuna=" + codigoComuna + ", nombreComunaa=" + nombreComunaa + '}';
    }
    
    
}
