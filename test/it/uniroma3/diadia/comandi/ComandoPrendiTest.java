
package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

    private Partita partita;
    private Comando comando;

    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoPrendi();
    }

    @Test
    public void testAttrezzoPresoDallaStanza() {
        Attrezzo attrezzo = new Attrezzo("martello", 1);
        partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
        comando.setParametro("martello");
        comando.esegui(partita);
        // Verifico che l'attrezzo non sia più nella stanza 
        assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
    }

    @Test
    public void testAttrezzoFinitoInBorsa() {
        Attrezzo attrezzo = new Attrezzo("chiave", 1);
        partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
        comando.setParametro("chiave");
        comando.esegui(partita);
        // Verifico che l'attrezzo sia nella borsa del giocatore 
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
    }
}
