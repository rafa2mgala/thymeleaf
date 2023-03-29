package dam.thymeleaf.demo;

public class Producto {
	private String referencia;
	private float precio;
	
	public Producto(String referencia, float precio) {
		super();
		this.referencia = referencia;
		this.precio = precio;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}	
}
