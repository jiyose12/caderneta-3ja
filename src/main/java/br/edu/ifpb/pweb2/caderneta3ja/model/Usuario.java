package br.edu.ifpb.pweb2.caderneta3ja.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="usuario")
public class Usuario {

	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message="Campo nome é obrigatório")
	private String nome;
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message= "Digite um email valido. Exemplo: teste@gmail.com")
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
	 private List<Frequencia> frequencia;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Nota> notas;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Disciplina> disciplinas;

	@ManyToMany
	@JoinTable(
			name = "turma_usuario", 
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "turma_id"))
	Set<Turma> turmausuario;
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
	
	public void setTurmaUsuario(Turma t) {
		this.turmausuario.add(t);
	}
	
	public void setDisciplinaUsuario(Disciplina d) {
		this.disciplinas.add(d);
	}


	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}


	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}


	public List<Frequencia> getFrequencia() {
		return frequencia;
	}


	public void setFrequencia(Frequencia frequencia) {
		this.frequencia.add(frequencia);
	}


	public Set<Turma> getTurmausuario() {
		return turmausuario;
	}

}