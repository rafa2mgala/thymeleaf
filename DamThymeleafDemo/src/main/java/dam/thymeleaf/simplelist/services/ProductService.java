package dam.thymeleaf.simplelist.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.thymeleaf.simplelist.model.Category;
import dam.thymeleaf.simplelist.model.Product;
import dam.thymeleaf.simplelist.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repositorio;
	
	public List<Product> findAll() {
		return repositorio.findAll();
	}
	
	public List<Product> findAllByCategoria(Category categoria) {
		return repositorio.findByCategoria(categoria);
	}
	
	public List<Product> findAllByCategoria(Long categoriaId) {
		return repositorio.findByCategoriaId(categoriaId);
	}
	
	public Product findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Product save(Product producto) {
		return repositorio.save(producto);
	}
	
	public Product delete(Product producto) {
		Product result = findById(producto.getId());
		repositorio.delete(result);
		return result;
	}
	
	public int numeroProductosCategoria(Category categoria) {
		return repositorio.findNumProductosByCategoria(categoria);
	}
	
	
	/*
	 * Este método sirve para obtener un número de productos aleatorios.
	 * Lo realizamos en Java para abstraernos mejor de la base de datos
	 * concreta que vamos a usar.
	 * Algunos SGBDR nos permitirían usar la función RANDOM, y podríamos
	 * hacer esta consulta de forma nativa.
	 */
	public List<Product> obtenerProductosAleatorios(int numero) {
		// Obtenemos los ids de todos los productos
		List<Long> listaIds = repositorio.obtenerIds();
		// Los desordenamos 
		Collections.shuffle(listaIds);
		// Nos quedamos con los N primeros, con N = numero.
		listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());
		// Buscamos los productos con esos IDs y devolvemos la lista
		return repositorio.findAllById(listaIds);

	}
}
