package dam.thymeleaf.simplelist.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Ranking {
	@Id
	@GeneratedValue
	private Long id;
	
	@CreatedDate
	private LocalDate fecha;
	
	private int puntuacion;
	
	@ManyToOne
	private Product producto;

	public Ranking() {
	}
	
	public Ranking(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public Ranking(int puntuacion, Product producto) {
		this.puntuacion = puntuacion;
		this.producto = producto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}
	
}
