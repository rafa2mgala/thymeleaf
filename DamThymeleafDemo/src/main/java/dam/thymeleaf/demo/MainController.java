package dam.thymeleaf.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping({"/","/wellcome"})
	public String wellcome(@RequestParam(name="nombre",
		required=false, defaultValue=" Mundo")String nombre,
			Model model) {
		//añado todos los atributos que yo quiera
		//que la plantilla utilice
		model.addAttribute("nombre",nombre);
		Producto producto = new Producto("C12345",2.34f);
		model.addAttribute("producto",producto);
		return "index";
	}
}
