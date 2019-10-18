package br.edu.ifpb.pweb2.caderneta3ja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoordenadorController {

	@RequestMapping("/coordenador")
	public ModelAndView listarTurmasProfessor() {
		return new ModelAndView("coordenador/coordenador");
	}
}
