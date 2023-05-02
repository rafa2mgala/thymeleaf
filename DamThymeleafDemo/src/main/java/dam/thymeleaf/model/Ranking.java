package dam.thymeleaf.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Ranking{
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@CreatedDate
	private LocalDate fecha;
	
	private int puntuacion;
	
	@ManyToOne
	private Producto producto;

	public Ranking() {
	}
	
	public Ranking(int puntuacion) {		
		this.puntuacion = puntuacion;
	}
	
	public Ranking(int puntuacion, Producto product) {
		this.puntuacion = puntuacion;
		this.producto = product;
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

	public Producto getProduct() {
		return producto;
	}

	public void setProducto(Producto product) {
		this.producto = product;
	}
	
}
