package dto;

/**
 *
 * @author pamela.navarro
 */
public class VehiculoDto {
    private String patente;
    private String modelo;
    private String marca;

    public VehiculoDto(String patente, String modelo, String marca) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "VehiculoDto{" + "patente=" + patente + ", modelo=" + modelo + ", marca=" + marca + '}';
    }
    
    
}
