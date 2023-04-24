package dam.thymeleaf.simplelist.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	@Lob 
	private String descripcion;
	
	private float pvp;
	
	private float descuento;
	
	private String imagen;
	
	@ManyToOne
	private Category categoria;
	
	@OneToMany(mappedBy="producto", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private Set<Ranking> puntuaciones = new HashSet<Ranking>();

	public Product() {
	}

	public Product(String nombre, String descripcion, float pvp, float descuento, String imagen, Category categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pvp = pvp;
		this.descuento = descuento;
		this.imagen = imagen;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Category getCategoria() {
		return categoria;
	}


	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}

	public Set<Ranking> getPuntuaciones() {
		return puntuaciones;
	}

	public void setPuntuaciones(Set<Ranking> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}
	
	/**
	 * Métodos helper
	 */
	public void addPuntuacion(Ranking puntuacion) {
		this.puntuaciones.add(puntuacion);
		puntuacion.setProducto(this);
	}
	
	
	public double getPuntuacionMedia() {
		if (this.puntuaciones.isEmpty())
			return 0;
		else 
			return this.puntuaciones.stream()
					.mapToInt(Ranking::getPuntuacion)
					.average()
					.getAsDouble();
	}
	
	public double getNumeroTotalPuntuaciones() {
		return this.puntuaciones.size();
	}
}
