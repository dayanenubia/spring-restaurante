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
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.RestauranteRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Entregador;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Restaurante;

@Controller
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private EntregadorRepository entregadorRepository;
	
	@GetMapping("/restaurantes")
	public String restaurantes(Model model) {
		
		List<Restaurante> restaurantes = restauranteRepository.findAll();
		model.addAttribute("restaurantes", restaurantes);
		
		return "indexRestaurantes";
	}
	
	@GetMapping("/restaurantes/form")
	public String restauranteForm(Model model, @ModelAttribute("restaurante") Restaurante restaurante) {
		List<Entregador> entregadores = entregadorRepository.findAll();
		model.addAttribute("entregadores",entregadores);
		return "restaurante_form";
	}
	
	@PostMapping("/restaurantes/new")
	public String restauranteNew(@Valid @ModelAttribute("restaurante=") Restaurante restaurante, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "restaurante_form";
		}
		restauranteRepository.save(restaurante);
		return "redirect:/restaurantes";
	}
	
	@GetMapping("/restaurantes/update/{id}")
	public String restauranteUpdate(@PathVariable("id") Integer id, Model model) {
		
		Optional<Restaurante> optRestaurante = restauranteRepository.findById(id);
		
		if(!optRestaurante.isPresent()) {
			//Gerar erro
		}
		
		Restaurante restaurante = optRestaurante.get();
		
		model.addAttribute("restaurante", restaurante);
		
		List<Entregador> entregadores = entregadorRepository.findAll();
		model.addAttribute("entregadores",entregadores);
		
		return "restaurante_form";
	}
	
	@GetMapping("/restaurantes/delete/{id}")
	public String restauranteDelete(@PathVariable("id") Integer id, Model model) {
		
		Optional<Restaurante> optRestaurante = restauranteRepository.findById(id);
		
		if(!optRestaurante.isPresent()) {
			//Gerar erro
		}
		
		Restaurante restaurante = optRestaurante.get();
		
		restauranteRepository.delete(restaurante);
		
		return "redirect:/restaurantes";
	}
}