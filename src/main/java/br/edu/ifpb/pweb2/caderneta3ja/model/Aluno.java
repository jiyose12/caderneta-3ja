package br.edu.ifpb.pweb2.pweb2project.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Aluno")
public class Aluno extends Pessoa{
	private String matricula;
	
	public Aluno() {}
	
	public Aluno(String nome) {
		super(nome);
	
	}
	public Aluno(String nome, String matricula) {
		super(nome);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
}
