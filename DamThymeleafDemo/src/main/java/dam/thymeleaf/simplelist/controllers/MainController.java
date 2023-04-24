package dam.thymeleaf.simplelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dam.thymeleaf.simplelist.model.Product;
import dam.thymeleaf.simplelist.services.CategoryService;
import dam.thymeleaf.simplelist.services.ProductService;

@Controller
public class MainController {
	private final int PRODUCTOS_ALEATORIOS=8;
	
	@Autowired
	private CategoryService categoriaService;

	@Autowired
	private ProductService productoService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categorias", categoriaService.findAll());

		List<Product> productos = productoService.obtenerProductosAleatorios(PRODUCTOS_ALEATORIOS);

		model.addAttribute("productos", productos);

		return "index";
	}
}
