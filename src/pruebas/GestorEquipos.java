package pruebas;

public class GestorEquipos {
	
	private static GestorEquipos gestor;
	
	public Equipo crearEquipo(Alerta alerta) {
		Equipo equipo = new Equipo();
		// Seleccionamos los miembros de equipos cercanos a la emergencia
		for(Usuario usr : BBDD.obtenerBBDD().getUsuarios()) {
			if(usr instanceof MiembroEquipo) {
				Float[] localizacion = ((MiembroEquipo)usr).getLocalizacion();
				Float dist = (float) Math.pow(localizacion[0]-alerta.getLocalizacion()[0],2);
				dist += (float) Math.pow(localizacion[1]-alerta.getLocalizacion()[1],2);
				if(dist<50) {
					// El usuario entra al equipo
					equipo.addMiembro((MiembroEquipo)usr);
				}
			}
		}
		return equipo;
	}
	
	public static GestorEquipos obtenerGestor() {
		if(gestor==null)
			gestor = new GestorEquipos();
		return gestor;
	}
	
}
