
package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

    private Partita partita;
    private Comando comando;

    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoPosa();
    }

    @Test
    public void testAttrezzoPosatoInStanza() {
        Attrezzo attrezzo = new Attrezzo("osso", 1);
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        comando.setParametro("osso");
        comando.esegui(partita);
        // Verifico che la stanza ora contenga l'attrezzo 
        assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("osso"));
    }

    @Test
    public void testAttrezzoRimossoDallaBorsa() {
        Attrezzo attrezzo = new Attrezzo("torcia", 1);
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        comando.setParametro("torcia");
        comando.esegui(partita);
        // Verifico che l'attrezzo non sia più nella borsa 
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("torcia"));
    }
}