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

import it.david.exceptions.IdNotFoundException;
import it.david.model.Dipartimento;
import it.david.service.DipartimentoService;

@Controller
@RequestMapping("/dipartimenti")
public class DipartimentoController {

	private DipartimentoService dipartimentoService;

	// Injection Point by Constructor
	public DipartimentoController(DipartimentoService dipartimentoService) {
		this.dipartimentoService = dipartimentoService;

	}

	@GetMapping("/")
	public String mostraListaDipartimenti(Model model) {
		List<Dipartimento> listaDipartimenti = dipartimentoService.getAllDipartimenti();
		model.addAttribute("listaDipartimenti", listaDipartimenti);
		return "dipartimenti_list";

	}

	@GetMapping("/cercaDipartimento/{id}")
	public String cercaDipartimentoPerId(@PathVariable Long id, Model model) throws IdNotFoundException {
		Optional<Dipartimento> dipartimentoOpt = dipartimentoService.getDipartimentoById(id);
		model.addAttribute("dipartimento", dipartimentoOpt.get());
		return "dipartimenti_list";
	}

	@PostMapping("/salva")
	public String salvaDipartimento(@ModelAttribute Dipartimento dipartimento) {
		dipartimentoService.createDipartimento(dipartimento);
		return "redirect:/dipartimenti/";
	}

	@GetMapping("/elimina/{id}")
	public String eliminaDipartimentoPerId(@PathVariable Long id) {
		dipartimentoService.removeDipartimento(id);
		return "redirect:/dipartimenti/";
	}

	@GetMapping("/formDipartimento")
	public String formDipartimento(Model model) {
		model.addAttribute("dipartimento", new Dipartimento());
		return "dipartimento_form";
	}

	@GetMapping("/cercaPerNome")
	public String cercaDipartimentoPerNome(@RequestParam String nomeDipartimento, Model model) {
		List<Dipartimento> listaDipartimentiByName = dipartimentoService.getAllDipartimentiByNome(nomeDipartimento);
		model.addAttribute("ListaDipartimenti", listaDipartimentiByName);
		return "dipartimenti_list";
	}
}
