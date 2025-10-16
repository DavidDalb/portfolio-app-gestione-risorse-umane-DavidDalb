package it.david.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import it.david.model.Dipartimento;
import it.david.model.Dipendente;
import it.david.repository.DipartimentoRepository;
import it.david.repository.DipendenteRepository;
import it.david.utility.JobIdEnum;

@Service
public class DataLoader implements CommandLineRunner {

	private DipendenteRepository dipendenteRepository;
	private DipartimentoRepository dipartimentoRepository;

	// I.P By Constructor
	public DataLoader(DipendenteRepository dipendenteRepository, DipartimentoRepository dipartimentoRepository) {
		this.dipartimentoRepository = dipartimentoRepository;
		this.dipendenteRepository = dipendenteRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		// Dipartimenti
		Dipartimento dipartimento1 = new Dipartimento("IT", "Via Assunzione");
		Dipartimento dipartimento2 = new Dipartimento("Marketing", "Via del riposo");

		// Dipendenti
		Dipendente dipendente1 = new Dipendente("TestNome", "TestCognome", "TestEmail1@email.com", "339 000 0000",
				"27/09/25", JobIdEnum.SVILUPPATORE_SOFTWARE, 1500.00);

		Dipendente dipendente2 = new Dipendente("TestNome2", "TestCognome2", "TestEmail2@email.com", "339 111 0000",
				"26/09/25", JobIdEnum.COMMERCIALE, 1500.00);

		// Set Dipendenti -> Dipartimento //Set Dipartimento -> Dipendenti
		dipendente1.setDipartimento(dipartimento1);
		dipartimento1.getDipendenti().add(dipendente1);
		dipendente2.setDipartimento(dipartimento2);
		dipartimento2.getDipendenti().add(dipendente2);

		dipartimentoRepository.save(dipartimento1);
		dipartimentoRepository.save(dipartimento2);

		dipendenteRepository.save(dipendente1);
		dipendenteRepository.save(dipendente2);
	}

}
