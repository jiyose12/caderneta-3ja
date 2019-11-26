package br.edu.ifpb.pweb2.caderneta3ja.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String email;
	private String matricula;
	private String senha;
	@Column(name="TP_PERFIL")
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
//	private boolean UsuarioLogado = false;
	
//	public boolean isUsuarioLogado() {
//		return UsuarioLogado;
//	}
//
//
//	public void setUsuarioLogado(boolean usuarioLogado) {
//		UsuarioLogado = usuarioLogado;
//	}
	

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Nota> notas;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Disciplina> disciplinas;
	
	@ManyToOne
	private Turma turma;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	 private List<Turma> usuarioTurmas;

//	@ManyToMany
//	@JoinTable(
//			name = "turma_usuario", 
//			joinColumns = @JoinColumn(name = "usuario_id"),
//			inverseJoinColumns = @JoinColumn(name = "turma_id"))
//	Set<Turma> turmausuario;
	// Construtores

	public Usuario() {}


	public Usuario(int id, String nome, String email, String matricula, Perfil perfil, String tipo, String senha) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.perfil = perfil;
		this.senha = senha;
	}

	// Métodos getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		matricula = matricula;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public String getSenha() {

		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
//	public void setTurmaUsuario(Turma t) {
//		this.turmausuario.add(t);
//	}
	
	public List<Disciplina> getDisciplinas() {

		return disciplinas;
	}
	
	public void setDisciplinaUsuario(Disciplina d) {
		this.disciplinas.add(d);
	}
	
	public List<Turma> getUsuarioTurmas() {

		return usuarioTurmas;
	}
	
	public void setUsuarioTurmas(Turma t) {
		this.usuarioTurmas.add(t);
	}
	
	public void setNotas(Nota n) {
		this.notas.add(n);
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}


	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	

}