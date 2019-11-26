package br.edu.ifpb.pweb2.caderneta3ja.repository;

import java.util.List;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.pweb2.caderneta3ja.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta3ja.model.Turma;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;

@Repository
@Transactional(readOnly = true)
public interface TurmaRepository extends JpaRepository <Turma, Integer> {
	// Implementação feita pelo próprio Spring Boot
	
	/*@Query("SELECT DISTINCT t FROM Usuario u JOIN u.disciplinas d JOIN d.turmadisciplina t WHERE u.id = :id")
	List<Turma> findTurmaByUser(@Param("id")int id);*/
	
	@Query("SELECT DISTINCT t FROM Turma t JOIN t.usuario u WHERE u.id = :id")
	List<Turma> findTurmaByUser(@Param("id")int id);
	

}
