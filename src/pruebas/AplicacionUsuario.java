package pruebas;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class AplicacionUsuario {
	
	private MiembroUSC usr;
	private GestorUsuariosUSR GES;
	

	public AplicacionUsuario(GestorUsuariosUSR gES) {
		GES = gES;
	}

	public MiembroUSC crudUsuario(int accion) {
		
		MiembroUSC usrAux = GES.crudUsuario(usr, accion);
		
		if(usrAux == null) {
			return null;
		}

		//Actualizamos la informacion del usuario
		switch(accion){
			case 1:
				usr = usrAux;			
				break;
			case 2:
				usr = null;
				break;
			default:
			    return null;
		}
		return usrAux;
	} 

	public void setDNI(String DNI){
		this.usr.setDNI(DNI);	
	}
	public void setNombre(String nombre){
		this.usr.setNombre(nombre);
	}
	public void setTelef(Integer telefono){
		this.usr.setTelef(telefono);
	}
	public void setUsr(String usuario){
		this.usr.setUsr(usuario);
	}
	
	public MiembroUSC iniciarSesion(MiembroUSC usr) {
		this.usr = GES.iniciarSesion(usr);
		return usr;
	}
	
	public String asistenciaDudas() {
		return GES.asistenciaDudas();
	}

	public boolean notificarAlerta(Alerta alar) {
		return GES.notificarAlarma(alar);
	}
	
}
