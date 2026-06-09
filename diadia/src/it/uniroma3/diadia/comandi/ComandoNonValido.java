package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	
	private final static String NOME = "nonValido";
	
	public String getNome(){
		return NOME;
	}

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Comando non valido");
	}	

}