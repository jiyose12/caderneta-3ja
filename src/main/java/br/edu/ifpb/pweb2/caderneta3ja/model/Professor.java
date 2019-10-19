package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Entity;

@Entity
public class Professor extends Pessoa{
	
	private String email;
	
	public Professor(String nome, String email) {
		super(nome);
		this.email= email;
	}
	public Professor() {}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
