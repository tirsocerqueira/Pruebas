package pruebas;
import java.util.ArrayList;

public class BBDD {
	private static BBDD bbdd;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Alerta> alertas;
	private ArrayList<Alarma> alarmas;
	private ArrayList<Protocolo> protocolos;
	
	private BBDD() {
		this.usuarios = new ArrayList<>();
		this.alertas = new ArrayList<>();
		this.protocolos = new ArrayList<>();
		this.alarmas = new ArrayList<>();
	}
	
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public ArrayList<Alerta> getAlertas(){
		return alertas;
	}
	
	public ArrayList<Protocolo> getProtocolos(){
		return protocolos;
	}
	
	public ArrayList<Alarma> getAlarmas(){
		return alarmas;
	}

	public static BBDD obtenerBBDD() {
		if(bbdd==null)
			bbdd = new BBDD();
		return bbdd;
	}
	
}
