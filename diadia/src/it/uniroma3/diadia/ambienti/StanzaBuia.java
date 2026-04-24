package it.uniroma3.diadia.ambienti;

/**
 * Classe StanzaBuia - una stanza che appare scura a meno che 
 * non sia presente un attrezzo specifico (es. lanterna).
 */
public class StanzaBuia extends Stanza {

	// Variabile di istanza per memorizzare l'attrezzo necessario
	private String nomeAttrezzoPerVedere;

	/**
	 * Costruttore: imposta il nome della stanza e l'attrezzo necessario per vedere.
	 * @param nome
	 * @param nomeAttrezzoPerVedere
	 */
	public StanzaBuia(String nome, String nomeAttrezzoPerVedere) {
		super(nome); // Richiama il costruttore della classe madre Stanza
		this.nomeAttrezzoPerVedere = nomeAttrezzoPerVedere;
	}

	/**
	 * Sovrascrive getDescrizione() per gestire la visibilità in base all'attrezzo.
	 * @return la descrizione normale o "qui c'è un buio pesto"
	 */
	@Override
	public String getDescrizione() {
		// Verifica se nella stanza è presente l'attrezzo richiesto
		if (this.hasAttrezzo(this.nomeAttrezzoPerVedere)) {
			// Se presente, restituisce la descrizione usuale
			return super.getDescrizione(); 
		} else {
			// Se non presente, restituisce la stringa di buio
			return "qui c'è un buio pesto";
		}
	}
}