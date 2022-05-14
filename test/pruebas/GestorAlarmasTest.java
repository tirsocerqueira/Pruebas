package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class GestorAlarmasTest {

	@Test
	void testInformarAlarma1() {
		Float[] posAlert = {1.00f, 1.00f};
		Alarma alarm = new Alarma(1, "Incendio");
		Alerta alert=new Alerta("Urgente", 1, posAlert, "ETSE", new Date(), alarm);
		GestorAlarmas GAS = new GestorAlarmas();
		assertEquals(alert,GAS.informarAlarma(alert),"Error al informar alarma.");
	}
	@Test
	void testInformarAlarma2() {
		Float[] posAlert = {1.00f, 1.00f};
		Float[] posUserF = {100.00f, 100.00f};
		Alarma alarm = new Alarma(1, "Incendio");
		Alerta alert=new Alerta("Urgente", 1, posAlert, "ETSE", new Date(), alarm);
		MiembroEquipo me = new MiembroEquipo("Pepe","12345678X","p12","p12","pepe@terra.net",123456789,posUserF,"1","activo");
		GestorAlarmas GAS = new GestorAlarmas();
		BBDD.obtenerBBDD().getUsuarios().add(me);
		assertEquals(alert,GAS.informarAlarma(alert),"Error al informar alarma.");
	}
	@Test
	void testInformarAlarma3() {
		Float[] posAlert = {1.00f, 1.00f};
		Float[] posUserV = {1.00f, 1.00f};
		Alarma alarm = new Alarma(1, "Incendio");
		Alerta alert=new Alerta("Urgente", 1, posAlert, "ETSE", new Date(), alarm);
		MiembroEquipo me = new MiembroEquipo("Pepe","12345678X","p12","p12","pepe@terra.net",123456789,posUserV,"1","activo");
		GestorAlarmas GAS = new GestorAlarmas();
		BBDD.obtenerBBDD().getUsuarios().add(me);
		assertEquals(alert,GAS.informarAlarma(alert),"Error al informar alarma.");
	}
	@Test
	void testInformarAlarma4() {
		Float[] posAlert = {1.00f, 1.00f};
		Alarma alarm = new Alarma(1, "Incendio");
		Alerta alert=new Alerta("Urgente", 1, posAlert, "ETSE", new Date(), alarm);
		Usuario us = new Usuario("Pepe","12345678X","p12","p12","pepe@terra.net",123456789);
		GestorAlarmas GAS = new GestorAlarmas();
		BBDD.obtenerBBDD().getUsuarios().add(us);
		assertEquals(alert,GAS.informarAlarma(alert),"Error al informar alarma.");
	}
	@Test
	void testInformarAlarma5() {
		Float[] posAlert = {1.00f, 1.00f};
		Float[] posUserF = {100.00f, 100.00f};
		Alarma alarm = new Alarma(1, "Incendio");
		Alerta alert=new Alerta("Urgente", 1, posAlert, "ETSE", new Date(), alarm);
		MiembroUSC musc = new MiembroUSC("Pepe","12345678X","p12","p12","pepe@terra.net",123456789,posUserF);
		GestorAlarmas GAS = new GestorAlarmas();
		BBDD.obtenerBBDD().getUsuarios().add(musc);
		assertEquals(alert,GAS.informarAlarma(alert),"Error al informar alarma.");
	}
	@Test
	void testInformarAlarma6() {
		Float[] posAlert = {1.00f, 1.00f};
		Float[] posUserV = {1.00f, 1.00f};
		Alarma alarm = new Alarma(1, "Incendio");
		Alerta alert=new Alerta("Urgente", 1, posAlert, "ETSE", new Date(), alarm);
		MiembroUSC musc = new MiembroUSC("Pepe","12345678X","p12","p12","pepe@terra.net",123456789,posUserV);
		GestorAlarmas GAS = new GestorAlarmas();
		BBDD.obtenerBBDD().getUsuarios().add(musc);
		assertEquals(alert,GAS.informarAlarma(alert),"Error al informar alarma.");
	}
}
