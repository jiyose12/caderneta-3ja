package br.edu.ifpb.pweb2.caderneta3ja.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "")
	public ModelAndView listarDisciplinasAluno() {
		return new ModelAndView("aluno/aluno");
	}
	
	 @GetMapping("/list")
	 public String ListaAluno(Model model) {
//		 model.addAttribute("usuario", usuarioRepository.findBytipo("aluno"));
		 return "aluno/listAluno";
	 }
	 
	 @GetMapping("delet/{id}")
	    public String deleteStudent(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
	        usuarioRepository.delete(usuario);
	        model.addAttribute("tb_professor", usuarioRepository.findAll());
	        return "redirect:/aluno/list";
	        

	    }
	 
	 @GetMapping("signup")
	    public String showSignUpForm(Usuario usuario) {
	        return "aluno/cadastraAluno";
	    }
	 
	 
	 @PostMapping("add")
	    public String addStudent(@Valid Usuario usuario, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "aluno/cadastraAluno";
	        }
	       
	        usuarioRepository.save(usuario);
	        
	       
	        return "redirect:list";
	    }
	 
	 
	 @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("usuario", usuario);
	        return "aluno/editarAluno";
	    }
	 
	 @PostMapping("update/{id}")
	    public String updateStudent(@PathVariable("id") Integer id, @Valid Usuario usuario, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            usuario.setId(id);
	            return "professor/editarAluno";
	        }else {
	        	usuarioRepository.save(usuario);
		        model.addAttribute("students", usuarioRepository.findAll());
		        return "redirect:/aluno/list";
				
			}

	        
	    }
	 
	
	
}