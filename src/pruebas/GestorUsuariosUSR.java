package pruebas;

public interface GestorUsuariosUSR {
	
	public MiembroUSC crudUsuario(MiembroUSC usr, int accion); 
	
	public MiembroUSC iniciarSesion(MiembroUSC usr);
	
	public String asistenciaDudas();

	boolean notificarAlarma(Alerta alar);
	
}
