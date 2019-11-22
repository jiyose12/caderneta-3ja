package br.edu.ifpb.pweb2.caderneta3ja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.caderneta3ja.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;

public interface DisciplinaRepository extends JpaRepository <Disciplina, Integer> {
	// Implementação feita pelo próprio Spring Boot
	
	
	List<Disciplina> findById(int id);
	

}
