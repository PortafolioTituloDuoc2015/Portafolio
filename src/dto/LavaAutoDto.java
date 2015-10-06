package dto;

/**
 *
 * @author pamela.navarro
 */
public class LavaAutoDto {

    private int idLavaAuto;
    private String correo;

    public LavaAutoDto(int idLavaAuto, String correo) {
        this.idLavaAuto = idLavaAuto;
        this.correo = correo;
    }

    public int getIdLavaAuto() {
        return idLavaAuto;
    }

    public void setIdLavaAuto(int idLavaAuto) {
        this.idLavaAuto = idLavaAuto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "LavaAutoDto{" + "idLavaAuto=" + idLavaAuto + ", correo=" + correo + '}';
    }
    
    
}
