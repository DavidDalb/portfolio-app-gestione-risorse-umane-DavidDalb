package it.david;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import it.david.service.DataLoader;

@SpringBootApplication
public class PortFolioAppGestioneRisorseUmaneApplication {

	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(PortFolioAppGestioneRisorseUmaneApplication.class, args);
		
		context.getBean(DataLoader.class).DataLoad();
	}

}
