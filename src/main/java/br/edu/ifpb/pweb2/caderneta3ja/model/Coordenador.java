package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_Coordenador")
public class Coordenador{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private boolean ativo;
	
	@OneToOne
    @MapsId
    @JoinColumn(name="id_professor")
	private Professor professor;

	public Coordenador() {
		super();
	}

	public Coordenador(boolean ativo, Professor professor) {
		super();
		this.ativo = ativo;
		this.professor = professor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
	
	
}
