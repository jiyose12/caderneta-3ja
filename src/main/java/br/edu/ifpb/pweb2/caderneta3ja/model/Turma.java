package br.edu.ifpb.pweb2.caderneta3ja.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="turma")
public class Turma {
		
	// Atributos
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		private String codigo;
		
		 @ManyToMany
		 Set<Disciplina> disciplina;
		 
		 @ManyToMany(mappedBy="turmausuario")
		 Set<Usuario> usuario;

		// Construtores
		public Turma(String codigo) {
			this.codigo = codigo;
		}
		public Turma() {}

		
		// Métodos getters e setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public Set<Disciplina> getDisciplina() {
			return disciplina;
		}
		public void setDisciplina(Set<Disciplina> disciplina) {
			this.disciplina = disciplina;
		}
		
		public void addDisciplina(Disciplina disciplina) {
			this.disciplina.add(disciplina);
		}
		
		public void addUsuario(Usuario u) {
			this.usuario.add(u);
		}
		public Set<Usuario> getUsuario() {
			return usuario;
		}
		public void setUsuario(Set<Usuario> usuario) {
			this.usuario = usuario;
		}
		
		
	}