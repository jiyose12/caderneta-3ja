package br.edu.ifpb.pweb2.caderneta3ja.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_Turma")
public class Turma {
	
	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String codigo;
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private Set<Aluno> alunos;
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private Set<Disciplina> disciplinas;
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private Set<Aula> aulas;
	
	@ManyToMany(mappedBy = "turmas")
	Set<Professor> professores;
	
	

	
	// Construtores
	public Turma(String codigo) {
		this.codigo = codigo;
	}
	public Turma() {}

	
	// Métodos getters e setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
