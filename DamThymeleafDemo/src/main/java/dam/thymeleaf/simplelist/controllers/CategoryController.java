package dam.thymeleaf.simplelist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dam.thymeleaf.simplelist.services.CategoryService;

@Controller
@RequestMapping("/admin/categoria")
public class CategoryController {
	
	@Autowired
	private CategoryService categoriaService;
		
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categorias", categoriaService.findAll());
		return "admin/list-categoria";
	}
			
	

}
