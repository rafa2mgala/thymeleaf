package dam.thymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dam.thymeleaf.model.Producto;
import dam.thymeleaf.repositories.ProductRepository;
import dam.thymeleaf.services.CategoryService;
import dam.thymeleaf.services.ProductService;



@Controller
@RequestMapping("/admin/categoria")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
		
	@GetMapping("/")
	public String index(Model model) {					
		model.addAttribute("categorias", categoryService.findAll());
		return "admin/list-categoria";
	}
}
