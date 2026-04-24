package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test per la verifica del corretto riconoscimento dei comandi.
 */
public class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandiFisarmonica factory;

    @Before
    public void setUp() {
        this.factory = new FabbricaDiComandiFisarmonica();
    }

    @Test
    public void testCostruisciComandoVaiConParametro() {
        Comando comando = this.factory.costruisciComando("vai nord");
        // Verifica del riconoscimento del nome
        assertEquals("vai", comando.getNome());
        // Verifica del riconoscimento del parametro
        assertEquals("nord", comando.getParametro());
    }

    @Test
    public void testCostruisciComandoSenzaParametro() {
        Comando comando = this.factory.costruisciComando("aiuto");
        assertEquals("aiuto", comando.getNome());
        assertNull(comando.getParametro());
    }

    @Test
    public void testCostruisciComandoInesistente() {
        Comando comando = this.factory.costruisciComando("vola");
        // ComandoNonValido dovrebbe restituire null come nome o un nome specifico
        // a seconda della tua implementazione
        assertNull(comando.getNome());
    }

    @Test
    public void testCostruisciComandoStringaVuota() {
        Comando comando = this.factory.costruisciComando("");
        assertNull(comando.getNome());
    }
}