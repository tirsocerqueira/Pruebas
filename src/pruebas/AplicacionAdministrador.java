package pruebas;
import java.util.Date;

public class AplicacionAdministrador {
	
	private final Administrador admin;
	private final GestorUsuariosADMIN gestorUsuarios;
	private final GestorAlarmas gestorAlarmas;
	private final SistemaEstadisticas sistemaEstadisticas;
	
	public AplicacionAdministrador(Administrador admin, GestorUsuariosADMIN gestorUsuarios, GestorAlarmas gestorAlarmas, SistemaEstadisticas sistemaEstadisticas) {
		this.admin = admin;
		this.gestorUsuarios = gestorUsuarios;
		this.gestorAlarmas = gestorAlarmas;
		this.sistemaEstadisticas = sistemaEstadisticas;
	}
	
	public String solicitarEstadisticas() {
		return this.sistemaEstadisticas.consultarEstadisticas();
	}
	
	public Alarma crudAlarma(Alarma alarma, int accion) {
		return gestorAlarmas.crudAlarma(alarma, accion);
	}
	
	public Protocolo crudProtocolo(Protocolo protocolo, int accion) {
		return gestorAlarmas.crudProtocolo(protocolo, accion);
	}
	
	public MiembroUSC crudUsuario(MiembroUSC miembro, int accion) {
		return gestorUsuarios.crudUsuario(admin, miembro, accion);
	}
	
	public Alerta cerrarAlerta(Alerta alert) {
		return this.gestorAlarmas.cerrarAlerta(alert, new Date());
	}
}
