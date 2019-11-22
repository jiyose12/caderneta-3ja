package br.edu.ifpb.pweb2.caderneta3ja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.caderneta3ja.repository.UsuarioRepository;


@Controller
public class CoordenadorController {
	
	@Autowired
	UsuarioRepository coordenadorRepository;

	public CoordenadorController() {
		
	}
	
	@RequestMapping(value = "/coordenador")
	public ModelAndView listarTodasTurmas() {
		return new ModelAndView("coordenador/coordenador");
	}
	
//	 @GetMapping("/list")
//	 public String ListaAluno(Model model) {
//		 System.out.println(coordenadorRepository);
//		 model.addAttribute("TP_PERFIL", coordenadorRepository.findByPerfil("COORDENADOR"));
//		 return "aluno/listAluno";
//	 }
}
