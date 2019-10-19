package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Entity;

@Entity
public class Aluno extends Pessoa{
	
	
	public Aluno(String nome) {
		super(nome);
	}
	
	public Aluno() {}
}
