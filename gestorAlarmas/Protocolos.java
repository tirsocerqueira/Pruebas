package gestorAlarmas;

public class Protocolos {
	private String id;
	private String descripcion;
	private int tipo;
	public Protocolos(String id, String descripcion, int tipo) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
