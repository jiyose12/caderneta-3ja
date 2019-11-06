package br.edu.ifpb.pweb2.caderneta3ja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {
	
	@RequestMapping("/aluno")
	public ModelAndView listarDisciplinasAluno() {
		return new ModelAndView("aluno/aluno");
	}
	
	@RequestMapping("/aluno/notas")
	public ModelAndView listarNotasAluno() {
		return new ModelAndView("aluno/listar-notas");
	}
}
