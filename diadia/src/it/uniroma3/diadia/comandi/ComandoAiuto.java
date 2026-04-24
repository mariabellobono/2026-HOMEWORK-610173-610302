package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
    
    // Spostiamo qui l'elenco dei comandi che prima era in DiaDia
    static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};

    @Override
    public void esegui(Partita partita) {
        for(int i = 0; i < elencoComandi.length; i++) {
            System.out.print(elencoComandi[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void setParametro(String parametro) {
        // Il comando 'aiuto' non richiede parametri, quindi il corpo del metodo è vuoto
    }
}