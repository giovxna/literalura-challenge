package giovxna.literalura;

import giovxna.literalura.model.Autor;
import giovxna.literalura.model.Livro;
import giovxna.literalura.service.AutorService;
import giovxna.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(Menu menu) {
		return args -> {
			menu.exibirMenu();
		};
	}
}