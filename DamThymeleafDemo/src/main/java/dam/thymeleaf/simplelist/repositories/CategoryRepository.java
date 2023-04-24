package dam.thymeleaf.simplelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.thymeleaf.simplelist.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query("select c from Categoria c where c.destacada = true")
	public List<Category> findDestacadas();
	
}
