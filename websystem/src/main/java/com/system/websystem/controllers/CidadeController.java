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

import com.system.websystem.models.Cidade;
import com.system.websystem.repository.CidadeRepository;

@Controller
public class CidadeController {

	@Autowired
	private CidadeRepository repository;

	@GetMapping("/addcidade")
	public ModelAndView add(Cidade cidade) {
		ModelAndView mv = new ModelAndView(addcidade);
		mv.addObject(cidade);
		return mv;
	}

	@GetMapping("/cidade")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/cidade");
		List<Cidade> cidade = repository.findAll();
		mv.addObject("cidade", cidade);
		return mv;
	}

	@GetMapping("/editarcidade/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Cidade> c = repository.findById(id);
		Cidade cidade = c.get();
		return add(cidade);
	}

	@GetMapping("/removercidade/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Optional<Cidade> c = repository.findById(id);
		Cidade cidade = c.get();
		repository.delete(cidade);
		return listar();
	}

	@PostMapping("/salvarcidade")
	public ModelAndView save(@Valid Cidade cidade, BindingResult result) {

		if (result.hasErrors()) {
			return add(cidade);
		}
		repository.saveAndFlush(cidade);
		return listar();
	}

}
