package br.edu.ifpb.pweb2.caderneta3ja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.caderneta3ja.model.Aula;

public interface AulaRepository extends JpaRepository <Aula, Integer> {
	// Implementação feita pelo próprio Spring Boot
	
	Aula findById(long id);
}
