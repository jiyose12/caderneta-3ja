package br.edu.ifpb.pweb2.caderneta3ja.controller;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import br.edu.ifpb.pweb2.caderneta3ja.model.Perfil;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;

import br.edu.ifpb.pweb2.caderneta3ja.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "login")
public class LoginController {

	@Autowired
	private UsuarioRepository usuarioDAO;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm(Model model, @CookieValue(value = "clogin", defaultValue = "") String clogin) {
		Usuario u = new Usuario();
		u.setEmail(clogin);
		model.addAttribute(u);
		
		return "login";
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String validacaoProfessor(Usuario usuario, HttpSession session) {
		Usuario usuariobanco = (Usuario) usuarioDAO.findByEmail(usuario.getEmail());
		String proxPagina = null;
//		System.out.println("TESTE");
//		System.out.println(usuario.getId());
		
		System.out.println(cifrar(usuariobanco));
		System.out.println(cifrar(usuario));
		
		
		if(usuario.getEmail().equals(usuariobanco.getEmail()) && usuario.getSenha().equals(usuariobanco.getSenha()) && usuariobanco.getPerfil() == Perfil.PROFESSOR) {
			session.setAttribute("usuario", usuariobanco);
			proxPagina = "redirect:professor";	
		}else if(usuario.getEmail().equals(usuariobanco.getEmail()) && usuario.getSenha().equals(usuariobanco.getSenha()) && usuariobanco.getPerfil() == Perfil.ALUNO ){
			session.setAttribute("usuario", usuariobanco);
			proxPagina = "redirect:aluno";	
		}else if(usuario.getEmail().equals(usuariobanco.getEmail()) && usuario.getSenha().equals(usuariobanco.getSenha()) && usuariobanco.getPerfil() == Perfil.COORDENADOR){
			session.setAttribute("usuario", usuariobanco);
			proxPagina = "redirect:coordenador";	
		} else {
			proxPagina = "redirect:login";
		}
		
		return proxPagina;
	}
	public static String getHash(byte[] inputBytes, String algorithm) {
		String hashValue = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(inputBytes);
			byte[] disgestedBytes = messageDigest.digest();
			hashValue = DatatypeConverter.printHexBinary(disgestedBytes).toLowerCase();
			
		} catch (Exception e) {
		}	
			return hashValue;
	}

	
	public String cifrar(Usuario usuario) {
		String cifragem = usuario.getSenha();
		
		cifragem  = getHash(cifragem.getBytes(), "SHA-256");
		return cifragem;
		
	}
	

}