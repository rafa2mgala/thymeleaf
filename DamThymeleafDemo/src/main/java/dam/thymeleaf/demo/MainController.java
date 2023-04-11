package dam.thymeleaf.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
		Producto producto = new Producto("Kingston KVR677D2N5/1G",
				"7 MHz DDR2 Non-ECC CL5 DIMM, 240-pin", 28.34f);
		model.addAttribute("producto",producto);
		return "index";
	}
	@GetMapping({"/opbasicas"})
	public String opbasicas(Model model) {
		model.addAttribute("htmltext", "<strong>Texto en negrita</strong>");
		model.addAttribute("today", LocalDate.now());
		model.addAttribute("nombre", "Rafa");
		Producto producto = new Producto("Kingston KVR677D2N5/1G",
				"7 MHz DDR2 Non-ECC CL5 DIMM, 240-pin", 28.34f);
		model.addAttribute("producto",producto);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(producto);
		model.addAttribute("lista", productos);

		HashMap<String,Producto> map = new HashMap<String,Producto>();
		map.put("p4", producto);
		model.addAttribute("map", map);
		return "exbasicas";
	}
	@GetMapping({"operadores"})
	public String operadores(Model model) {
		// Funciona igual que en ejemplos anteriores
		model.addAttribute("nombre", "Rafa");
		// Tomamos la fecha y hora actual del sistema
		model.addAttribute("today", LocalDate.now());
		// Obtenemos la instancia de un producto
		Producto producto = new Producto("Kingston KVR677D2N5/1G",
				"7 MHz DDR2 Non-ECC CL5 DIMM, 240-pin", 28.34f);
		model.addAttribute("producto", producto);
		// Obtenemos listado con varios productos
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(producto);
		model.addAttribute("lista", productos);
		// Obtenemos desde el servicio un HashMap con un producto
		HashMap<String,Producto> map = new HashMap<String,Producto>();
		map.put("p4", producto);
		model.addAttribute("map", map);
		// Obtenemos una instancia de un producto sin alguno de sus valores		
		producto = new Producto("Otro producto", null, 1.0f);
		model.addAttribute("producto2", producto);

		return "operadores";
	}
	/**@GetMapping({"/operadores"})
	public String operadores(Model model) {
		// Funciona igual que en ejemplos anteriores
		model.addAttribute("nombre", nombre);
		// Tomamos la fecha y hora actual del sistema
		model.addAttribute("today", new Date());
		// Obtenemos desde el servicio la instancia de un producto
		model.addAttribute("producto", service.getProducto());
		// Obtenemos desde el servicio un listado con varios productos
		model.addAttribute("lista", service.getLista());
		// Obtenemos desde el servicio un HashMap con un producto
		model.addAttribute("map", service.getMap());
		// Obtenemos del servicio la instancia de un producto sin alguno de sus valores		
		model.addAttribute("producto2", service.getProductoSinAlgunosValores());
	}**/
	@GetMapping({"/producto/{id}"})
	public String verProducto(Model model) {
		Producto producto = new Producto("Kingston KVR677D2N5/1G",
				"7 MHz DDR2 Non-ECC CL5 DIMM, 240-pin", 28.34f);
		model.addAttribute(producto);
		Map<String,Producto> productos = Collections.singletonMap("p4", 
				producto);
		productos.put("primero", producto);
		model.addAttribute(productos);
		return "producto";
	}
}
