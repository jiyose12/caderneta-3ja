package br.edu.ifpb.pweb2.pweb2project.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class Professor extends Pessoa{
	private String email;
	
	@OneToOne(mappedBy = "professor", cascade = CascadeType.ALL)
	private Coordenador coordenador;
	
	public Professor() {}
	public Professor(String nome) {
		super(nome);
	}
	public Professor(String nome, String email) {
		super(nome);
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
