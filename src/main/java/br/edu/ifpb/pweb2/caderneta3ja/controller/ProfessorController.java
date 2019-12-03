package br.edu.ifpb.pweb2.caderneta3ja.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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

import br.edu.ifpb.pweb2.caderneta3ja.model.Aula;
import br.edu.ifpb.pweb2.caderneta3ja.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta3ja.model.Frequencia;
import br.edu.ifpb.pweb2.caderneta3ja.model.Turma;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;
import br.edu.ifpb.pweb2.caderneta3ja.repository.AulaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.DisciplinaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.FrequenciaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.TurmaRepository;
import br.edu.ifpb.pweb2.caderneta3ja.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/professor")
public class ProfessorController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	TurmaRepository turmaRepository;
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@Autowired
	AulaRepository aulaRepository;
	
	@Autowired
	FrequenciaRepository frequenciaRepository;

	 @GetMapping("/{id}")
	public ModelAndView listarTurmasProfessor(@PathVariable("id") Integer id, Model model) {
		 	model.addAttribute("turma", turmaRepository.findTurmaDisciplinaByUser(id));

		 	return new ModelAndView("professor/professor");
	}

	
	 @GetMapping("detalhes-turma/{tid}/{did}/{uid}")
	    public String detalhesTurma(@PathVariable("tid") Integer tid,@PathVariable("did") Integer did, @PathVariable("uid") Integer uid, Model model) {
	     
		 	model.addAttribute("aula", usuarioRepository.findAulaByUsuarioTurmaDisciplina(uid,did,tid));
		 	model.addAttribute("turma", turmaRepository.findById(tid).get());
		 	model.addAttribute("frequencia", new Frequencia());
		 	model.addAttribute("frequenciaOptions", this.getPresencaOption());
		 	model.addAttribute("disciplina", disciplinaRepository.findById(did).get());
	        model.addAttribute("aluno", usuarioRepository.findUsuarioAlunoByTurmaDisciplina(tid, did));
	        
	        return "professor/turma-professor";
	 }
	 
	 @PostMapping("cadastrar-frequencia/{uid}")
	    public String cadastrarFrequencia(@PathVariable("uid") Integer uid, Frequencia frequencia, HttpServletRequest request) {

		 String ultimaPagina = request.getHeader("Referer");	 
		 
		 Optional<Usuario> d = usuarioRepository.findById(uid);
		 
		 frequencia.setUsuario(d.get());
		 
		 frequenciaRepository.save(frequencia);
		 
	        return "redirect:"+ ultimaPagina;
	    }
	 
	 @GetMapping("formulario-aula/{did}")
	    public ModelAndView aulaForm(@PathVariable("did") Integer id, Model model) {
		 
		 model.addAttribute("disciplina", disciplinaRepository.findById(id).get());
		 
		 model.addAttribute("aula", new Aula());
		 
		 return new ModelAndView("professor/formulario-aula");
	    }
	 
	 @PostMapping("cadastrar-aula/{did}")
	    public String cadastrarAula(@PathVariable("did") Integer did, Aula aula, HttpServletRequest request) {

		 String ultimaPagina = request.getHeader("Referer");	 
		 
		 Optional<Disciplina> d = disciplinaRepository.findById(did);
		 
		 aula.setDisciplina(d.get());
		 
		 aulaRepository.save(aula);
		 
	        return "redirect:"+ ultimaPagina;
	    }
	 
	 private Map<String, Integer> getPresencaOption(){
		 LinkedHashMap<String, Integer> options = new LinkedHashMap<String, Integer>();
		 options.put("Presenca", 1);
		 options.put("Falta", 0);
		 
		 return options;
	 }
	
	/*
	 * @GetMapping("/list") public String ListaProfessor(Model model) {
	 * model.addAttribute("tb_professor", professorRepository.findAll(new
	 * Sort(Sort.Direction.ASC, "nome"))); return"professor/listProfessor"; }
	 */
	
	
	 @GetMapping("/list")
	 public String ListaProfessor(Model model) {
	 model.addAttribute("tb_professor", usuarioRepository.findByPerfilProfessor("PROFESSOR"));
		 return "professor/list-professor";
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
	        return "professor/cadastra-professor";
	    }
	 
	 
	 @PostMapping("add")
	    public String addStudent(@Valid Usuario usuario, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "professor/cadastra-professor";
	        }
	       
	        usuarioRepository.save(usuario);
	        
	       
	        return "redirect:list";
	    }
	 
	 
	 
	 
	 @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
	        Usuario usuario = usuarioRepository.findById(id)
	        		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("usuario", usuario);
	        return "professor/editar-professor";
	    }
	 
	 @PostMapping("update/{id}")
	    public String updateStudent(@PathVariable("id") Integer id, @Valid Usuario usuario, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            usuario.setId(id);
	            return "professor/editar-professor";
	        }else {
	        	usuarioRepository.save(usuario);
		        model.addAttribute("students", usuarioRepository.findAll());
		        return "redirect:/professor/list";
				
			}
	    }
}