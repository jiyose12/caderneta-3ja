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
	
	@Query(value = "select DISTINCT u.nome, t.codigo, d.nome as dnome, d.curso, t.id as tid, d.id as did from usuario u LEFT JOIN turma_usuario tu ON u.id=tu.usuario_id LEFT JOIN turma t ON t.id=tu.turma_id LEFT JOIN disciplina d ON d.usuario_id =?1 where u.id = ?1", nativeQuery = true)
	List<Object> findTurmaDisciplinaByUser(@Param("id")int id);
	
//	@Query("SELECT DISTINCT t FROM Turma t LEFT JOIN t.usuario u WHERE u.id = :id")
//	List<Turma> findTurmaByUser(@Param("id")int id);


}
