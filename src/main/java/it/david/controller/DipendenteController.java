package it.david.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
			model.addAttribute("ListaDipendenti",listaDipendenti);
			return "index";
	}
		
		@GetMapping("/cercaPerId/{id}")
		public String cercaPerId(@RequestParam Long id,Model model) {
			Optional<Dipendente> dipendenteOpt = dipendenteService.getDipendenteById(id);
			
			if(dipendenteOpt.isPresent()) {
			model.addAttribute("dipendente",dipendenteOpt.get());
			return "dipendente_info";
		
			} else {
				return "redirect:/dipendenti/";
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
		public String eliminaDipendentePerId(@RequestParam Long id) {
			 dipendenteService.removeDipendente(id);
			return "redirect:/dipendenti/";
			
		}
		
		
		@GetMapping("/cercaPerEmail")
		public String cercaPerEmail(@RequestParam String email,Model model) throws EmptyEmailException {
			List<Dipendente> dipendenteEmailOpt = dipendenteService.getDipendenteByEmail(email);
			
			if(dipendenteEmailOpt.isEmpty()) {
				return "index";
				
				} else {
					model.addAttribute("ListaDipendenti",dipendenteEmailOpt);
					  return "index";
			}
		}
		
		
			@GetMapping("/salario")
			public String cercaPerSalarioMaggioreDi(@RequestParam double salario,Model model) {
				List<Dipendente> dipendentiPerSalariMG = dipendenteService.getDipendentiBySalarioMaggioreDi(salario);
				model.addAttribute("ListaDipendenti",dipendentiPerSalariMG);
				return "index";
				
			}
			
			
			@GetMapping("/ordina_per_dataAssunzione")
			public String ordinaDipendentiPerDataAssunzioneAsc(Model model) {
				List<Dipendente> dataAssunzDipendentiAsc = dipendenteService.getDipendentiOrderByDataAssunzioneAsc();
				model.addAttribute("ListaDipendenti",dataAssunzDipendentiAsc);
				return "index";
			}
		
			@GetMapping("/cerca/nome-cognome")
			public String ordinaPerNomeECognome(@RequestParam String nome, @RequestParam String cognome,Model model) {
				 List<Dipendente> dipendentiPerNomeCognome = dipendenteService.getDipendentiByNomeAndCognome(nome, cognome);
				 model.addAttribute("ListaDipendenti", dipendentiPerNomeCognome);
				 return "index";
			}
		}
		

