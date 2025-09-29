package it.david.controller;

import org.springframework.stereotype.Controller;

import it.david.service.DipartimentoService;

@Controller
public class DipartimentoController {
	
	private DipartimentoService dipartimentoService;
	
	
	//Injection Point by Constructor
	public DipartimentoController(DipartimentoService dipartimentoService) {
		this.dipartimentoService = dipartimentoService;
		
	}
	
	

}
