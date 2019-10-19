package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_Aluno")
public class Aluno extends Pessoa{
	
	
	public Aluno(String nome) {
		super(nome);
	}
	
	public Aluno() {}
}
