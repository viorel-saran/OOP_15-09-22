package it.univpm.TicketMasterEventsApp.model;

import org.json.simple.JSONObject;


/**Classe  che modella un evento.
 * @author Luca Marziliano
 * @author Viorel Saran
 */
public class Events{
	
	private String nomeEvento;
	private String genereEvento;			
	private String dataDelEvento;
	private String countryEvento;
	private String countryCode;
	
	
	/**
	 * Costruttore dell'oggetto	con contatore di istanziamento 
	 * @param nomeEvento
	 * @param dataDelEvento
	 * @param countryEvento
	 * @param countryCode
	 * @param genereEvento	 
	 */
	public Events( String countryCode, String nomeEvento,String genereEvento,
			       String dataDelEvento,String countryEvento) {
		
		this.nomeEvento=nomeEvento;
		this.genereEvento=genereEvento;			
		this.dataDelEvento=dataDelEvento;
		this.countryEvento=countryEvento;	
		this.countryCode=countryCode;
		
	}
	
	
	/**
	 * Metodo che restituisce il countryCode
	 * @return countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * Metodo che setta il contryCode dell'evento
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * Metodo che restituisce il nome dell'evento
	 * @return nomeEvento
	 */
	public String getNomeEvento() {
		return nomeEvento;
	}
	/**
	 * Metodo che setta il nome dell'evento
	 * @param nomeEvento
	 */
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	/**
	 * Metodo che restituisce il genere dell'evento
	 * @return genereEvento
	 */
	public String getGenereEvento() {
		return genereEvento;
	}
	/**
	 * Metodo che setta il genere dell'evento
	 * @param genereEvento
	 */
	public void setGenereEvento(String genereEvento) {
		this.genereEvento = genereEvento;
	}
	/**
	 * Metodo che restituisce la data dell'evento
	 * @return dataDelEvento
	 */
	public String getDataDelEvento() {
		return dataDelEvento;
	}
	/**
	 * Metodo che setta la data dell'evento
	 * @param dataDelEvento
	 */
	public void setDataDelEvento(String dataDelEvento) {
		this.dataDelEvento = dataDelEvento;
	}
	/**
	 * Metodo che restituisce il paese dell'evento
	 * @return countryEvento
	 */
	public String getCountryEvento() {
		return countryEvento;
	}
	/**
	 * Metodo che setta il paese dell'evento
	 * @param countryEvento
	 */
	public void setCountryEvento(String countryEvento) {
		this.countryEvento = countryEvento;
	}			
	
	/**
	 * Metodo che restituisce l'evento in formato JSONObject
	 * @return eventJSON
	 */
	public JSONObject toJSONObject() {
		JSONObject eventJSON= new JSONObject();
		eventJSON.put("CountryCode", countryCode);
		eventJSON.put("Nome", nomeEvento);
		eventJSON.put("Data", dataDelEvento);
		eventJSON.put("Genere", genereEvento);
		eventJSON.put("Stato", countryEvento);
		return eventJSON;
	}
}
