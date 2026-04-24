
package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;

import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

 /*Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Ristrutturata per utilizzare il polimorfismo e il pattern Factory.
 */
public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io;
	private FabbricaDiComandi factory;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io();
		// La responsabilità di creare i comandi è affidata alla factory [cite: 55, 86]
		this.factory = new FabbricaDiComandiFisarmonica();
	}

	public void gioca() {
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		String istruzione;
		do {
			istruzione = this.io.leggiRiga();
		} while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione utilizzando il polimorfismo[cite: 34, 42].
	 * @return true se l'istruzione termina il gioco, false altrimenti.
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		// La factory costruisce il comando specifico basandosi sulla stringa [cite: 49, 93]
		comandoDaEseguire = factory.costruisciComando(istruzione);
		
		// Esecuzione polimorfa: DiaDia non conosce i dettagli del comando [cite: 42, 57]
		comandoDaEseguire.esegui(this.partita);

		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		}
		
		if (!this.partita.getGiocatore().isVivo()) {
			this.io.mostraMessaggio("Hai esaurito i CFU...");
			return true;
		}
		
		// Ritorna true se il comando ha impostato la partita come finita (es: fine) [cite: 54]
		return this.partita.isFinita();
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		IO io = new IOConsole();
		gioco.gioca();
	}
	
	
}