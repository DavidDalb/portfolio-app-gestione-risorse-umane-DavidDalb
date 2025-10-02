package it.david.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.david.exceptions.EmptyEmailException;
import it.david.model.Dipendente;
import it.david.service.DipendenteService;

@Controller
@RequestMapping("/dipendenti")
public class DipendenteController {
	
	private DipendenteService dipendenteService;
	
	
	public DipendenteController(DipendenteService dipendenteService) {
		this.dipendenteService = dipendenteService;
		
	}
		@GetMapping("/")
		public String mostraHomePage(Model model) {
			List<Dipendente> listaDipendenti = dipendenteService.getAllDipendenti();
			model.addAttribute("listaDipendenti",listaDipendenti);
			return "index";
	}
		
		@GetMapping("/cercaDipendente/{id}")
		public String cercaPerId(@PathVariable Long id,Model model) {
			Optional<Dipendente> dipendenteOpt = dipendenteService.getDipendenteById(id);
			
			if(dipendenteOpt.isPresent()) {
			model.addAttribute("dipendente",dipendenteOpt.get());
			return "dipendente_info";
		
			} else {
				return "index";
			}
		}
		
		@PostMapping("/salva") 
		public String salvaDipendente(@ModelAttribute Dipendente dipendente) {
			dipendenteService.createDipendente(dipendente);
			return "redirect:/dipendenti/";
		}
		
		
		@GetMapping("/formDipendente")
	    public String formDipendente(Model model) {
	        model.addAttribute("dipendente", new Dipendente());
	        return "dipendente_form";
		}
		
		
		@GetMapping("/elimina/{id}")
		public String eliminaDipendentePerId(@PathVariable Long id) {
			 dipendenteService.removeDipendente(id);
			return "redirect:/dipendenti/";
		}
		
		
		@GetMapping("/cercaPerEmail")
		public String cercaPerEmail(@RequestParam String email,Model model) throws EmptyEmailException {
			List<Dipendente> dipendenteEmailOpt = dipendenteService.getDipendenteByEmail(email);
			
			if(dipendenteEmailOpt.isEmpty()) {
				return "index";
				
				} else {
					model.addAttribute("listaDipendenti",dipendenteEmailOpt);
					  return "index";
			}
		}
		
		
			@GetMapping("/salario")
			public String cercaPerSalarioMaggioreDi(@RequestParam double salario,Model model) {
				List<Dipendente> dipendentiPerSalariMG = dipendenteService.getDipendentiBySalarioMaggioreDi(salario);
				model.addAttribute("listaDipendenti",dipendentiPerSalariMG);
				return "index";
				
			}
			
			
			@GetMapping("/ordina_per_dataAssunzione")
			public String ordinaDipendentiPerDataAssunzioneAsc(Model model) {
				List<Dipendente> dataAssunzDipendentiAsc = dipendenteService.getDipendentiOrderByDataAssunzioneAsc();
				model.addAttribute("listaDipendenti",dataAssunzDipendentiAsc);
				return "index";
			}
		
			@GetMapping("/cerca/nome-cognome")
			public String ordinaPerNomeECognome(@RequestParam String nome, @RequestParam String cognome,Model model) {
				 List<Dipendente> dipendentiPerNomeCognome = dipendenteService.getDipendentiByNomeAndCognome(nome, cognome);
				 model.addAttribute("listaDipendenti", dipendentiPerNomeCognome);
				 return "index";
			}
		}
		

