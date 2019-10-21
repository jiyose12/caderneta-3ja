package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_Professor")
public class Professor extends Pessoa{
	
	
	// Atributos
	private String email;
	
	
	// Construtores
	public Professor(String nome, String email) {
		super(nome);
		this.email= email;
	}
	
	public Professor() {}
	
	// Métodos getters e setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
