package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
    private String nomeAttrezzo;

    @Override
    public void esegui(Partita partita) {
        if (nomeAttrezzo == null) {
            System.out.println("Cosa vuoi posare?");
            return;
        }

        Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
        
        if (attrezzo != null) {
            if (partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo)) {
                partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
                System.out.println("Hai posato: " + nomeAttrezzo);
            } else {
                System.out.println("Non c'è spazio nella stanza per posare questo attrezzo!");
            }
        } else {
            System.out.println("Non hai questo attrezzo nella borsa.");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
    
    @Override
    public String getNome() {
        return "posa";
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }
}
