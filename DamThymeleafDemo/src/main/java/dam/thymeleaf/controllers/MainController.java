package dam.thymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dam.thymeleaf.model.Producto;
import dam.thymeleaf.repositories.ProductRepository;
import dam.thymeleaf.services.CategoryService;
import dam.thymeleaf.services.ProductService;


@Controller
public class MainController {


	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String index(@RequestParam(name="idCategoria", required=false) Long idCategoria, Model model) {
		List<Producto> productos;

		if(idCategoria==null) {
			productos = productService.obtenerProductosAleatorios(ProductRepository.PRODUCTOS_ALEATORIOS);
		}else {
			productos = productService.findAllByCategoria(idCategoria);
		}

		model.addAttribute("categorias", categoryService.findAll());

		model.addAttribute("productos", productos);

		return "index";
	}
	@GetMapping("/producto/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		Producto producto = productService.findById(id);
		if(producto!=null) {
			model.addAttribute(producto);
			return "detail";
		}
		return "redirect:/";
	}
}
