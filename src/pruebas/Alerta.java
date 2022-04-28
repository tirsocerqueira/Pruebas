package pruebas;
import java.util.Date;

public class Alerta {

	// Atributos
	private String estado;
	private int ID;
	private Float[] localizacion;
	private String centro;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Alarma alarma;
	
	
	public Alerta(String estado, int ID, Float[] localizacion, String centro, Date fecha_inicio, Alarma alarma) {
		this.estado = estado;
		this.ID = ID;
		this.localizacion = localizacion;
		this.centro = centro;
		this.fecha_inicio = fecha_inicio;
		this.alarma = alarma;	
	}
	
	
	public Alerta() {
		localizacion = new Float[2];
	}
	
	
	
	// Getter
	public String getEstado() {
		return estado;
	}

	public int getID() {
		return ID;
	}

	public Float[] getLocalizacion() {
		return localizacion;
	}

	public String getCentro() {
		return centro;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public Alarma getAlarma() {
		return alarma;
	}
	
	// Setters

	public void setID(int iD) {
		ID = iD;
	}

	public void setLocalizacion(Float coordX, Float coordY) {
		this.localizacion[0]=coordX;
		this.localizacion[1]=coordY;
	}


	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	// Metodos
	Alerta crearAlerta(String estado, String centro, Date fecha_inicio, Alarma alarma) {
		this.estado = estado;
		this.centro = centro;
		this.fecha_inicio = fecha_inicio;
		this.alarma = alarma;
		return this;
	}

	boolean cerrarAlerta(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
		return true;
	}
	
}
