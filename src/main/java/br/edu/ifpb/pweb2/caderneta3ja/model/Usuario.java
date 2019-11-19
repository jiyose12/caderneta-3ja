package br.edu.ifpb.pweb2.caderneta3ja.model;

import java.security.MessageDigest;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.DatatypeConverter;

@Entity
@Table(name="usuario")
public class Usuario {
	
	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String email;
	private String Matricula;
	private String tipo;
	private String senha;
	@Column(name="TP_PERFIL")
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	

	
	
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Nota> notas;
	
	// Construtores
	
	public Usuario() {}


	public Usuario(int id, String nome, String email, String matricula, Perfil perfil, String tipo, String senha) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		Matricula = matricula;
		this.perfil = perfil;
		this.tipo=tipo;
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
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
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


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getSenha() {
		
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	


	
	
}