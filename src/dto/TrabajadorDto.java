package dto;

/**
 *
 * @author pamela.navarro
 */
public class TrabajadorDto {

    private int codigoTrabajador;
    private String rut;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String usuario;
    private String clave;
    private boolean vigente;
    private int cargo;
    private int sucursal;
    
    public TrabajadorDto()
    {
        
    }

    public TrabajadorDto(int codigoTrabajador, String rut, String nombre, String apellidoP, String apellidoM, String usuario, String clave, boolean vigente, int cargo) {
        this.codigoTrabajador = codigoTrabajador;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.usuario = usuario;
        this.clave = clave;
        this.vigente = vigente;
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    

    public int getCodigoTrabajador() {
        return codigoTrabajador;
    }

    public void setCodigoTrabajador(int codigoTrabajador) {
        this.codigoTrabajador = codigoTrabajador;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }
    
    

    @Override
    public String toString() {
        return "TrabajadorDto{" + "codigoTrabajador=" + codigoTrabajador + ", rut=" + rut + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", usuario=" + usuario + ", clave=" + clave + ", vigente=" + vigente + ", cargo=" + cargo + '}';
    }

    
    
    
}
