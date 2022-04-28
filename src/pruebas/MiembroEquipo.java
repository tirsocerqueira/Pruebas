package pruebas;
public class MiembroEquipo extends Usuario {

    private Float[] localizacion;
    private String id;
    private String estado;

    public MiembroEquipo (String nombre, String DNI, String usuario, String contrasena, String email, Integer telefono, Float[] localizacion, String id, String estado) {
        super(nombre, DNI, usuario, contrasena, email, telefono);
        this.localizacion = localizacion;
        this.id = id;
        this.estado = estado;
    }

    public Float[] getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Float[] localizacion) {
        this.localizacion = localizacion;
    }

    public String getLocalizacionString() {
        return localizacion[0] + "," + localizacion[1];
    }

    public void setLocalizacionString(String localizacion) {
        String[] localizacionSplit = localizacion.split(",");
        this.localizacion[0] = Float.parseFloat(localizacionSplit[0]);
        this.localizacion[1] = Float.parseFloat(localizacionSplit[1]);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
