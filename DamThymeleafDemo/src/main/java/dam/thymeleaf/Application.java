package dam.thymeleaf;

import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dam.thymeleaf.model.Producto;
import dam.thymeleaf.model.Ranking;
import dam.thymeleaf.repositories.ProductRepository;
@ComponentScan(basePackages = "dam.thymeleaf")
@SpringBootApplication 
@EntityScan("dam.thymeleaf.model")  
@EnableJpaRepositories(basePackages = {"dam.thymeleaf"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/**
	 * Este método, que se ejecutará al iniciar el proyecto nos servirá de soporte
	 * para que todos los productos de nuestro sistema tengan una puntuación
	 * (más o menos) aleatoria, simulando el que haya sido puntuado por cientos
	 * de usuarios durante varios meses.
	 * 
	 * 
	 * @param productoRepository Repositorio de productos
	 * @return Una instancia de CommandLineRunner, que será ejecutada al iniciar el proyecto
	 */
	@Bean
	public CommandLineRunner initData(ProductRepository productoRepository) {

		return args -> {

			// Rescatamos todos los productos
			List<Producto> productos = productoRepository.findAll();

			Random r = new Random();

			// Para cada uno de ellos
			for (Producto p : productos) {
				// Vamos a añadirle un número aleatorio de puntuaciones, entre 1 y 10
				for (int i = 0; i < r.nextInt(10); i++)
					// Lo valoramos con una puntuación aleatoria, entre 3 y 5.
					p.addPuntuacion(new Ranking(3 + r.nextInt(2)));
			}

			// Actualizamos los productos, almacenando así su puntuación
			productoRepository.saveAll(productos);

		};

	}
	
}
