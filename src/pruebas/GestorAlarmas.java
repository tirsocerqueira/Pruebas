package pruebas;
import java.util.ArrayList;
import java.util.Date;

public class GestorAlarmas {
	
	
	private static GestorAlarmas gestor; 
	
	public static GestorAlarmas getGestor() {
		
		if(gestor == null) {
			gestor = new GestorAlarmas();
		}
		return gestor;
	}
	
	public Alerta informarAlarma(Alerta alerta) {
		BBDD.obtenerBBDD().getAlertas().add(alerta);
		informarUsuarios(alerta);
		informarEquipo(alerta);
		return alerta;
	}	
	
	
	private Integer informarUsuarios(Alerta alerta) {
		Integer notificados = 0;
		for(Usuario usr : BBDD.obtenerBBDD().getUsuarios()) {
			if(usr instanceof MiembroUSC) {
				Float[] localizacion = ((MiembroUSC)usr).getLocalizacion();
				Float dist = (float) Math.pow(localizacion[0]-alerta.getLocalizacion()[0],2);
				dist += (float) Math.pow(localizacion[1]-alerta.getLocalizacion()[1],2);
				if(dist<50) {
					// Informamos al usuario (no entra en las pruebas) 
					notificados++;
				}
			}
		}
		return notificados;
	}
	
	private Integer informarEquipo(Alerta alerta) {
		Integer notificados = 0;
		for(MiembroEquipo miembro: GestorEquipos.obtenerGestor().crearEquipo(alerta).getMiembros()) {
			Float[] localizacion = miembro.getLocalizacion();
			Float dist = (float) Math.pow(localizacion[0]-alerta.getLocalizacion()[0],2);
			dist += (float) Math.pow(localizacion[1]-alerta.getLocalizacion()[1],2);
			if(dist<50) {
				// Informamos al usuario (no entra en las pruebas) 
				notificados++;
			}
		}
		return notificados;
	}
	
	public Protocolo crudProtocolo(Protocolo protocolo, int accion) {
		ArrayList<Protocolo> protocolos = BBDD.obtenerBBDD().getProtocolos();
		switch(accion) {
		case 1:
			protocolos.add(protocolo);
			return protocolo;
		case 2:
			for(Protocolo prot:protocolos) {
				if(prot.getId().equals(protocolo.getId())) {
					prot.setDescripcion(protocolo.getDescripcion());
					prot.setTipo(protocolo.getTipo());
				}
			}
			return protocolo;
		case 3:
			for(int i=0; i<protocolos.size(); i++) {
				if(protocolos.get(i).getId().equals(protocolo.getId())) {
					protocolos.remove(i);
				}
			}
			return protocolo;
		default:
			for(Protocolo prot:protocolos) {
				if(prot.getId().equals(protocolo.getId())) {
					return prot;
				}
			}
			return protocolo;
		}
	}
	
	public Alarma crudAlarma(Alarma alarma, int accion) {
		ArrayList<Alarma> alarmas = BBDD.obtenerBBDD().getAlarmas();
		switch(accion) {
		case 1:
			alarmas.add(alarma);
			return alarma;
		case 2:
			for(Alarma al:alarmas) {
				if(al.getId().equals(alarma.getId())) {
					al.setDescripcion(alarma.getDescripcion());
					al.setProtocolos(alarma.getProtocolos());
				}
			}
			return alarma;
		case 3:
			for(int i=0; i<alarmas.size(); i++) {
				if(alarmas.get(i).getId().equals(alarma.getId())) {
					alarmas.remove(i);
				}
			}
			return alarma;
		default:
			for(Alarma al:alarmas) {
				if(al.getId().equals(alarma.getId())) {
					return al;
				}
			}
			return alarma;
		}
	}
	
	public Alerta cerrarAlerta(Alerta alerta, Date fecha_fin) {
		if(alerta.cerrarAlerta(fecha_fin)) {
			return alerta;
		}
		return null;
	}
}
