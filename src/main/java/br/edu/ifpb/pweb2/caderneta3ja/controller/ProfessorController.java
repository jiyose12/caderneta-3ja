package br.edu.ifpb.pweb2.caderneta3ja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;
import br.edu.ifpb.pweb2.caderneta3ja.repository.TurmaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/professor")
public class ProfessorController {
	
	@Autowired
	
	UsuarioRepository usuarioRepository;
	TurmaRepository turmaRepository;

	@RequestMapping(value = "")
	public ModelAndView listarTurmasProfessor(Model model) {
//		 model.addAttribute("turma", turmaRepository.findAll());
		return new ModelAndView("professor/professor");
	}
	
	 @GetMapping("detalhes-turma/{id}")
	    public String detalhesTurma(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("usuario", usuario);
	        return "professor/editarProfessor";
	    }
			
	 @GetMapping("/list")
	 public String ListaProfessor(Model model) {
//		 model.addAttribute("tb_professor", usuarioRepository.findBytipo("professor"));
		 return "professor/listProfessor";
	 }
	 
	 @GetMapping("delet/{id}")
	    public String deleteStudent(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
	        usuarioRepository.delete(usuario);
	        model.addAttribute("tb_professor", usuarioRepository.findAll());
	        return "redirect:/professor/list";
	        

	    }

	 
	 @GetMapping("signup")
	    public String showSignUpForm(Usuario usuario) {
	        return "professor/cadastraProfessor";
	    }
	 
	 
	 @PostMapping("add")
	    public String addStudent(@Valid Usuario usuario, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "professor/cadastraProfessor";
	        }
	       
	        usuarioRepository.save(usuario);
	        
	       
	        return "redirect:list";
	    }
	 
	 
	 
	 
	 @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("usuario", usuario);
	        return "professor/editarProfessor";
	    }
	 
	 @PostMapping("update/{id}")
	    public String updateStudent(@PathVariable("id") Integer id, @Valid Usuario usuario, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            usuario.setId(id);
	            return "professor/editarProfessor";
	        }else {
	        	usuarioRepository.save(usuario);
		        model.addAttribute("students", usuarioRepository.findAll());
		        return "redirect:/professor/list";
				
			}

	        
	    }
	
	
	 
	 
	
	
}
