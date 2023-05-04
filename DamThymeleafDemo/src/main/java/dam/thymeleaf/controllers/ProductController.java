package dam.thymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dam.thymeleaf.model.Categoria;
import dam.thymeleaf.model.Producto;
import dam.thymeleaf.services.CategoryService;
import dam.thymeleaf.services.ProductService;
import javax.validation.Valid;


@Controller
@RequestMapping("/admin/producto")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("productos", productService.findAll());
		return "admin/list-producto";
	}	
	@GetMapping("/nuevo")
	public String nuevoProducto(Model model) {
		model.addAttribute("producto",new Producto());
		model.addAttribute("categorias",this.categoryService.findAll());
		return "admin/form-producto";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoProducto(@Valid Producto producto, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoryService.findAll());
			return "admin/form-producto";
		} else {
			productService.save(producto);
			return "redirect:/admin/producto/";

		}

	}

	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {

		Producto producto = productService.findById(id);

		if (producto != null) {
			model.addAttribute("producto", producto);
			model.addAttribute("categorias", categoryService.findAll());
			return "admin/form-producto";
		} else {
			return "redirect:/admin/producto/";
		}

	}

	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Producto producto = productService.findById(id);

		if (producto != null) {
			productService.delete(producto);
		}

		return "redirect:/admin/producto/";

	}
	
	
	
	
	
}