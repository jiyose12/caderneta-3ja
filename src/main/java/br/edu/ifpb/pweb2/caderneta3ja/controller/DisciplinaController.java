package br.edu.ifpb.pweb2.caderneta3ja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.caderneta3ja.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;
import br.edu.ifpb.pweb2.caderneta3ja.repository.DisciplinaRepository;

@Controller
@RequestMapping( value = "/disciplina")
public class DisciplinaController {
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	 	 
}
