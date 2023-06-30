package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.EntregadorRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Entregador;

@Controller
public class EntregadorController {
	
	@Autowired
	private EntregadorRepository entregadorRepository;
	
	@GetMapping("/entregadores")
	public String entregadores(Model model) {
		
		List<Entregador> entregadores = entregadorRepository.findAll();
		model.addAttribute("entregadores", entregadores);
		
		return "indexEntregador";
	}
	

	@GetMapping("")
	public String index(Model model) {
		
		List<Entregador> entregadores = entregadorRepository.findAll();
		model.addAttribute("entregadores", entregadores);
		
		return "indexEntregador";
	}
	
	
	
	@GetMapping("/entregadores/form")
	public String entregadorForm(@ModelAttribute("entregador") Entregador entregador) {
		return "entregador_form";
	}
	
	@PostMapping("/entregadores/new")
	public String entregadorNew(@Valid @ModelAttribute("entregador=") Entregador entregador, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "entregador_form";
		}
		entregadorRepository.save(entregador);
		return "redirect:/entregadores";
	}
	
	@GetMapping("/entregadores/update/{id}")
	public String entregadorUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Entregador> optEntregador = entregadorRepository.findById(id);
		
		if(!optEntregador.isPresent()) {
			//Gerar erro
		}
		
		Entregador entregador = optEntregador.get();
		
		model.addAttribute("entregador", entregador);
		
		return "entregador_form";
	}
	
	@GetMapping("/entregadores/delete/{id}")
	public String entregadorDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Entregador> optEntregador = entregadorRepository.findById(id);
		
		if(!optEntregador.isPresent()) {
			//Gerar erro
		}
		
		Entregador entregador = optEntregador.get();
		
		entregadorRepository.delete(entregador);
		
		return "redirect:/entregadores";
	}
}