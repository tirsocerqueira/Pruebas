package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class GestorEquiposTest {

	@Test
	void testCrearEquipo() {
		GestorEquipos GES = new GestorEquipos();
		Equipo e =new Equipo();
		Float[] pos = {12.3f, 12.4f};
		Alarma alarm = new Alarma(1, "Incendio");
		Alerta alert=new Alerta("Urgente", 1, pos, "ETSE", new Date(), alarm);
		MiembroUSC miemUSC = new MiembroUSC("Jose", "78787877H", "Josito", "1234", "Jose@hot", 616161618, pos);
		MiembroEquipo miemEqu = new MiembroEquipo("Maria", "78787877H", "Maria", "1234", "Maria@hot", 616161618, pos, "EQ1", "En activo");
		BBDD.obtenerBBDD().getUsuarios().add(miemEqu);
		BBDD.obtenerBBDD().getUsuarios().add(miemUSC);
		e.addMiembro(miemEqu);
		for(MiembroEquipo me:GES.crearEquipo(alert).getMiembros()) {
			assertEquals(e.getMiembro(me.getId()),me,"Error al crear equipo");
		}
	}

}
