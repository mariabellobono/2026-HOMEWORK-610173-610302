package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
    private String nomeAttrezzo;

    @Override
    public void esegui(Partita partita) {
        if (nomeAttrezzo == null) {
            System.out.println("Cosa vuoi prendere?");
            return;
        }

        Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
        
        if (attrezzo != null) {
            if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
                System.out.println("Hai preso: " + nomeAttrezzo);
            } else {
                System.out.println("Borsa piena! Non puoi prendere altro.");
            }
        } else {
            System.out.println("L'attrezzo '" + nomeAttrezzo + "' non è in questa stanza.");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
}
