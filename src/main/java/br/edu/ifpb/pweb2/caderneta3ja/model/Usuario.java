package br.edu.ifpb.pweb2.caderneta3ja.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_Usuário")
public class Usuario {
	
	private String login;
	private String senha;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PK_PESSOA")
	private Pessoa pessoa;
	
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	public Usuario() {}
	
	public String getLogin() {
		return login;
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
