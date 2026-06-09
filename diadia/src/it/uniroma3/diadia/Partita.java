package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Partita {

	static final private int CFU_INIZIALI = 20;
	private Giocatore giocatore;
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private boolean finita;
	
	public Partita(Labirinto labirinto) {
		this.labirinto = labirinto;
		this.stanzaCorrente = this.labirinto.getStanzaCorrente();
		this.finita = false;
		this.giocatore = new Giocatore();
		this.giocatore.setCfu(CFU_INIZIALI);
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public boolean vinta() {
		return this.stanzaCorrente == this.labirinto.getStanzaVincente();
	}

	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	public void setFinita() {
		this.finita = true;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}
	
	public Labirinto getLabirinto() {
		return labirinto;
	}

	public boolean giocatoreIsVivo() {
		return true;
	}
	
}