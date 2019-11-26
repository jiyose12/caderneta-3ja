package br.edu.ifpb.pweb2.caderneta3ja.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="nota")
public class Nota {
	
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int nota;
	
	@ManyToOne
	@JoinColumn(name = "nota_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;
	
	
	//Construtores
	public Nota() {
		
	}
	


	public Nota(int id, int nota) {
		
		this.id = id;
		this.nota = nota;
	}
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	

	
	
	
	
}
