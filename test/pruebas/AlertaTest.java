package codigo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AlertaTest {

	static GestorAlarmas gestor; 
	
	@BeforeAll
	static void setUpBeforeClass(){
		gestor = new GestorAlarmas();
	}

	@Test
	void testCrearAlerta() {
		
		Float[] posicion = {1f, 1f};
		Alarma alarma = new Alarma(1, "Tormenta");
		Alerta alerta= new Alerta("Activa", 1, posicion, "ETSE", new Date(), alarma);
		Alerta alerta2 = alerta.crearAlerta("Activa", "ETSE", new Date(),alarma);
		
		assertEquals(alerta,alerta2,"La alerta creada es diferente");
		
	}
	
	@Test
	void testRecibirAlerta() {
	
	Float[] posicion = {0f, 0f};
	Float[] posicionfallo1 = {50.1f, 50.1f};
	Float[] posicionfallo2 = {-50.1f, -50.1f};
	Float[] posicionnull = {9999f, 9999f};
	Alarma alarma = new Alarma(1, "Tormenta");
	Alerta alerta= new Alerta("Activa", 1, posicion, "ETSE", new Date(), alarma);
	int usuariosNotificados=0;
	
	MiembroUSC userA = new MiembroUSC("Jose", "1", "jose", "contrasena", "jose@gmail.com", 666666666, posicion);
	MiembroUSC userB = new MiembroUSC("Manuel", "2", "manuel", "contrasena", "manuel@gmail.com", 666666666, posicion);
	MiembroUSC userC = new MiembroUSC("Pedro", "3", "pedro", "contrasena", "pedro@gmail.com", 666666666,posicionfallo1 );
	MiembroUSC userD = new MiembroUSC("Carlos", "4", "carlos", "contrasena", "carlos@gmail.com", 666666666, posicionfallo2);
	MiembroUSC userE = new MiembroUSC("Ramon", "5", "ramon", "contrasena", "ramon@gmail.com", 666666666, posicionnull);

	BBDD.obtenerBBDD().getUsuarios().add(userA);
	BBDD.obtenerBBDD().getUsuarios().add(userB);	
	BBDD.obtenerBBDD().getUsuarios().add(userC);
	BBDD.obtenerBBDD().getUsuarios().add(userD);
	BBDD.obtenerBBDD().getUsuarios().add(userE);
	
	usuariosNotificados=gestor.usuariosNotificados(alerta);
	assertEquals(usuariosNotificados,2,"No se detectó el número de usuarios correcto");
	
	
	}

}
