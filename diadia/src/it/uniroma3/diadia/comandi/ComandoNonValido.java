package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

    @Override
    public void esegui(Partita partita) {
        System.out.println("Comando sconosciuto.");
    }

    @Override
    public void setParametro(String parametro) {
        // Nulla da fare
    }
    
    @Override
    public String getNome() {
        return null; // Restituisce null per indicare che non è stato riconosciuto
    }

    @Override
    public String getParametro() {
        return null;
    }
}