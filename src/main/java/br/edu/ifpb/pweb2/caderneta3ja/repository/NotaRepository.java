package br.edu.ifpb.pweb2.caderneta3ja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.pweb2.caderneta3ja.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta3ja.model.Nota;
import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;

public interface NotaRepository extends JpaRepository <Nota, Integer> {
	// Implementação feita pelo próprio Spring Boot
	Nota findById(long id);
	
	@org.springframework.data.jpa.repository.Query(value = "select n from Nota n join n.usuario")
	List<Nota> findAllAlunoNotas();
	
	@org.springframework.data.jpa.repository.Query(value = "select n from Nota n join n.usuario u WHERE u.id = :id")
	List<Nota> findAllAlunoNotas(@Param("id")int id);
	
	@Query(value = "select n from Nota n JOIN Usuario u ON n.usuario_id = u.id where u.id = ?1", nativeQuery = true) 	
	List<Object> findNotaByUser(@Param("id")int id);
	
	@Query("select d FROM Usuario u JOIN u.notas d WHERE u.id = :id")
	List<Nota> findNotaByAluno(@Param("id")int id);
	
	
}
