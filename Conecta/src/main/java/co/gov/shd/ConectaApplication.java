package co.gov.shd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConectaApplication{

	private static Logger LOG = LoggerFactory.getLogger(ConectaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ConectaApplication.class, args);
		LOG.info("Aplicación iniciada.......");
	}

}
