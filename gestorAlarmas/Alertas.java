package gestorAlarmas;

import java.util.Date;

public class Alertas {
	private String estado;
	private int id;
	private float localizacion;
	private String centro;
	private Date fecha_inicio;
	private Date fecha_fin;
	public Alertas(String estado, int id, float localizacion, String centro, Date fecha_inicio, Date fecha_fin) {
		super();
		this.estado = estado;
		this.id = id;
		this.localizacion = localizacion;
		this.centro = centro;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	
	public Alertas(String estado, float localizacion, String centro,Date fecha_inicio) {
		super();
		this.id=0;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = new Date();
		this.estado = estado;
		this.localizacion = localizacion;
		this.centro = centro;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(float localizacion) {
		this.localizacion = localizacion;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public Alertas crearAlerta(String estado, float localizacion, String centro, Date fecha_inicio) {
		Alertas a= new Alertas(estado,localizacion,centro,fecha_inicio);
		return a;
	}
	public Alertas cerrarAlerta(Date fecha_fin) {
		this.setFecha_fin(fecha_fin);
		return this;
	}
	
}
