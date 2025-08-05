package com.example.aluno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AlunoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoApplication.class, args);
	}

}
