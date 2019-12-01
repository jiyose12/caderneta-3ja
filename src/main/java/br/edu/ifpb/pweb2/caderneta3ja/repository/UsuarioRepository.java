package br.edu.ifpb.pweb2.caderneta3ja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
/*	@Query("SELECT u FROM Usuario u JOIN u.disciplinas d WHERE d.id = :id AND u.perfil = 'ALUNO'")
	List<Usuario> findTurmaDisciplinaUserAluno(@Param("id")int id);*/
	
	@Query(value = "select DISTINCT u.id, u.nome, u.matricula from usuario u LEFT JOIN turma_usuario tu ON u.id=tu.usuario_id LEFT JOIN turma t ON t.id=tu.turma_id LEFT JOIN disciplina d ON d.id = :did where t.id = :tid and u.tp_perfil='ALUNO'", nativeQuery = true)
	List<Object> findUsuarioAlunoByTurmaDisciplina(@Param("tid")int tid, @Param("did")int did);
	
	@org.springframework.data.jpa.repository.Query("select c from Usuario c where c.perfil='?'")
	List<Usuario> findByPerfil(String perfil);
	
	@org.springframework.data.jpa.repository.Query("select c from Usuario c where c.perfil='PROFESSOR'")
	List<Usuario> findByPerfilProfessor(String perfil);
	
	@org.springframework.data.jpa.repository.Query("select c from Usuario c where c.perfil='ALUNO'")
	List<Usuario> findByPerfilAluno(String perfil);
//	
//	@Query(value = "select DISTINCT n.nota from nota n LEFT JOIN usuario u ON n.usuario_id = u.id where u.id = ?1", nativeQuery = true)
//	List<Object> findTurmaDisciplinaByUser(@Param("id")int id);


}
