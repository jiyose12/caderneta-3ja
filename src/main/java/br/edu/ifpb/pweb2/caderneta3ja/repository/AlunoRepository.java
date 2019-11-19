package br.edu.ifpb.pweb2.caderneta3ja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;

@Service
public interface AlunoRepository extends JpaRepository<Usuario, Integer> {
	List<Usuario> findBytipo(String tipo);
	List<Usuario> findById(int id);
	

}
