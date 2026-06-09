package it.uniroma3.diadia.giocatore;

import java.util.*;
import it.uniroma3.diadia.attrezzi.*;

public class Borsa{

	public final static int DEFAULT_PESO_MAX_BORSA = 10;//peso massimo della borsa

	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) 
			return false;
		if(this.attrezzi.contains(attrezzo))
			return false;
		return this.attrezzi.add(attrezzo);
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();

		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iter = this.attrezzi.iterator();
		while(iter.hasNext())
			peso += iter.next().getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String attrezzo) {
		Attrezzo rimosso = this.getAttrezzo(attrezzo);
		if (rimosso == null)
			return null;
		if(this.attrezzi.remove(rimosso))
			return rimosso;
		return null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if(this.isEmpty())
			s.append("Borsa vuota");
		else {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			List<Attrezzo> attrezziOrdinati = new ArrayList<>();
			if(this.getPeso() == this.getPesoMax()) 
				attrezziOrdinati.addAll(this.getContenutoOrdinatoPerPeso());
			else
				attrezziOrdinati.addAll(this.getContenutoOrdinatoPerNome());
			Iterator<Attrezzo> iter = attrezziOrdinati.iterator();
			while(iter.hasNext()) 
				s.append(iter.next().toString() + " ");
		}
		return s.toString();
	}

	public String getDescrizione() {
		return this.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso()	{
		final List<Attrezzo> ordinato = new ArrayList<>(this.attrezzi);
		final ComparatoreAttrezzoPerPeso cmp = new ComparatoreAttrezzoPerPeso();
		Collections.sort(ordinato, cmp);
		return ordinato;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		final SortedSet<Attrezzo> ordinato = new TreeSet<>(this.attrezzi);
		return ordinato;
	}

	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		final Map<Integer,Set<Attrezzo>> peso2attrezzi = new HashMap<>();
		for (Attrezzo a : this.attrezzi) {
			if(peso2attrezzi.containsKey(a.getPeso())){
				//questo attrezzo ha un peso che ho già visto
				//pesco il vecchio Set e aggiungo il nuovo arrivato
				final Set<Attrezzo> stessoPeso = peso2attrezzi.get(a.getPeso());
				stessoPeso.add(a);
			}
			else {
				//questo attrezzo ha un peso mai visto
				//creo nuovo Set per ospitare tutti gli attrezzi correnti e futuri con questo peso
				final Set<Attrezzo> nuovoSet = new HashSet<>();
				nuovoSet.add(a);
				peso2attrezzi.put(a.getPeso(), nuovoSet);
			}
		}
		return peso2attrezzi;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		final SortedSet<Attrezzo> ordinato = new TreeSet<>(this.getContenutoOrdinatoPerPeso());
		return ordinato;
	}

	public boolean getPesoRimanente(Attrezzo a) {
		if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
			return true;
		return false; 
	}

}