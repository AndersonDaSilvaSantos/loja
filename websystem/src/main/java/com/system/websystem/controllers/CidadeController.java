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
import com.system.websystem.models.Estado;
import com.system.websystem.repository.CidadeRepository;
import com.system.websystem.repository.EstadoRepository;





@Controller
public class CidadeController {
	
	@Autowired
	private CidadeRepository repository;
	
	@Autowired
	private EstadoRepository repositoryEstado;
	
	@GetMapping("/cidades")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("venda/cidadeLista");
		mv.addObject("cidades", repository.findAll());
				
		
		return mv;
	}
	
	@GetMapping("/adicionarCidade")
	public ModelAndView add(Cidade cidade) {
		
		ModelAndView mv = new ModelAndView("venda/adicionarCidade");
		mv.addObject("cidade", cidade);
		
		List<Estado> listaEstado = repositoryEstado.findAll();
		mv.addObject("estados",listaEstado);
		
		return mv;
	}
	
	@GetMapping("/editarCidade/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Cidade> cidade = repository.findById(id);
		Cidade c = cidade.get();	
		
		return add(c);
	}
	
	@GetMapping("/removerCidade/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Cidade> cidade = repository.findById(id);
		Cidade c = cidade.get();
		repository.delete(c);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarCidade")
	public ModelAndView save(@Valid Cidade cidade, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(cidade);
		}
		
		repository.saveAndFlush(cidade);
		
		return buscarTodos();
	}
	
}