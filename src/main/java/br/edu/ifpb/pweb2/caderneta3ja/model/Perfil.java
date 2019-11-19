package br.edu.ifpb.pweb2.caderneta3ja.model;



public enum Perfil {
	
	ALUNO("Aluno"),
	COORDENADOR("Coordenador"),
	PROFESSOR("Professor");
	
	private String nome;
	
	Perfil(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
