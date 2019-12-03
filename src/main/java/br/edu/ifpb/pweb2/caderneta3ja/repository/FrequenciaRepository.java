package br.edu.ifpb.pweb2.caderneta3ja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.pweb2.caderneta3ja.model.Frequencia;

@Repository
@Transactional(readOnly = true)
public interface FrequenciaRepository extends JpaRepository <Frequencia, Integer>{

}
