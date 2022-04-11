package gestorAlarmas;
import java.util.Date;
public interface IGestionAlarmas {
	public Alarmas notificarUsuarios(Alarmas alarm);
	public Alarmas notificarEquipos(Alarmas alarm);
	public Protocolos crudProtocolo(Protocolos prot, int accion);
	public Alarmas crudAlarma(Alarmas alrm, int accion);
	public Alarmas informarAlarma(Alarmas alrm);
	public Alarmas cerrarAlarma(Alarmas alarm, Date fecha_fin);
}
