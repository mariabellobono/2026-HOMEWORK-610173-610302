package it.uniroma3.diadia.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;

	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
	}

	//test partita vinta

	@Test
	public void testVintaInizioPartita() {
		// all'inizio non dovrei aver vinto (parto in atrio, non in biblioteca)
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testVintaSpostandoGiocatoreInStanzaVincente() {
		// stanza corrente uguale a quella vincente per simulare vittoria
		Stanza vincente = this.partita.getLabirinto().getStanzaVincente();
		this.partita.getLabirinto().setStanzaCorrente(vincente);
		assertTrue(this.partita.vinta());
	}

	//test finita

	@Test
	public void testIsFinitaPerCfuZero() {
		// modifico i CFU a 0
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita(), "La partita deve finire se i CFU sono esauriti");
	}

	@Test
	public void testIsFinitaPerSetFinita() {
		// forzo fine partita
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testIsFinitaInizioPartita() {
		//appena creata partita, non deve essere finita
		assertFalse(this.partita.isFinita());
	}
}