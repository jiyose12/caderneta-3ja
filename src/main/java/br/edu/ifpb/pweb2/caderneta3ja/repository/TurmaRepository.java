package br.edu.ifpb.pweb2.caderneta3ja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.pweb2.caderneta3ja.model.Turma;

public interface TurmaRepository extends JpaRepository <Turma, Integer> {
	// Implementação feita pelo próprio Spring Boot
	
	Turma findById(long id);
	
	@org.springframework.data.jpa.repository.Query(value = "select t from Turma t join Disciplina d on t.turma_id = d.disciplina_id", nativeQuery = true)
	List<Turma> findAllTurmaDisciplina();
	
//	@org.springframework.data.jpa.repository.Query("select t from Turma t join Disciplina d where t.id = 1")
//	List<Turma> findAllTurmaDisciplina();
//	
//	@org.springframework.data.jpa.repository.Query("select t.codigo, d.nome, d.curso from Turma t join Disciplina d on t.id = d.turma_id and d.id = t.disciplina_id")
//	List<Turma> fetchTurmaDisciplinaJoin();
//	
//	@org.springframework.data.jpa.repository.Query("SELECT new br.edu.ifpb.pweb2.caderneta3ja.model.Turma(d.name, e.name, e.email, e.address) "
//			+ "FROM Department d LEFT JOIN d.employees e")
//	List<Turma> fetchTurmaDisciplinaJoin2();
	
	
}
