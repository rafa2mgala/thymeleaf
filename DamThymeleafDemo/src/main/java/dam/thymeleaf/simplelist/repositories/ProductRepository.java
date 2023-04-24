package dam.thymeleaf.simplelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.thymeleaf.simplelist.model.Category;
import dam.thymeleaf.simplelist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByCategoria(Category categoria);
	
	@Query("select p.id from Producto p")
	public List<Long> obtenerIds();
	
	@Query("select p from Producto p where p.categoria.id = ?1")
	public List<Product> findByCategoriaId(Long categoriaId);
	
	@Query("select count(p) from Producto p where p.categoria = ?1")
	public int findNumProductosByCategoria(Category categoria);
		
}
