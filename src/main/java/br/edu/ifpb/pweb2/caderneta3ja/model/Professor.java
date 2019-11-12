package br.edu.ifpb.pweb2.caderneta3ja.model;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="tb_professor")
public class Professor{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String nome;
	private String email;
	
	@OneToOne(mappedBy = "professor", cascade = CascadeType.ALL)
	private Coordenador coordenador;
	
	public Professor() {}
	public Professor(String nome) {
		this.nome = nome;
	}
	public Professor(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Coordenador getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}
