package dam.thymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}