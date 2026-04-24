package it.uniroma3.diadia.ambienti;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanzaVuota;
	private Stanza stanzaPiena;
	private Attrezzo martello;

	@BeforeEach
	public void setUp() {
		this.stanzaVuota = new Stanza("Vuota");
		this.stanzaPiena = new Stanza("Piena");
		this.martello = new Attrezzo("martello", 1);
		
		this.stanzaPiena.addAttrezzo(martello);
	}
	
	//test addattrezzo
	
	@Test
	public void testAddAttrezzoInStanzaVuota() {
		assertTrue(this.stanzaVuota.addAttrezzo(new Attrezzo("pala", 1)));
	}

	@Test
	public void testAddAttrezzoOltreLimiteMassimo() {
		for(int i=0; i<10; i++) {
			this.stanzaVuota.addAttrezzo(new Attrezzo("attrezzo"+i, 1));
		}
		assertFalse(this.stanzaVuota.addAttrezzo(new Attrezzo("extra", 1)));
	}

	@Test
	public void testAddAttrezzoNull() {
		assertTrue(this.stanzaVuota.addAttrezzo(null));
	}

	//test getattrezzo
	
	@Test
	public void testGetAttrezzoPresente() {
		assertEquals(martello, this.stanzaPiena.getAttrezzo("martello"));
	}

	@Test
	public void testGetAttrezzoNonPresente() {
		assertNull(this.stanzaVuota.getAttrezzo("nonEsisto"));
	}

	@Test
	public void testGetAttrezzoConNomeNull() {
		assertNull(this.stanzaPiena.getAttrezzo(null));
	}

	//test removeattrezzo 

	@Test
	public void testRemoveAttrezzoPresente() {
		assertTrue(this.stanzaPiena.removeAttrezzo("osso"));
	}
	
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		assertFalse(this.stanzaVuota.removeAttrezzo("osso"));
	}

	@Test
	public void testRemoveAttrezzoNull() {
		assertFalse(this.stanzaPiena.removeAttrezzo(null));
	}

	//test stanza adiacente

	@Test
	public void testImpostaStanzaAdiacente() {
		Stanza adiacente = new Stanza("Adiacente");
		this.stanzaVuota.impostaStanzaAdiacente("nord", adiacente);
		assertEquals(adiacente, this.stanzaVuota.getStanzaAdiacente("nord"));
	}

	@Test
	public void testAggiornaStanzaAdiacenteStessaDirezione() {
		Stanza prima = new Stanza("Prima");
		Stanza seconda = new Stanza("Seconda");
		this.stanzaVuota.impostaStanzaAdiacente("nord", prima);
		this.stanzaVuota.impostaStanzaAdiacente("nord", seconda);
		assertEquals(seconda, this.stanzaVuota.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdiacenteInesistente() {
		assertNull(this.stanzaVuota.getStanzaAdiacente("sud"));
	}
}