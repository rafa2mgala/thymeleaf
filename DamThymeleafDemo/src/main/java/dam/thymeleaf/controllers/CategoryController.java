package dam.thymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dam.thymeleaf.model.Categoria;
import dam.thymeleaf.model.Producto;
import dam.thymeleaf.repositories.ProductRepository;
import dam.thymeleaf.services.CategoryService;
import dam.thymeleaf.services.ProductService;



@Controller
@RequestMapping("/admin/categoria")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
		
	@GetMapping("/")
	public String index(Model model) {					
		model.addAttribute("categorias", categoryService.findAll());
		return "admin/list-categoria";
	}
	
	@GetMapping("/nueva")
	public String nuevaCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "admin/form-categoria";
	}
	
	@PostMapping("/nueva/submit")
	public String submitNuevaCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
		
		categoryService.save(categoria);
		
		return "redirect:/admin/categoria/";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCategoria(@PathVariable("id") Long id, Model model) {
		
		Categoria categoria = categoryService.findById(id);
		
		if (categoria != null) {
			model.addAttribute("categoria", categoria);
			return "admin/form-categoria";
		} else {
			return "redirect:/admin/categoria/";
		}
		
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarCategoria(@PathVariable("id") Long id, Model model) {
		
		Categoria categoria = categoryService.findById(id);
		
		if (categoria != null) {
			
			if (productService.numeroProductosCategoria(categoria) == 0) {
				categoryService.delete(categoria);				
			} else {
				return "redirect:/admin/categoria/?error=true";
			}
			
		} 

		return "redirect:/admin/categoria/";
	}
}
