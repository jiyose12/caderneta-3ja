package br.edu.ifpb.pweb2.caderneta3ja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.caderneta3ja.model.Turma;

public interface TurmaRepository extends JpaRepository <Turma, Integer> {
	// Implementação feita pelo próprio Spring Boot
	
	Turma findById(long id);
}
