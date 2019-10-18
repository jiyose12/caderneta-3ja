package br.edu.ifpb.pweb2.caderneta3ja.controller;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfessorController {
	
//	@RequestMapping("/professor")
//	public String listarTurmasProfessor(Model model) {
//		return "professor/list";
//	}

	@RequestMapping("/professor")
	public ModelAndView listarTurmasProfessor() {
		return new ModelAndView("professor/professor");
	}

}
