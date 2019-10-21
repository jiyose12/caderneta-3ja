package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_Usuário")
public class Usuario {
	
	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String login;
	private String senha;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PK_PESSOA")
	private Pessoa pessoa;
	
	
	// Construtores
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	public Usuario() {}
	
	
	// Métodos getters e setters
	public String getLogin() {
		return login;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public int getId() {
		return id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
