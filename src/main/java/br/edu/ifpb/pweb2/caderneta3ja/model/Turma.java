package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Turma")
public class Turma {
	
	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String codigo;
	
	
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
