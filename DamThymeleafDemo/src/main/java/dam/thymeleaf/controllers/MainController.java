package dam.thymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dam.thymeleaf.model.Producto;
import dam.thymeleaf.services.CategoryService;
import dam.thymeleaf.services.ProductService;


@Controller
public class MainController {
	private final int PRODUCTOS_ALEATORIOS=8;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categorias", categoryService.findAll());

		List<Producto> productos = productService.obtenerProductosAleatorios(PRODUCTOS_ALEATORIOS);

		model.addAttribute("productos", productos);

		return "index";
	}
}
