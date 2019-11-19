package br.edu.ifpb.pweb2.caderneta3ja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.caderneta3ja.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository <Disciplina, Integer> {
	// Implementação feita pelo próprio Spring Boot
	Disciplina findById(long id);
}
