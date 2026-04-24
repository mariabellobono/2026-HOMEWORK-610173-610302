package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale del gioco, responsabile del ciclo di controllo.
 * Accetta un'interfaccia IO per permettere il testing automatico.
 *
 * @author docente di POO
 * @version base
 */
public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = "" +
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Un malvagio prorettore ti ha chiuso in questo labirinto di stanze.\n" +
			"Per uscire dovrai riuscire a raggiungere l'Atrio e vincere!\n" +
			"Attento ai CFU: se li esaurisci sarai bocciato a vita!\n" +
			"Scrivi 'aiuto' per vedere l'elenco dei comandi.\n";

	private Partita partita;
	private IO io;

	/**
	 * Costruttore aggiornato: riceve l'oggetto IO dall'esterno.
	 * @param io l'interfaccia di I/O (Console o Simulatore)
	 */
	public DiaDia(IO io) {
		this.io = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa l'istruzione usando la Fabbrica di Comandi e il polimorfismo.
	 * @param istruzione la riga digitata dall'utente
	 * @return vero se la partita e' finita, falso altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("HAI VINTO!");
			return true;
		}
		
		if (!this.partita.getGiocatore().isVivo()) {
			this.io.mostraMessaggio("Hai esaurito i CFU... GAME OVER!");
			return true;
		}
		
		return this.partita.isFinita();
	}

	public static void main(String[] argc) {
		/* Per giocare normalmente usiamo la console */
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}