package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Una stanza magica modifica gli attrezzi posati dopo che è stata
 * superata una certa soglia di attrezzi posati.
 */
public class StanzaMagica extends Stanza {

	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	private static final int SOGLIA_DEFAULT = 3;

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_DEFAULT);
	}

	public StanzaMagica(String nome, int soglia) {
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
		// Uso il metodo della madre perché l'array attrezzi è privato
		return super.addAttrezzo(attrezzo);
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		// Inverte il nome
		StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
		String nomeMagico = nomeInvertito.reverse().toString();
		// Raddoppia il peso
		int pesoMagico = attrezzo.getPeso() * 2;
		return new Attrezzo(nomeMagico, pesoMagico);
	}
}
