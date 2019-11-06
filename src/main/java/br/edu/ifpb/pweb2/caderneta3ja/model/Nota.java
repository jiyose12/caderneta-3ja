package br.edu.ifpb.pweb2.caderneta3ja.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_Nota")
public class Nota {
	
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private ArrayList<Integer> notas;
	private int numNotas;
	
	
	//Construtores
	public Nota() {
		this.notas = new ArrayList<Integer>();
	}

	public Nota(int numNotas) {
		this.notas = new ArrayList<Integer>();
		this.numNotas = numNotas;
	}
	//Métodos
	public ArrayList<Integer> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Integer> notas) {
		this.notas = notas;
	}
	public int getNumNotas() {
		return numNotas;
	}
	public void setNumNotas(int numNotas) {
		this.numNotas = numNotas;
	}
	
	public void addNota(int nota) {
		this.notas.add(nota);
	}
	
	
	
	
	
}
