package pruebas;

public class Centralita {

	// Atributos
	GestorAlarmas gestionAlarmas;
	
	public Centralita(GestorAlarmas gestionAlarmas) {
		this.gestionAlarmas = gestionAlarmas;
	}
	
	public boolean notificarAlerta(Alerta alert) {
		this.gestionAlarmas.informarAlarma(alert);
		return true;
	}
}
