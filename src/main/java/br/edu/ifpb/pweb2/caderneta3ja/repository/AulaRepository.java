package br.edu.ifpb.pweb2.caderneta3ja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.pweb2.caderneta3ja.model.Aula;

public interface AulaRepository extends JpaRepository <Aula, Integer> {
	// Implementação feita pelo próprio Spring Boot
	
	@Query("SELECT DISTINCT a FROM aula a LEFT JOIN a.disciplina d WHERE d.id = :did")
	List<Aula> findAulaByDisciplina(@Param("did")int did);
}
