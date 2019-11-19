package br.edu.ifpb.pweb2.caderneta3ja.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;



import br.edu.ifpb.pweb2.caderneta3ja.model.Usuario;

@Service
public interface ProfessorRepository extends JpaRepository<Usuario, Integer> {
	
	
	
	List<Usuario> findBytipo(String tipo);
	List<Usuario> findById(int id);
	
	
	
	
	@Autowired
	public static final JdbcTemplate jtm = new JdbcTemplate();


}
