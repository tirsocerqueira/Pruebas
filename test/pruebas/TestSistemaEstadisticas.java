package pruebas;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSistemaEstadisticas {

    static SistemaEstadisticas sistema;

    @BeforeAll
    static void setUpBeforeClass() throws Exception{
        sistema = new SistemaEstadisticas();
    }

    @Test
    void testRegistrarAlertas() {
        Alerta alerta = new Alerta();
        String mensaje = "Se han registrado 1 alertas.";
        boolean ret = sistema.registrarAlerta(alerta);
        assertEquals(ret, true);
        assertEquals(mensaje, sistema.consultarEstadisticas());
    }

    @Test
    void testAlertaNull() {
        Alerta alertaNull = null;
        String mensaje = "Se han registrado 1 alertas.";
        boolean ret = sistema.registrarAlerta(alertaNull);
        assertEquals(ret, true);
        assertEquals(mensaje, sistema.consultarEstadisticas());
    }

}
