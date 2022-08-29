package it.univpm.TicketMasterEventsApp.model;

import java.util.Set;

public class Events{
	
	private String nomeEvento;
	private String genereEvento;			
	private String dataDelEvento;
	private String countryEvento;
	private String countryCode;
	
	public Events( String countryCode, String nomeEvento,String genereEvento,
			       String dataDelEvento,String countryEvento) {
		
		this.nomeEvento=nomeEvento;
		this.genereEvento=genereEvento;			
		this.dataDelEvento=dataDelEvento;
		this.countryEvento=countryEvento;	
		this.countryCode=countryCode;
	}
	

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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
	
	
	public String toString() {
		return "Eventi: [countryCode= "+countryCode+",  name= "+nomeEvento+",  data= "+dataDelEvento+",  genere= "+genereEvento+",  paese= "+countryEvento+"]";
	}
}
