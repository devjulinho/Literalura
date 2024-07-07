package br.com.literalura.Literalura.principal;

import br.com.literalura.Literalura.repository.AutorRepository;
import br.com.literalura.Literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.literalura.Literalura.model.livro","br.com.literalura.Literalura.model.autor"})
@EnableJpaRepositories(basePackages = "br.com.literalura.Literalura.repository")
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository repositorioLivro;
	@Autowired
	private AutorRepository repositorioAutor;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Made by: Instagram: @dev.julinho  || github: @devjulinho");
		System.out.println("<=========================================================>");
		System.out.println("Olá, seja bem vindo ao Projeto Literalura!\n");

		var menu = new Menu(repositorioLivro, repositorioAutor);
		menu.chamarMenu();
	}
}
