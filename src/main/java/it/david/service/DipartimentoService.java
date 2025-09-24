package it.david.service;

import org.springframework.stereotype.Service;

import it.david.repository.DipartimentoRepository;

@Service
public class DipartimentoService {

	
	
	private DipartimentoRepository dipartimentoRepository;
	
	
	//Injection Point by Constructor
	public DipartimentoService(DipartimentoRepository dipartimentoRepository) {
		this.dipartimentoRepository = dipartimentoRepository;
	}
}
