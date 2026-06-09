package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.*;

public class DiaDia {

	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private IO console;
	private Partita partita; 
	private Labirinto labirinto;
	
	public DiaDia(IO console) {
		this.console = console;
	}
	
	public DiaDia(Labirinto labirinto,IO console) {
		this.labirinto = labirinto;
		this.partita = new Partita(this.labirinto);
		this.console = console;
	}

	public void gioca() throws Exception {
		String istruzione; 
		
		this.console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = this.console.leggiRiga();
		}while (!processaIstruzione(istruzione) );

	} 

	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva(this.console);
		
		try {
			comandoDaEseguire = factory.costruisciComando(istruzione);
		} catch (ClassNotFoundException cne) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		} catch (NullPointerException npe) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		}
		
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			this.console.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			this.console.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	} 

	public static void main(String[] argc) throws Exception {
		Scanner scanner = new Scanner(System.in);
		IO console = new IOConsole(scanner);
		Labirinto labirinto = Labirinto.newBuilder("labirinto5.txt").getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, console);
		gioco.gioca();
		scanner.close();
	}

}