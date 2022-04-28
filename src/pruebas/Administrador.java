package pruebas;

public class Administrador extends Usuario{

    private String puesto;

    public Administrador(String nombre, String DNI, String usuario, String contrasena, String email, Integer telefono, String puesto) {
        super(nombre, DNI, usuario, contrasena, email, telefono);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
