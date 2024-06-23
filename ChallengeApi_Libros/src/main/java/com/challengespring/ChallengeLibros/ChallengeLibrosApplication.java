package com.challengespring.ChallengeLibros;


import com.challengespring.ChallengeLibros.principal.Principal;
import com.challengespring.ChallengeLibros.repository.AutorRepository;
import com.challengespring.ChallengeLibros.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.challengespring.ChallengeLibros")
@EnableJpaRepositories(basePackages = "com.challengespring.ChallengeLibros.repository")

@SpringBootApplication
public class ChallengeLibrosApplication implements CommandLineRunner {
	@Autowired
	private LibrosRepository repository;
	@Autowired
	private AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(ChallengeLibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal menu = new Principal(repository, autorRepository);
		menu.muestraElMenu();
	}
}
