package dam.thymeleaf.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.thymeleaf.model.Categoria;
import dam.thymeleaf.model.Producto;
import dam.thymeleaf.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Producto> findAll() {
		return productRepository.findAll();
	}
	
	public List<Producto> findAllByCategoria(Categoria categoria) {
		return productRepository.findByCategoria(categoria);
	}
	
	public List<Producto> findAllByCategoria(Long categoriaId) {
		return productRepository.findByCategoriaId(categoriaId);
	}
	
	public Producto findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Producto save(Producto producto) {
		return productRepository.save(producto);
	}
	
	public Producto delete(Producto producto) {
		Producto result = findById(producto.getId());
		productRepository.delete(result);
		return result;
	}
	
	public int numeroProductosCategoria(Categoria categoria) {
		return productRepository.findNumProductosByCategoria(categoria);
	}
	
	
	/*
	 * Este método sirve para obtener un número de productos aleatorios.
	 * Lo realizamos en Java para abstraernos mejor de la base de datos
	 * concreta que vamos a usar.
	 * Algunos SGBDR nos permitirían usar la función RANDOM, y podríamos
	 * hacer esta consulta de forma nativa.
	 */
	public List<Producto> obtenerProductosAleatorios(int numero) {
		// Obtenemos los ids de todos los productos
		List<Long> listaIds = productRepository.obtenerIds();
		// Los desordenamos 
		Collections.shuffle(listaIds);
		// Nos quedamos con los N primeros, con N = numero.
		listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());
		// Buscamos los productos con esos IDs y devolvemos la lista
		return productRepository.findAllById(listaIds);

	}
}
