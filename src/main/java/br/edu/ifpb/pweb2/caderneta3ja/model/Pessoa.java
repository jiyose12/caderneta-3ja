package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public abstract class Pessoa {
	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, 
		       fetch = FetchType.LAZY, optional = true)
	private Usuario usuario;
	
	// Construtores
	public  Pessoa() {}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	// Métodos getters e setters
	public int getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "ID: "+id+" Nome: "+nome;
	}
	
	
	
	
}
