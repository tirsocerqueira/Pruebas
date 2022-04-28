package pruebas;

import java.util.HashMap;
import java.util.*;

public class GestorUsuarios implements GestorUsuariosADMIN, GestorUsuariosUSR {

	
	// Construcctor
	public GestorUsuarios() {
	}
	
	
	//MÉTODOS GESTOR USUARIOS (ADMIN)
	// CRUD 
	/*
	 * valores de accion: - 1: se crea el usuario - 2: se modifican los datos
	 * poniendo los datos que están en el objeto usr - 3: se elimina un usuario - 4:
	 * se obtienen todos los datos del usuario
	 * 
	 * En caso de haberse realizado la accion se devuelve el usuario, si no, se
	 * devuelve null
	 */

	@Override
	public MiembroUSC crudUsuario(Administrador admin, MiembroUSC usr, int accion) {
		
		
		// Se comprueba que el correo del administrador y la contraseña son correctos
		Administrador admin1 = (Administrador)getUsuarioPorCorreo(admin.getCorreo());
		if (admin1 == null || !(admin1.getCorreo().equals(admin.getCorreo()) && admin1.getPass().equals(admin.getPass()))) {
			return null;
		}

		// Comprobamos si el usuario existe
		MiembroUSC usuario = (MiembroUSC)getUsuarioPorCorreo(usr.getCorreo());
		if(usuario == null && accion!= 1) {
			return null;
		}
		
		// En caso de que se pueda realizar la accion
		switch (accion) {

		// Añadir miembroUSC a la BBDD
		case 1:
		
			BBDD.obtenerBBDD().getUsuarios().add(usr);
			break;

		// Modificar los datos de un usuario
		case 2:
		usuario.setDNI(usr.getDNI());
		usuario.setNombre(usr.getNombre());
		usuario.setTelef(usr.getTelef());
		usuario.setUsr(usr.getUsr());
			break;

		// Eliminamos ese usuario
		case 3:
			return (MiembroUSC) borrarUsuarioPorCorreo(usr.getCorreo());

		// Obtener todos los datos del usuario
		case 4:
			break;

		// Si el cógido es incorrecto
		default:
			usuario = null;
			break;
		}
		return usuario;
	}
	
	
	//MÉTODOS GESTOR USUARIOS (USR)

	// CRUD
	/*
	 * valores de accion: - 1: se modifican los datos poniendo los datos que están
	 * en el objeto usr - 2: se elimina un usuario En caso de haberse realizado la
	 * accion se devuelve el usuario, si no, se devuelve null
	 */
	public MiembroUSC crudUsuario(MiembroUSC usr, int accion) {

		// Si el usuario no existe
		MiembroUSC usuario = (MiembroUSC)getUsuarioPorCorreo(usr.getCorreo());
		if (usuario == null) {
			return null;
		}

		// Si las credenciales no son corectas
		if (!(usuario.getCorreo().equals(usr.getCorreo()) && usuario.getPass().equals(usr.getPass()))) {
			return null;
		}

		switch (accion) {
		// Modificar los datos de un usuario
		case 1:
			usuario.setDNI(usr.getDNI());
			usuario.setNombre(usr.getNombre());
			usuario.setTelef(usr.getTelef());
			usuario.setUsr(usr.getUsr());
			break;

		// Eliminamos ese usuario
		case 2:
			return (MiembroUSC) borrarUsuarioPorCorreo(usr.getCorreo());

		default:
			usuario = null;
			break;
		}
		return usuario;
	}

	// INICIAR SESION
	//*Si las credenciales son correctas se devuelve, si no son correctas se devuelve null**//
	public MiembroUSC iniciarSesion(MiembroUSC usr) {

		// Si el usuario no existe
		MiembroUSC usuario = (MiembroUSC)getUsuarioPorCorreo(usr.getCorreo());
		

		if (usuario!= null && usuario.getCorreo().equals(usr.getCorreo()) && 
				usuario.getPass().equals(usr.getPass())) {
			return usuario;
		}
		return null;
	}
	
	//ASISTENACIA AYUDA
	public String asistenciaDudas() {
		return "Esta es una aplicación buenísima\n";
	}
	
	//NOTIFICAR ALARMA
	public boolean notificarAlarma(Alerta alar) {
		// Suponemos que le mostramos por interfaz la notificacion
		if(GestorAlarmas.getGestor().informarAlarma(alar)!=null) {
			return true;
		}
		
		return false;
	}
	
	
	//Funciones privadas
	
	//Buscar un usuario en la base de datos
	private Usuario getUsuarioPorCorreo(String correo) {
		Usuario usr = null;
		
		for(Usuario aux : BBDD.obtenerBBDD().getUsuarios()) {
			
			if(aux.getCorreo().equals(correo)) {
				usr = aux;
			}
		}
		return usr;	
	}
	
	//Borrar usuario de la base de datos
	private Usuario borrarUsuarioPorCorreo(String correo) {
		
		
        Iterator itr = BBDD.obtenerBBDD().getUsuarios().iterator();
        
        while (itr.hasNext()) {
 
            Usuario x = (Usuario)itr.next();
            if (x instanceof MiembroUSC && x.getCorreo().equals(correo)) {
            	itr.remove();
            	return x;
            }
             
        }
		
		return null;
	}
	
	
	
	
	
	

}
