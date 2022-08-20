package it.univpm.TicketMasterEventsApp.model;

public class Events {
	
	

	private String nome;
	private String genere;
	private String stato;
	private String regione;
	private String data;
	
	public Events(String nome, String genere, String stato , String regione, String data) {
		this.nome=nome;
		this.genere=genere;
		this.stato=stato;
		this.regione=regione;
		this.data=data;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}


