package it.david.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.david.exceptions.EmptyEmailException;
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

	public Optional<Dipendente> getDipendenteById(Long id) {
		return dipendenteRepository.findById(id);
	}
	
	public Dipendente createDipendente(Dipendente dipendenteNuovo) {
		return dipendenteRepository.save(dipendenteNuovo);
	}
	
	public void removeDipendente(Long numeroId) {
		dipendenteRepository.deleteById(numeroId);
	}
	
	
	//Metodi QUERY Personalizzati (SERVICE)
	public Optional<Dipendente> getDipendenteByEmail(String email) throws EmptyEmailException {
		if(email == null || email.isEmpty()) {
			throw new EmptyEmailException("l'email non può essere vuota");
		}
		return dipendenteRepository.findByEmail(email);
	}
	
	List<Dipendente> getDipendentiBySalarioMaggioreDi(int salario) {
		return dipendenteRepository.findBySalaryGreaterThan(salario);
	}
	List<Dipendente> getDipendentiOrderByDataAssunzioneAsc() {
		return dipendenteRepository.findAllByOrderByDataAssunzioneAsc();
	}
	List<Dipendente> getDipendentiByNomeAndCognome(String nome, String cognome) {
		return dipendenteRepository.findByNomeAndCognome(nome, cognome);
	}
}
