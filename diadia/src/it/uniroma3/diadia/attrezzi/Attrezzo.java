package it.uniroma3.diadia.attrezzi;

import java.util.Objects;

public class Attrezzo implements Comparable<Attrezzo> {

	private String nome;
	private int peso;

	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public int getPeso() {
		return this.peso;
	}

	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
	
	public String getDescrizione() {
		return this.toString();
	}

	@Override
	public int compareTo(Attrezzo that) {
		int cmp = this.getNome().compareTo(that.getNome());
		if(cmp == 0)
			cmp  = this.getPeso() - that.getPeso();
		return cmp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attrezzo that = (Attrezzo) obj;
		return this.getNome().equals(that.getNome()) && this.getPeso()==that.getPeso();
	}
	
}