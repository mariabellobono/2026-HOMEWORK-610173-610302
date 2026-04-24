package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo lanterna;

	@Before
	public void setUp() {
		// Creiamo la stanza buia che richiede una lanterna
		this.stanza = new StanzaBuia("Cantina", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 1);
	}

	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		// Senza l'attrezzo deve restituire la stringa fissa di buio
		assertEquals("qui c'è un buio pesto", this.stanza.getDescrizione());
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		// Aggiungiamo l'attrezzo richiesto
		this.stanza.addAttrezzo(lanterna);
		// Ora NON deve più restituire "buio pesto", ma la descrizione completa
		assertNotEquals("qui c'è un buio pesto", this.stanza.getDescrizione());
		assertTrue(this.stanza.getDescrizione().contains("Cantina"));
	}
}