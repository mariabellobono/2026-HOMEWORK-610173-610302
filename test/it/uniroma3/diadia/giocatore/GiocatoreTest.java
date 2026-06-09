package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GiocatoreTest {
	
	private Giocatore player;
	
	@BeforeEach
	public void setUp() {
		this.player = new Giocatore();
	}
	
	@Test
	public void testNome() {
		this.player.setNome("Franco");
		assertEquals("Franco", this.player.getNome());
	}
	
	@Test
	public void testCfu() {
		this.player.setCfu(20);
		assertEquals(20, this.player.getCfu());
	}
	
	@Test
	public void testRemoveCfu() {
		this.player.setCfu(20);
		this.player.removeCfu();
		assertEquals(19, this.player.getCfu());
	}
	
	@Test
	public void testAddCfu() {
		this.player.setCfu(20);
		this.player.addCfu();
		assertEquals(21, this.player.getCfu());
	}
	
	@Test
	public void testBorsa() {
		Borsa borsa = new Borsa();
		this.player.setBorsa(borsa);
		assertEquals(borsa, this.player.getBorsa());
	}
	
}