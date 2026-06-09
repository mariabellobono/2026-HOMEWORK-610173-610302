package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Labirinto labirinto;
	Partita p;
	Stanza s;

	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
//				.addStanzaIniziale("Atrio")
//				.addAttrezzo("martello", 3)
//				.addStanzaVincente("Biblioteca")
//				.addAdiacenza("Atrio", "Biblioteca", "nord")
//				.getLabirinto();
		 p = new Partita(labirinto);
		 s = new Stanza("Stanza");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(s);
		assertEquals(s, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		
		assertFalse(p.isFinita());
	}
	
}
