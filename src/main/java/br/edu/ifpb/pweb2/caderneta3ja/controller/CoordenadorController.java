package br.edu.ifpb.pweb2.caderneta3ja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.caderneta3ja.repository.CoodernadorRepository;

@Controller

public class CoordenadorController {
	
	private final CoodernadorRepository coodernadorRepository;

	public CoordenadorController(CoodernadorRepository coodernadorRepository) {
		super();
		this.coodernadorRepository = coodernadorRepository;
	}
	@RequestMapping( value = "/coordenador")
	public ModelAndView listarTurmasProfessor() {
		return new ModelAndView("coordenador/coordenador");
	}
}
