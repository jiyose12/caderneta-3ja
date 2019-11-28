package br.edu.ifpb.pweb2.caderneta3ja.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.caderneta3ja.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta3ja.model.Turma;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;
import br.edu.ifpb.pweb2.caderneta3ja.repository.TurmaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/professor")
public class ProfessorController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	TurmaRepository turmaRepository;

	@RequestMapping(value = "")
	public ModelAndView listarTurmasProfessor(Model model) {
		 model.addAttribute("turma", turmaRepository.findAllTurmaDisciplina());
		return new ModelAndView("professor/professor");
	}
	

	
	 @GetMapping("detalhes-turma/{id}")
	    public String detalhesTurma(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("usuario", usuario);
	        return "professor/editarProfessor";
	    }

}
