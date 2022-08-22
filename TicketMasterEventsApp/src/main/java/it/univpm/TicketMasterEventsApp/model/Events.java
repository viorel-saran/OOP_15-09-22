package it.univpm.TicketMasterEventsApp.model;

import java.util.Set;





public class Events{
	private String idEvento;
	private String nomeEvento;
	private String genereEvento;
	
	private String urlEvento;	
	private String dataDelEvento;
	private String countryEvento;
					
	
	public Events( String idEvento,String nomeEvento,String genereEvento,String urlEvento,
			       String dataDelEvento,String countryEvento) {
		this.idEvento=idEvento;
		this.nomeEvento=nomeEvento;
		this.genereEvento=genereEvento;
		this.urlEvento=urlEvento;
		
		this.dataDelEvento=dataDelEvento;
		this.countryEvento=countryEvento;
		
		
	}

	
	public String getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getGenereEvento() {
		return genereEvento;
	}
	public void setGenereEvento(String genereEvento) {
		this.genereEvento = genereEvento;
	}
	public String getUrlEvento() {
		return urlEvento;
	}
	public void setUrlEvento(String urlEvento) {
		this.urlEvento = urlEvento;
	}
	public String getDataDelEvento() {
		return dataDelEvento;
	}
	public void setDataDelEvento(String dataDelEvento) {
		this.dataDelEvento = dataDelEvento;
	}
	public String getCountryEvento() {
		return countryEvento;
	}
	public void setCountryEvento(String countryEvento) {
		this.countryEvento = countryEvento;
	}
	
	
	
}
