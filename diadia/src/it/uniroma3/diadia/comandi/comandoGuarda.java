package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Stampa le informazioni sulla stanza corrente e sullo stato della partita.
 */
public class ComandoGuarda implements Comando {

    @Override
    public void esegui(Partita partita) {
        // Stampa la descrizione della stanza (nome, attrezzi, uscite)
        System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
        
        // Stampa lo stato del giocatore (CFU rimanenti)
        System.out.println("CFU rimanenti: " + partita.getGiocatore().getCfu());
        
        // Se vuoi, puoi aggiungere anche il contenuto della borsa
        System.out.println(partita.getGiocatore().getBorsa().toString());
    }

    @Override
    public void setParametro(String parametro) {
        // Questo comando non usa parametri (es. scrivi solo "guarda")
        // quindi lasciamo il metodo vuoto come suggerito dal PDF [cite: 281]
    }
}
