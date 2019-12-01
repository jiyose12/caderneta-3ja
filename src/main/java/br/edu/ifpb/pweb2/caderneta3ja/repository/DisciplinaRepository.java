package br.edu.ifpb.pweb2.caderneta3ja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.pweb2.caderneta3ja.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta3ja.model.Turma;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;

public interface DisciplinaRepository extends JpaRepository <Disciplina, Integer> {
	// Implementação feita pelo próprio Spring Boot
	
	@Query("SELECT DISTINCT d FROM Usuario u JOIN u.disciplinas d JOIN d.turmadisciplina t WHERE u.id = :id AND u.perfil = 'ALUNO'")
	List<Disciplina> findDisciplinaByUserAluno(@Param("id")int id);
	
	@org.springframework.data.jpa.repository.Query(value = "select d from Disciplina d join d.turmadisciplina")
	List<Disciplina> findAllDisciplinaTurma();
	
	@org.springframework.data.jpa.repository.Query(value = "select d from Disciplina d join d.usuario")
	List<Disciplina> findAllDisciplinaAluno();
	
	@org.springframework.data.jpa.repository.Query("SELECT u FROM Disciplina u join u.usuario")
	List<Disciplina> findDisciplinaByUsuario();
	
	@Query("SELECT DISTINCT d FROM Usuario u JOIN u.disciplinas d WHERE u.id = :id AND u.perfil = 'ALUNO'")
	List<Disciplina> findDisciplinaByAluno(@Param("id")int id);
	
	

}
