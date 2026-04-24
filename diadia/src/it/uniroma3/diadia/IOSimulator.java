package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulatore di IO per testare le partite senza input manuale.
 */
public class IOSimulator implements IO {

	private List<String> righeDaLeggere;    // I comandi che "iniettiamo"
	private List<String> messaggiProdotti; // I messaggi che il gioco stampa
	private int indiceRigaCorrente;

	/**
	 * Costruttore: riceve la lista di comandi da simulare.
	 * @param righeDaLeggere
	 */
	public IOSimulator(List<String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.messaggiProdotti = new ArrayList<>();
		this.indiceRigaCorrente = 0;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		// Invece di stampare a video, conserviamo il messaggio in una lista
		this.messaggiProdotti.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		// Restituisce la riga successiva dalla lista di input simulato
		String riga = this.righeDaLeggere.get(indiceRigaCorrente);
		this.indiceRigaCorrente++;
		return riga;
	}

	/**
	 * Metodo di supporto per i test: permette di recuperare i messaggi stampati.
	 */
	public List<String> getMessaggiProdotti() {
		return messaggiProdotti;
	}
	
	/**
	 * Restituisce l'n-esimo messaggio prodotto dal gioco.
	 */
	public String getMessaggio(int i) {
		return this.messaggiProdotti.get(i);
	}
}