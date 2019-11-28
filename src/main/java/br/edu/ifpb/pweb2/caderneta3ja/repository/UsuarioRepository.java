package br.edu.ifpb.pweb2.caderneta3ja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;

@Repository
@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	// Implementação feita pelo próprio Spring Boot
	
	Usuario findById(long id);
	List<Usuario> findById(int id);
	
	Usuario findByEmail(String email);
	
	/* List<Usuario> findByPerfil(String perfil); */
	
	@org.springframework.data.jpa.repository.Query("select c from Usuario c where c.perfil='?'")
	List<Usuario> findByPerfil(String perfil);
	
	@org.springframework.data.jpa.repository.Query("select c from Usuario c where c.perfil='PROFESSOR'")
	List<Usuario> findByPerfilProfessor(String perfil);
	
	@org.springframework.data.jpa.repository.Query("select c from Usuario c where c.perfil='ALUNO'")
	List<Usuario> findByPerfilAluno(String perfil);


}
