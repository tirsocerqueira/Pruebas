package pruebas;
import java.util.Date;

public class main {

	public static void main(String[] args) {
			
		
		GestorEquipos GES = new GestorEquipos();
		GestorUsuarios GUS = new GestorUsuarios();
		GestorAlarmas GAS = new GestorAlarmas();
		SistemaEstadisticas SES = new SistemaEstadisticas();
		
		
		//Inicialización BBDD
		
		//Instancias alarma
		Protocolo prot = new Protocolo(1, "Agua", 3);
		Alarma alarm = new Alarma(1, "Incendio");
		alarm.getProtocolos().add(prot);
		
		//Instancias usuarios
		Administrador admin = new Administrador("Pepe", "78787878H", "Pepito", "1234", "Pepe@hot", 616161616, "Jefe");
		
		Float[] pos = {12.3f, 12.4f};
		MiembroUSC miemUSC = new MiembroUSC("Jose", "78787877H", "Josito", "1234", "Jose@hot", 616161618, pos);
		MiembroEquipo miemEqu = new MiembroEquipo("Maria", "78787877H", "Marita", "1234", "Maria@hot", 616161618, pos, "EQ1", "En activo");
		

		BBDD.obtenerBBDD().getAlarmas().add(alarm);
		BBDD.obtenerBBDD().getProtocolos().add(prot);
		BBDD.obtenerBBDD().getUsuarios().add(miemUSC);
		BBDD.obtenerBBDD().getUsuarios().add(miemEqu);
		BBDD.obtenerBBDD().getUsuarios().add(admin);
		
		//Prueba de alerta desde centralita
		Centralita cent = new Centralita(GAS);
		Alerta newAlerta = new Alerta("Urgente", 1, pos, "ETSE", new Date(), alarm);
		cent.notificarAlerta(newAlerta);
		
		
		// Aplicación de administrador
		AplicacionAdministrador appAdm = new AplicacionAdministrador(admin, GUS, GAS, SES);
		appAdm.cerrarAlerta(newAlerta);
		appAdm.crudAlarma(new Alarma(1,"Terremoto"), 2);
		appAdm.crudProtocolo(new Protocolo(1,"Salir del edificio",3), 2);
		appAdm.crudUsuario(miemUSC, 3); //Borrar
		appAdm.crudUsuario(miemUSC, 1); //Crear
		appAdm.crudUsuario(new MiembroUSC("Jose", "78787877H", "Jositoooo", "1234", "Jose@hot", 616161618, pos), 2); //Modificar
		
		// Aplicaicon de usuario
		AplicacionUsuario appUsr = new AplicacionUsuario(GUS);
		appUsr.iniciarSesion(miemUSC);
		appUsr.notificarAlerta(new Alerta("Importante", 2, pos, "ETSE", new Date(), alarm));
		appUsr.asistenciaDudas();
		appUsr.setDNI("721893H");
		appUsr.crudUsuario(1);
		appUsr.crudUsuario(2);
	}
}
