package br.edu.ifpb.pweb2.caderneta3ja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.caderneta3ja.model.Pessoa;

public interface TurmaRepository extends JpaRepository <Pessoa, Integer> {
	// Implementação feita pelo próprio Spring Boot
}
