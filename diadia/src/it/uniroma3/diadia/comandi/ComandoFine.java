package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

    @Override
    public void esegui(Partita partita) {
        System.out.println("Grazie di aver giocato!");
        
        // Comunichiamo all'oggetto partita che il gioco deve finire. 
        // Questo farà sì che il metodo partita.isFinita() in DiaDia restituisca true.
        partita.setFinita(); 
    }

    @Override
    public void setParametro(String parametro) {
        // Anche il comando 'fine' non richiede parametri
    }
}