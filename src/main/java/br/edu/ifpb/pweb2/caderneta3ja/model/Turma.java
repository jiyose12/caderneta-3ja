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
import javax.persistence.ManyToOne;
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
		
//		 @ManyToMany
//		 Set<Disciplina> disciplina;
		 
//		 @ManyToMany
//		 Set<Usuario> usuario;
		
		@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
		 private List<Usuario> turmaUsuarios;
		
		@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
		 private List<Disciplina> disciplinas;
		 
		@ManyToOne
		private Usuario usuario;
		
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
		public List<Disciplina> getDisciplina() {
			return disciplinas;
		}
		public void setDisciplina(List<Disciplina> disciplina) {
			this.disciplinas = disciplina;
		}
		
		public void addDisciplina(Disciplina disciplina) {
			this.disciplinas.add(disciplina);
		}
		
		public void addTurmaUsuarios(Usuario u) {
			this.turmaUsuarios.add(u);
		}
		
	}