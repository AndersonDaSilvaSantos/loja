package com.system.websystem.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.system.websystem.models.Estado;
import com.system.websystem.repository.EstadoRepository;

@Controller
public class EstadoController {
	
	@Autowired
	private EstadoRepository repository;
	
	@GetMapping("/addestado")
	public ModelAndView add(Estado estado){
		ModelAndView mv = new ModelAndView(addestado);
		mv.addObject(estado);
		return mv;
	}
	
	@GetMapping("/estado")
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("/estado");
		List<Estado> estado = repository.findAll();
		mv.addObject("estado" , estado);
		return mv;
	}
	
	@GetMapping("/editarestado/ {id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		Optional<Estado> e = repository.findById(id);
		Estado estado = e.get();
		return add(estado);
	}
	
	@GetMapping("/removerestado/ {id}")
	public ModelAndView delete(@PathVariable("id") Long id){
		Optional<Estado> e = repository.findById(id);
		Estado estado = e.get();
		repository.delete(estado);
		return listar();
	}
	
	@PostMapping("/salvarestado")
	public ModelAndView save(@Valid Estado estado, BindingResult result){
		
		if(result.hasErrors()){
			return add(estado);
		}
		repository.saveAndFlush(estado);
		return listar();
	}
}
