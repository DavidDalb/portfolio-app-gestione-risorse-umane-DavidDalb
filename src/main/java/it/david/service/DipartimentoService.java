package it.david.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.david.exceptions.IdNotFoundException;
import it.david.model.Dipartimento;
import it.david.repository.DipartimentoRepository;

@Service
public class DipartimentoService {

	
	
	private DipartimentoRepository dipartimentoRepository;
	
	
	//Injection Point by Constructor
	public DipartimentoService(DipartimentoRepository dipartimentoRepository) {
		this.dipartimentoRepository = dipartimentoRepository;
	}
	
	
	
	public List<Dipartimento> getAllDipartimenti() {
		return dipartimentoRepository.findAll();
	}

	public Optional<Dipartimento> getDipartimentoById(Long id) throws IdNotFoundException {
		if(id == null) {
		  throw new IdNotFoundException("Dipartimento con id [" + id + "] non trovato.");
		}
			return dipartimentoRepository.findById(id);
	}
	
	public Dipartimento createDipartimento(Dipartimento dipartimentoNuovo) {
		return dipartimentoRepository.save(dipartimentoNuovo);
	}
	
	public void removeDipartimento(Long numeroId) {
		dipartimentoRepository.deleteById(numeroId);
	}
	
	
	//Metodi QUERY Personalizzati (SERVICE)
	public List<Dipartimento> getAllDipartimentiByNome(String nomeDaCercare) {
		return dipartimentoRepository.findAllByNome(nomeDaCercare);
	}
}
