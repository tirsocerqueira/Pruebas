package pruebas;

public class Protocolo {
	
	// Atributos
	private Integer id;
	private String descripcion;
	private Integer tipo;
	
	
	
	public Protocolo(Integer id, String desc, Integer tipo) {
		this.id = id;
		this.descripcion = desc;
		this.tipo = tipo;
	}
	
	
	// Getters y Setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
}
