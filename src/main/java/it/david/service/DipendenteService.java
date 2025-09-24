package it.david.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.david.model.Dipendente;
import it.david.repository.DipendenteRepository;

@Service
public class DipendenteService {
	
	
	
	private DipendenteRepository dipendenteRepository;
	
	
	//Injection Point by Constructor
	public DipendenteService(DipendenteRepository dipendenteRepository) {
		this.dipendenteRepository = dipendenteRepository;
	
	}
	
	public List<Dipendente> getAllDipendenti() {
		return dipendenteRepository.findAll();
	}

}
