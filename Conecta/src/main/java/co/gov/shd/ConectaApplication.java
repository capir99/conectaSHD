package co.gov.shd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import co.gov.shd.service.IFuncionarioService;

@SpringBootApplication
public class ConectaApplication implements CommandLineRunner {

	@Autowired
	private IFuncionarioService service;
	
	public static void main(String[] args) {
		SpringApplication.run(ConectaApplication.class, args);
		System.out.println("Iniciado");
		
	}

	@Override
	public void run(String... args) throws Exception {
		service.registrar("CAMILO", "PINTO", "1015392619");
		
	}

	
	
	
}
