
package dto;
/**
 *
 * @author pamela.navarro
 */
public class ProvinciaDto {
    private int codigo;
    private String nombreProvincia;

    public ProvinciaDto(int codigo, String nombreProvincia) {
        this.codigo = codigo;
        this.nombreProvincia = nombreProvincia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    @Override
    public String toString() {
        return "ProvinciaDto{" + "codigo=" + codigo + ", nombreProvincia=" + nombreProvincia +'}';
    }
    
    
}
