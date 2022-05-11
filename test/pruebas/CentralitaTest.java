package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CentralitaTest {

	@Test
	void testNotificarAlerta1() {
		GestorAlarmas GAS= new GestorAlarmas();
		Centralita cen = new Centralita(GAS);
		Float[] pos = {12.3f, 12.4f};
		Alarma alarm = new Alarma(1, "Incendio");
		Alerta alert=new Alerta("Urgente", 1, pos, "ETSE", new Date(), alarm);
		assertEquals(true,cen.notificarAlerta(alert),"Error al notificar una alerta.");
	}
	@Test
	void testNotificarAlerta2() {
		GestorAlarmas GAS= new GestorAlarmas();
		Centralita cen = new Centralita(GAS);
		assertEquals(true,cen.notificarAlerta(null),"Error al notificar una alerta nula.");
	}
	

}
