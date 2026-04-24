
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Versione che accede direttamente ai campi protetti di StanzaProtected.
 */
public class StanzaMagicaProtected extends StanzaProtected {
    
    private int contatoreAttrezziPosati;
    private int sogliaMagica;
    private static final int SOGLIA_DEFAULT = 3;

    public StanzaMagicaProtected(String nome) {
        this(nome, SOGLIA_DEFAULT);
    }

    public StanzaMagicaProtected(String nome, int soglia) {
        super(nome);
        this.contatoreAttrezziPosati = 0;
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.contatoreAttrezziPosati++;
        
        if (this.contatoreAttrezziPosati > this.sogliaMagica) {
            attrezzo = this.modificaAttrezzo(attrezzo);
        }

        // --- ACCESSO DIRETTO (Differenza chiave) ---
        // Qui usiamo 'this.numeroAttrezzi' e 'this.attrezzi' perché sono PROTECTED nella madre.
        // Se fossero stati PRIVATE, qui avresti un errore di compilazione.
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi[this.numeroAttrezzi] = attrezzo;
            this.numeroAttrezzi++;
            return true;
        } else {
            return false;
        }
    }

    private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
        String nomeMagico = nomeInvertito.reverse().toString();
        int pesoMagico = attrezzo.getPeso() * 2;
        return new Attrezzo(nomeMagico, pesoMagico);
    }
}
