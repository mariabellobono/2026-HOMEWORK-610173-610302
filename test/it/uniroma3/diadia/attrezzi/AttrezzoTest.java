package it.uniroma3.diadia.attrezzi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AttrezzoTest {
	
	private Attrezzo attrezzo;	
	
	@BeforeEach
	public void setUp() {
		this.attrezzo = new Attrezzo("osso", 1);
	}
	
	@Test
	public void testGetNome() {
		assertEquals("osso", this.attrezzo.getNome());
	}
	
	@Test
	public void testGetPeso() {
		assertEquals(1, this.attrezzo.getPeso());
	}

}