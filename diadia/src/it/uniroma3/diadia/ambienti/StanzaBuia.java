package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String shinyObject; 

	public StanzaBuia(String nome, String shinyObject) {
		super(nome);
		this.shinyObject = shinyObject;
	}

	public String getOggettoLucente() {
		return shinyObject;
	}

	@Override
	public String toString() {
		if(this.shinyObject == null || this.hasAttrezzo(shinyObject))
			return super.toString();
		
		return "Qui c'è un buio pesto";
	}

	@Override
	public String getDescrizione() {
		return this.toString();
	}
	
}