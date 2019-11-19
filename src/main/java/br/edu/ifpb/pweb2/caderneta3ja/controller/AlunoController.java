package br.edu.ifpb.pweb2.caderneta3ja.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;
import br.edu.ifpb.pweb2.caderneta3ja.repository.UsuarioRepository;

@Controller
@RequestMapping( value = "/aluno")
public class AlunoController {
	
	@Autowired
	UsuarioRepository alunoRepository;
	
	@RequestMapping(value = "")
	public ModelAndView listarDisciplinasAluno() {
		return new ModelAndView("aluno/aluno");
	}
	
	 @GetMapping("/list")
	 public String ListaAluno(Model model) {
		 System.out.println(alunoRepository);
		 model.addAttribute("TP_PERFIL", alunoRepository.findByPerfil("ALUNO"));
		 return "aluno/listAluno";
	 }

	
}