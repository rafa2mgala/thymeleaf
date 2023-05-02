package dam.thymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dam.thymeleaf.model.Producto;
import dam.thymeleaf.services.ProductService;



@Controller
@RequestMapping("/admin/producto")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("productos", productService.findAll());
		return "admin/list-producto";
	}	
	@GetMapping("/nuevo")
	public String nuevoProducto(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		return "admin/form-producto";
	}
	@PostMapping("/nuevo/submit")
	public String submitNuevoProducto(Producto producto, Model model) {
		productService.save(producto);
		return "redirect:admin/producto";
	}
	
	
	
	
	
	
	
}