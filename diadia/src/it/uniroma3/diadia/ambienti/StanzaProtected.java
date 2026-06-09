package it.uniroma3.diadia.ambienti;

import java.util.*;
import java.util.Map.Entry;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	protected String nome;
	protected List<Attrezzo> attrezzi;
	protected Map<String,StanzaProtected> stanzeAdiacenti;
	
	public Map<String, StanzaProtected> getStanzeAdiacenti() {
		return stanzeAdiacenti;
	}

	public void setStanzeAdiacenti(Map<String, StanzaProtected> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}

	public StanzaProtected(String nome) {
		this.nome = nome;
		this.attrezzi = new ArrayList<>(NUMERO_MASSIMO_ATTREZZI);
		this.stanzeAdiacenti = new HashMap<>();
	}
	
	public StanzaProtected getStanza() {
		return this;
	}

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI - this.attrezzi.size();
	}

	public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
		if(this.stanzeAdiacenti.size() < NUMERO_MASSIMO_DIREZIONI)
			this.stanzeAdiacenti.put(direzione, stanza);
	}

	public StanzaProtected getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	public String getAllStanzeAdiacenti() {
		StringBuilder stanza = new StringBuilder();
		for (Entry<String, StanzaProtected> entry : this.stanzeAdiacenti.entrySet()) 
			stanza.append(entry.getValue() + "Direzione: " + entry.getKey() + "\n");
		return stanza.toString();
	}

	public String getNome() {
		return this.nome;
	}
	
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}
	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	public List<String> getDirezioni() {
		final List<String> listaDirezioni= new ArrayList<>();
		listaDirezioni.addAll(this.stanzeAdiacenti.keySet());
		return listaDirezioni;
	}
	
	public Map<String,StanzaProtected> getMapStanzeAdiacenti() {
		return this.stanzeAdiacenti;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(this.isEmpty())
			return null;

		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			Attrezzo a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);
	}

	public boolean removeAttrezzo(String attrezzo) {
		Attrezzo rimosso = this.getAttrezzo(attrezzo);
		if(rimosso == null)
			return false;

		return this.attrezzi.remove(rimosso);
	}

	public String getDescrizione() {
		return this.toString();
	}

	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);

		risultato.append("\nUscite: ");
		for (Entry<String,StanzaProtected> entry: this.stanzeAdiacenti.entrySet())
			risultato.append("\n" + entry.getKey());

		risultato.append("\nAttrezzi nella stanza: ");
		if(!this.isEmpty()) 
			for (Attrezzo a : this.attrezzi) {
				risultato.append(a.getDescrizione()+" ");
			}
		else
			risultato.append("Non ci sono attrezzi nella stanza\n");
		return risultato.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StanzaProtected that = (StanzaProtected) obj;
		return this.getNome().equals(that.getNome());
	}

}