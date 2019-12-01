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
import br.edu.ifpb.pweb2.caderneta3ja.model.Turma;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;
import br.edu.ifpb.pweb2.caderneta3ja.repository.DisciplinaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.TurmaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.UsuarioRepository;


@Controller
@RequestMapping(value = "/coordenador")
public class CoordenadorController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@Autowired
	TurmaRepository turmaRepository;
	
	
	@RequestMapping(value = "")
	public ModelAndView TelaCoordenador() {
		return new ModelAndView("coordenador/coordenador");
	}
	
//	***COORDENADOR CRUD PROFESSOR**
	
	 @GetMapping("/list-professor")
	 public String ListaProfessor(Model model) {
	 model.addAttribute("tb_professor", usuarioRepository.findByPerfilProfessor("PROFESSOR"));
		 return "professor/list-professor";
	 }
	 
	 @GetMapping("delet/{id}")
	    public String deleteProfessor(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
	        usuarioRepository.delete(usuario);
	        model.addAttribute("tb_professor", usuarioRepository.findAll());
	        return "redirect:/coordenador/list-professor";
	        

	    }
	 
	 @GetMapping("edit-professor/{id}")
	    public String showUpdateFormProfessor(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("usuario", usuario);
	        return "professor/editar-professor";
	    }
	 
	 @PostMapping("update/{id}")
	    public String updatProfessor(@PathVariable("id") Integer id, @Valid Usuario usuario, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            usuario.setId(id);
	            return "professor/editar-professor";
	        }else {
	        	usuarioRepository.save(usuario);
		        model.addAttribute("students", usuarioRepository.findAll());
		        return "redirect:/coordenador/list-professor";
				
			}
	    }
	 
	 @GetMapping("cadastra-professor")
	    public String showSignUpFormProfessor(Usuario usuario) {
	        return "professor/cadastra-professor";
	    }
	 
	 
	 @PostMapping("add")
	    public String addProfessor(@Valid Usuario usuario, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "professor/cadastra-professor";
	        }
	       
	        usuarioRepository.save(usuario);
	        
	       
	        return "redirect:/coordenador/list-professor";
	    }
	 
//	 **********************************************************************
	 
//		***COORDENADOR CRUD ALUNO**
	 
	 @GetMapping("/list-aluno")
	 public String ListaAluno(Model model) {
	 model.addAttribute("usuario", usuarioRepository.findByPerfilAluno("ALUNO"));
		 return "aluno/list-aluno";
	 }
	 
	 @GetMapping("Edelet/{id}")
	    public String deleteAluno(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
	        usuarioRepository.delete(usuario);
	        model.addAttribute("tb_professor", usuarioRepository.findAll());
	        return "redirect:/coordenador/list-aluno";
	        

	    }
	 
	 @GetMapping("edit-aluno/{id}")
	    public String showUpdateFormAluno(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("usuario", usuario);
	        return "aluno/editar-aluno";
	    }
	 
	 @PostMapping("updatep/{id}")
	    public String updateAluno(@PathVariable("id") Integer id, @Valid Usuario usuario, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            usuario.setId(id);
	            return "aluno/editarAluno";
	        }else {
	        	usuarioRepository.save(usuario);
		        model.addAttribute("students", usuarioRepository.findAll());
		        return "redirect:/coordenador/list-aluno";
				
			}

	        
	    }
	 
	 @GetMapping("cadastra-aluno")
	    public String showSignUpForm(Usuario usuario) {
	        return "aluno/cadastra-aluno";
	    }
	 
	 
	 @PostMapping("add-aluno")
	    public String addestudante(@Valid Usuario usuario, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "aluno/cadastraAluno";
	        }
	       
	        usuarioRepository.save(usuario);
	        
	       
	        return "redirect:/coordenador/list-aluno";
	    }
	 
//	 **********************************************************************
	 
//		***COORDENADOR CRUD DISCIPLINA**
	 
	 @GetMapping("/list-disciplina")
	 public String ListaDisciplina(Model model) {
		 model.addAttribute("disciplina", disciplinaRepository.findAll());
		 return "disciplina/listdisciplina";
	 }
	 
	 @GetMapping("deletD/{id}")
	    public String deleteDisciplina(@PathVariable("id") Integer id, Model model) {
	        Disciplina disciplina = disciplinaRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
	        disciplinaRepository.delete(disciplina);
	        model.addAttribute("disciplina", disciplinaRepository.findAll());
	        return "redirect:/coordenador/list-disciplina";
	        
	    }
	 
	 @GetMapping("edit-disciplna/{id}")
	    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
	        Disciplina disciplina = disciplinaRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("disciplina", disciplina);
	        return "disciplina/editardisciplina";
	    }
	 
	 @PostMapping("updateDisciplina/{id}")
	    public String updateStudent(@PathVariable("id") Integer id, @Valid Disciplina disciplina, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            disciplina.setId(id);
	            return "disciplina/editardisciplina";
	        }else {
	        	disciplinaRepository.save(disciplina);
		        model.addAttribute("students", disciplinaRepository.findAll());
		        return "redirect:/coordenador/list-disciplina";
				
			}

	        
	    }
	 
	 @GetMapping("cadastra-disciplina")
	    public String showSignUpForm(Disciplina disciplina, Model model) {
		 model.addAttribute("tb_professor", usuarioRepository.findByPerfilProfessor("PROFESSOR"));
	        return "disciplina/cadastradisciplina";
	    }
	 
	 @PostMapping("add-disciplina")
	    public String addStudent(@Valid Disciplina disciplina, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "disciplina/cadastraDisciplina";
	        }
	       
	        disciplinaRepository.save(disciplina);
	        
	       
	        return "redirect:/coordenador/list-disciplina";
	    }
	 
//	 **********************************************************************
	 
//		***COORDENADOR CRUD TURMA**
	 
	 @GetMapping("/list-turma")
	 public String ListaTurma(Model model) {
		 model.addAttribute("turma", turmaRepository.findAll());
		 return "turma/list-turma";
	 }
	 
	 @GetMapping("deletT/{id}")
	    public String deleteTurma(@PathVariable("id") Integer id, Model model) {
	        Turma turma = turmaRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
	        turmaRepository.delete(turma);
	        model.addAttribute("turma", turmaRepository.findAll());
	        return "redirect:/coordenador/list-turma";
	        
	    }
	 @GetMapping("edit-turma/{id}")
	    public String showUpdateFormTurma(@PathVariable("id") Integer id, Model model) {
		 Turma turma = turmaRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("turma", turma);
	        return "turma/editarturma";
	    }
	 @PostMapping("updateTurma/{id}")
	    public String updatTurma(@PathVariable("id") Integer id, @Valid Turma turma, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            turma.setId(id);
	            return "turma/editarturma";
	        }else {
	        	turmaRepository.save(turma);
		        model.addAttribute("turma", turmaRepository.findAll());
		        return "redirect:/coordenador/list-turma";
				
			}

	        
	    }
	 
	 @GetMapping("cadastra-turma")
	    public String showSignUpFormTurma(Turma turma) {
	        return "turma/cadastraturma";
	    }
	 
	 @PostMapping("add-turma")
	    public String addTurma(@Valid Turma turma, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "turma/cadastraturma";
	        }
	       
	        turmaRepository.save(turma);
	        
	       
	        return "redirect:/coordenador/list-turma";
	    }
	 
//	 **********************************************************************
	 
//		***COORDENADOR 	CADASTRAR PROFESSOR&DISCIPLINA**
	 
	 
	 @GetMapping("cadastrar-professor-disciplina")
		public ModelAndView TelaCadastroProfessorTurma(Model model) {
		 model.addAttribute("disciplina", disciplinaRepository.findAll());
		 model.addAttribute("tb_professor", usuarioRepository.findByPerfilProfessor("PROFESSOR"));
			return new ModelAndView("coordenador/cadastrar-professor-disciplina");
		}
	 
	 
	 @PostMapping("add-turma")
	    public String AddProfessoDisciplina(@Valid Disciplina disciplina, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "turma/cadastraturma";
	        }
	       
	        disciplinaRepository.save(disciplina);
	        
	       
	        return "redirect:/coordenador/list-turma";
	    }
	 
 
	
	 
	 

}
