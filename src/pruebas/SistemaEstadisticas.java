package pruebas;
import java.util.ArrayList;

public class SistemaEstadisticas {
	private final ArrayList<Alerta> alertas;
	
	public SistemaEstadisticas() {
		alertas = new ArrayList<>();
	}
	
	public boolean registrarAlerta(Alerta alerta) {
		this.alertas.add(alerta);
		return true; // Emulamos que la base de datos lo ha insertado correctamente
	}
	
	public String consultarEstadisticas() {
		return "Se han registrado "+alertas.size()+" alertas.";
	}
}
