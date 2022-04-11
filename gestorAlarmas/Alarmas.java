package gestorAlarmas;

public class Alarmas {
	private String id;
	private int tipo;
	public Alarmas(String id, int tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
