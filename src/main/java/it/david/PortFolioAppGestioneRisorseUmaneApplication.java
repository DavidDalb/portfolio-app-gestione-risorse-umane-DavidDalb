package it.david;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortFolioAppGestioneRisorseUmaneApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PortFolioAppGestioneRisorseUmaneApplication.class, args);

		// Porzione di codice commentata per evitare che il dataloader carichi 2 volte,
		// da decommentare se si ha intenzione di testare su MySQL
		// context.getBean(DataLoader.class).run();
	}

}
