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
	
	
	@GetMapping("/list")
	 public String ListaAluno(Model model) {
		 model.addAttribute("disciplina", disciplinaRepository.findAll());
		 return "disciplina/listdisciplina";
	 }
	
	 @GetMapping("delet/{id}")
	    public String deleteStudent(@PathVariable("id") Integer id, Model model) {
	        Disciplina disciplina = disciplinaRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
	        disciplinaRepository.delete(disciplina);
	        model.addAttribute("tb_professor", disciplinaRepository.findAll());
	        return "redirect:/disciplina/list";
	        
	    }
	 
	 @GetMapping("signup")
	    public String showSignUpForm(Disciplina disciplina) {
	        return "disciplina/cadastraDisciplina";
	    }
	 
	 @PostMapping("add")
	    public String addStudent(@Valid Disciplina disciplina, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "disciplina/cadastraDisciplina";
	        }
	       
	        disciplinaRepository.save(disciplina);
	        
	       
	        return "redirect:list";
	    }
	 
	 @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
	        Disciplina disciplina = disciplinaRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("disciplina", disciplina);
	        return "disciplina/editardisciplina";
	    }
	 
	 @PostMapping("update/{id}")
	    public String updateStudent(@PathVariable("id") Integer id, @Valid Disciplina disciplina, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            disciplina.setId(id);
	            return "disciplina/editardisciplina";
	        }else {
	        	disciplinaRepository.save(disciplina);
		        model.addAttribute("students", disciplinaRepository.findAll());
		        return "redirect:/aluno/list";
				
			}

	        
	    }
	 
	 
	 
	 
}
