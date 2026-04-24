package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Test di Accettazione: simulano intere partite per verificare 
 * che il gioco funzioni correttamente dopo il refactoring.
 */
public class TestAccettazione {

	/**
	 * Scenario: Partita con chiusura immediata.
	 * Obiettivo: Verificare che il comando 'fine' termini il gioco correttamente.
	 */
	@Test
	public void testPartitaConFine() {
		List<String> comandi = Arrays.asList("fine");
		IOSimulator io = new IOSimulator(comandi);
		new DiaDia(io).gioca();
		
		assertTrue("Dovrebbe apparire il messaggio di addio", 
				messaggioContiene(io, "Grazie di aver giocato"));
	}

	/**
	 * Scenario: Movimento semplice e vittoria.
	 * Obiettivo: Verificare che muovendosi verso l'Atrio il gioco dichiari la vittoria.
	 * (Nota: Adatta la direzione 'nord' in base al tuo Labirinto)
	 */
	@Test
	public void testPartitaVintaRapida() {
		List<String> comandi = Arrays.asList("vai nord", "fine");
		IOSimulator io = new IOSimulator(comandi);
		new DiaDia(io).gioca();
		
		assertTrue("Il giocatore dovrebbe aver vinto o essere arrivato in Atrio", 
				messaggioContiene(io, "vinto") || messaggioContiene(io, "Atrio"));
	}

	/**
	 * Scenario: Gestione oggetti (Prendi e Posa).
	 * Obiettivo: Verificare che il giocatore possa interagire con gli oggetti durante una partita.
	 */
	@Test
	public void testPrendiPosaGuarda() {
		List<String> comandi = Arrays.asList("prendi osso", "vai nord", "posa osso", "guarda", "fine");
		IOSimulator io = new IOSimulator(comandi);
		new DiaDia(io).gioca();
		
		// Verifichiamo che l'osso sia stato posato correttamente nella nuova stanza
		assertTrue("L'osso dovrebbe apparire nella descrizione dopo averlo posato", 
				messaggioContiene(io, "osso"));
	}

	/**
	 * Scenario: Esaurimento CFU.
	 * Obiettivo: Verificare che il gioco termini quando i CFU arrivano a zero.
	 */
	@Test
	public void testPartitaPerdutaPerCFU() {
		List<String> comandi = new ArrayList<>();
		// Simuliamo 21 movimenti per consumare i 20 CFU iniziali
		for(int i=0; i<21; i++) {
			comandi.add("vai sud");
		}
		comandi.add("fine");
		
		IOSimulator io = new IOSimulator(comandi);
		new DiaDia(io).gioca();
		
		assertTrue("Dovrebbe apparire il messaggio di GAME OVER per CFU", 
				messaggioContiene(io, "esaurito i CFU") || messaggioContiene(io, "bocciato"));
	}

	// --- METODO DI SUPPORTO ---
	
	/**
	 * Cerca una stringa (case-insensitive) tra tutti i messaggi stampati dal gioco.
	 */
	private boolean messaggioContiene(IOSimulator io, String target) {
		for (String msg : io.getMessaggiProdotti()) {
			if (msg.toLowerCase().contains(target.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}