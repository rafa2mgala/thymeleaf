package dam.thymeleaf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.thymeleaf.model.Categoria;

public interface CategoryRepository extends JpaRepository<Categoria, Long> {
	@Query("select c from Categoria c where c.destacada = true")
	public List<Categoria> findDestacadas();
	
}
