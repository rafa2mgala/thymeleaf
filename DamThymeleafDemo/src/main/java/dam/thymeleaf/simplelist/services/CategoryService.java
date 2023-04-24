package dam.thymeleaf.simplelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.thymeleaf.simplelist.model.Category;
import dam.thymeleaf.simplelist.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repositorio;
	
	public List<Category> findAll() {
		return repositorio.findAll();
	}	
	
	public List<Category> findDestacadas() {
		return repositorio.findDestacadas();
	}
	
	public Category save(Category categoria) {
		return repositorio.save(categoria);
	}
	
	public Category findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Category delete(Category categoria) {
		Category result = findById(categoria.getId());
		repositorio.delete(result);
		return result;
	}
	
	

}
