package br.edu.ifpb.pweb2.caderneta3ja.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.caderneta3ja.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta3ja.model.Nota;
import br.edu.ifpb.pweb2.caderneta3ja.model.Turma;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;
import br.edu.ifpb.pweb2.caderneta3ja.repository.DisciplinaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.NotaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.UsuarioRepository;

@Controller
@RequestMapping( value = "/aluno")
public class AlunoController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;
	@Autowired
	NotaRepository notasRepository;
	

	@GetMapping("/{id}")
	public ModelAndView listarDisciplinasAluno() {
		return new ModelAndView("aluno/aluno");
	}
	
	 @GetMapping("/list")
	 public String ListaAluno(Model model) {
	 model.addAttribute("usuario", usuarioRepository.findByPerfilAluno("ALUNO"));
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
	

	 
//	 @GetMapping("/visualizar-disciplinas")
//	 public String ListaAlunoDisciplina(Usuario usuario, Model model) {
//		 model.addAttribute("disciplina", disciplinaRepository.findDisciplinaByUsuario());
//		 return "aluno/visualizarDisciplinas";
//	 }
	 
	 
	 @GetMapping("/visualizar-disciplinas/{id}")
	 public String ListaAlunoDisciplina(@PathVariable("id") Integer id, Model model) {
		 model.addAttribute("disciplina", disciplinaRepository.findDisciplinaByAluno(id));
		 return "aluno/visualizarDisciplinas";
	 }
	 
	 
//	 @GetMapping(value = "/listar-notas")
//	 public String listaNotas(Model model) {
//		 model.addAttribute("alunos",notasRepository.findAllAlunoNotas());
//		 return "aluno/listar-notas";
//	 }
	 
	 @GetMapping("/listar-notas/{id}")
	 public String listaNotas(@PathVariable("id") Integer id, Model model) {
		 model.addAttribute("alunos",notasRepository.findAllAlunoNotas(id));
		 return "aluno/listar-notas";
	 }

//	 @GetMapping("/listar-notas")
//	 public String listaNotas(Model model, @PathVariable("id") Integer id, Nota nota) {
//		  usuario = usu.findById(id)
//				 					 .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
//		 model.addAttribute("alunos",notasRepository.findAllAlunoNotas(id));
//		 Usuario usuariobanco = (Usuario) usuarioRepository.findDisciplinaByUser(id);
//		 model.addAttribute("alunos", usuariobanco);
//		 return "aluno/listar-notas";
//	 }

	 
}