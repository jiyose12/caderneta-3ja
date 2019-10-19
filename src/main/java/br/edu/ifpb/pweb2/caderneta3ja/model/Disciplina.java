package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Disciplina")
public class Disciplina {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String codigo;
	
	public Disciplina() {}
	public Disciplina(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
}
