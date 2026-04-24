package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacente;
	private Attrezzo chiave;

	@Before
	public void setUp() {
		// Stanza bloccata a NORD, sbloccabile con "chiave"
		this.stanzaBloccata = new StanzaBloccata("Ingresso", "nord", "chiave");
		this.stanzaAdiacente = new Stanza("Ufficio");
		this.stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
		this.chiave = new Attrezzo("chiave", 1);
	}

	@Test
	public void testGetStanzaAdiacenteSenzaAttrezzo() {
		// Senza chiave, se chiedo di andare a nord, devo rimanere nella stanza stessa
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdiacenteConAttrezzo() {
		// Posiamo la chiave nella stanza
		this.stanzaBloccata.addAttrezzo(chiave);
		// Ora la direzione deve essere sbloccata e portarmi alla stanza adiacente
		assertEquals(this.stanzaAdiacente, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetDescrizioneBloccata() {
		// Verifichiamo che la descrizione contenga il segnale di blocco
		String desc = this.stanzaBloccata.getDescrizione();
		assertTrue(desc.contains("bloccata"));
		assertTrue(desc.contains("chiave"));
	}
}