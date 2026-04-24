package it.uniroma3.diadia.ambienti;

/**
 * Classe StanzaBloccata - una stanza dove un'uscita è inaccessibile
 * finché non viene posato un attrezzo specifico (es. 'piedediporco').
 */
public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String nomeAttrezzoSbloccante;

	/**
	 * Costruttore: imposta nome, direzione e attrezzo sbloccante.
	 * @param nome - nome della stanza
	 * @param direzioneBloccata - la direzione che inizialmente è chiusa
	 * @param nomeAttrezzoSbloccante - l'attrezzo necessario per aprirla
	 */
	public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.nomeAttrezzoSbloccante = nomeAttrezzoSbloccante;
	}

	/**
	 * Restituisce la stanza adiacente solo se l'uscita non è bloccata 
	 * o se l'attrezzo sbloccante è presente nella stanza.
	 */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
			return this; // Ritorna la stanza stessa: il giocatore non si muove
		}
		return super.getStanzaAdiacente(direzione);
	}

	/**
	 * Sovrascrive getDescrizione per aggiungere informazioni sul blocco.
	 * @return la descrizione completa della stanza e dello stato del blocco.
	 */
	@Override
	public String getDescrizione() {
		String descrizioneBase = super.getDescrizione();
		
		if (!this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
			// Messaggio specifico se la direzione è ancora bloccata
			return descrizioneBase + "\nATTENZIONE: L'uscita a " + this.direzioneBloccata + 
					" è bloccata! Sembra che serva un '" + this.nomeAttrezzoSbloccante + "' per aprirla.";
		} else {
			// Messaggio se l'uscita è stata sbloccata
			return descrizioneBase + "\nL'uscita a " + this.direzioneBloccata + 
					" è stata sbloccata grazie alla presenza di: " + this.nomeAttrezzoSbloccante;
		}
	}
}