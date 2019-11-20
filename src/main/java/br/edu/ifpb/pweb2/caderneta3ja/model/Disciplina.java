package br.edu.ifpb.pweb2.caderneta3ja.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="disciplina")
public class Disciplina  {
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String codigo;
	private String curso;
	
	
	 
	 @ManyToMany
	 @JoinTable(
	   name = "turma_disciplina", 
	   joinColumns = @JoinColumn(name = "disciplina_id"),
	   inverseJoinColumns = @JoinColumn(name = "turma_id"))
	 Set<Turma> turmadisciplina;

	
	//Construtores
	public Disciplina() {}
	
	public Disciplina(String nome, String codigo, String curso) {
		this.nome = nome;
		this.codigo = codigo;
		this.curso = curso;
	}
	//Métodos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Set<Turma> getTurmadisciplina() {
		return turmadisciplina;
	}

	public void setTurmadisciplina(Set<Turma> turmadisciplina) {
		this.turmadisciplina = turmadisciplina;
	}


	


	
	

	
	
	
	
	
}
