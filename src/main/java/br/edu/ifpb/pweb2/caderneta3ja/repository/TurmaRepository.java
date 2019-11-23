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

@Repository
@Transactional(readOnly = true)
public interface TurmaRepository extends JpaRepository <Turma, Integer> {
	// Implementação feita pelo próprio Spring Boot
	
	Turma findById(long id);
	
//	@Query(value = "select t.codigo from Turma t JOIN Disciplina d ON t.id = d.id ", nativeQuery = true)
	@org.springframework.data.jpa.repository.Query(value = "select d from Disciplina d join d.turmadisciplina")
	List<Disciplina> findAllTurmaDisciplina();
	
	
//	@Query("SELECT  u.codigo FROM  Turma u INNER JOIN Disciplina a ON a.id = u.id WHERE a.id = :codigo")
//			List<Turma> findByIdarea(@Param("codigo") Long codigo);
	


}
