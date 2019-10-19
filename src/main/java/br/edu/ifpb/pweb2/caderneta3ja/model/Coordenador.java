package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Entity;

@Entity
public class Coordenador extends Pessoa {
	
	public Coordenador(String nome) {
		super(nome);
	}
	
	public Coordenador() {}
	
	
}
