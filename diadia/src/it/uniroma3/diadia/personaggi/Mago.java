package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!\n";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...\n";
	private static final String MESSAGGIO_REGALO = "Grazie per il regalo, lo modifico e lo poso\n";
	private Attrezzo attrezzo;

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			return MESSAGGIO_DONO;
		}
		return MESSAGGIO_SCUSE;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo == null) 
			return "Non riesco a trovare l'attrezzo\n";
		partita.getStanzaCorrente().addAttrezzo(this.modificaAttrezzo(attrezzo));
		return MESSAGGIO_REGALO;
	}

	public Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		return new Attrezzo(attrezzo.getNome(), attrezzo.getPeso() / 2);
	}

}