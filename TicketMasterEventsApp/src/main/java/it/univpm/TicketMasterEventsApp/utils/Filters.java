package it.univpm.TicketMasterEventsApp.utils;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.univpm.TicketMasterEventsApp.exceptions.EmptyFieldException;
import it.univpm.TicketMasterEventsApp.exceptions.NoCountryFoundException;
import it.univpm.TicketMasterEventsApp.exceptions.NoGenreFoundException;
import it.univpm.TicketMasterEventsApp.model.Events;

/**classe che gestisce i filtri per genere e per paese
 * @author Luca Marziliano
 * @author Viorel Saran
 */
public class Filters {
	
	
	
	/**
	 * Metodo che scorre gli eventi presi come parametro e li inserisce in un jsonarray in base alla stringa 'paese' passata come parametro
	 * @param eventi
	 * @param paese
	 * @throws NoCountryFoundException
	 * @see {@link Filters#assocciaPaeseACountryCode(String)}
	 * @see Events#getCountryCode()
	 * @see Events#toJSONObject()
	 * @return countryFiltered
	 */
	public static JSONArray getEventsByCountry(List<Events> eventi,String paese) throws NoCountryFoundException {
		
		JSONArray countryFiltered= new JSONArray();
		
		String country = Filters.assocciaPaeseACountryCode(paese);
		for(Events e: eventi) {
			if (e.getCountryCode().equalsIgnoreCase(country)) {
				
				JSONObject currentEvent= e.toJSONObject();
				countryFiltered.add(currentEvent);								
			}
			
		}		
		
		return  countryFiltered;
		
	}

	/**
	 * Metodo che scorre gli eventi presi come parametro e li inserisce in un jsonarray in base alla stringa 'genere' passata come parametro
	 * @param eventi
	 * @param genere
	 * @throws NoGenreFoundException
	 * @see {@link Filters#assocciaGenere(String)}
	 * @see Events#getGenereEvento()
	 * @see Events#toJSONObject()
	 * @return genreFiltered
	 */
    public static JSONArray getEventsByGenre(List<Events> eventi,String genere) throws NoGenreFoundException {
		
		JSONArray genreFiltered= new JSONArray();
		
		String genereSimple=Filters.assocciaGenere(genere);
		for(Events e: eventi) {
			if (e.getGenereEvento().equalsIgnoreCase(genereSimple)) {
				
				JSONObject currentEvent= e.toJSONObject();
				genreFiltered.add(currentEvent);								
			}			
		}				
		return  genreFiltered;		
	}
    
    /**
	 * Metodo che scorre gli eventi presi come parametro e li confronta con i filtri presi da un JSONArray dal parametro "filtriArray" e dopo averli filtrati li inserisce in un JSONArray
	 * che poi viene restituito
	 * @param eventi
	 * @param filtryArray
	 * @throws NoGenreFoundException
	 * @throws NoCountryFoundException
	 * @throws EmptyFieldException
	 * @see {@link Filters#assocciaGenere(String)}
	 * @see {@link Filters#assocciaPaeseACountryCode(String)}
	 * @see Events#getGenereEvento()
	 * @see Events#getCountryCode()
	 * @see Events#toJSONObject()
	 * @return genreAndCountryFiltered
	 */
    public static JSONArray getEventsByGenreAndCountry(List<Events> eventi,JSONArray filtriArray)throws NoGenreFoundException,NoCountryFoundException,EmptyFieldException{
    	JSONArray genreAndCountryFiltered= new JSONArray();
    	for(Object obj: filtriArray) {
    		JSONObject evento= (JSONObject) obj;
    		if(!evento.containsKey("paese")) throw new EmptyFieldException("paese");
    		String paese=(String) evento.get("paese");    		  		
    		if((paese).isEmpty()) throw new NoCountryFoundException();
    		if(!evento.containsKey("genere")) throw new EmptyFieldException("genere");
    		String genere=(String) evento.get("genere");
    		if((genere).isEmpty()) throw new NoGenreFoundException();
    		String genereSimple= Filters.assocciaGenere(genere);
    		String country = Filters.assocciaPaeseACountryCode(paese);
    		for (Events e: eventi) {
    			if (e.getGenereEvento().equalsIgnoreCase(genereSimple)&&e.getCountryCode().equalsIgnoreCase(country)) {
    				
    				JSONObject currentEvent= e.toJSONObject();
    				genreAndCountryFiltered.add(currentEvent);								
    			}
    			
    		}
    		
    	}
    	return genreAndCountryFiltered;
    }
    
    /**
	 * Metodo che assoccia il paramentro String 'paese' al countryCode relativo	 
	 * @param paese
	 * @throws NoCountryFoundException	 
	 * @return countryCode
	 */
    public static String assocciaPaeseACountryCode(String paese) throws NoCountryFoundException {
    	String countryCode = "";
    	String country = paese.toLowerCase();
    	switch(country){
    	case "italia": countryCode="IT";break;                                                       
    	case "germania":countryCode="DE";break;
    	case "francia":countryCode="FR";break;
    	case "turchia":countryCode="TR";break;
    	case "irlanda":countryCode="IE";break;
    	case "svizzera":countryCode="CH";break;
    	case "svezia":countryCode="SE";break;
    	case "austria":countryCode="AT";break;  	
    	case "andorra":countryCode="ad";break;
    	case "belgio":countryCode="be";break;
    	case "repubblica ceca":countryCode="CZ";break;
    	case "bulgaria":countryCode="bg";break;
    	case "croazia":countryCode="hr";break;
    	case "cipro":countryCode="cy";break;
    	case "finlandia":countryCode="fi";break;
    	case "danimarca":countryCode="dk";break;
    	case "estonia":countryCode="ee";break;
    	case "isole faroe":countryCode="fo";break;
    	case "gibilterra":countryCode="gi";break;
    	case "regno unito":countryCode="uk";break;
    	case "grecia":countryCode="gr";break;
    	case "ungheria":countryCode="hu";break;
    	case "islanda":countryCode="is";break;
    	case "ucraina":countryCode="ua";break;
    	case "lussemburgo":countryCode="lu";break;
    	case "lettonia":countryCode="lv";break;
    	case "lituania":countryCode="lt";break;
    	case "malta":countryCode="mt";break;
    	case "monaco":countryCode="mc";break;
    	case "montenegro":countryCode="me";break;
    	case "paesi bassi":countryCode="nl";break;
    	case "olanda":countryCode="nl";break;
    	case "norvegia":countryCode="no";break;
    	case "polonia":countryCode="pl";break;
    	case "romania":countryCode="ro";break;
    	case "russia":countryCode="ru";break;
    	case "serbia":countryCode="rs";break;
    	case "slovacchia":countryCode="sk";break;
    	case "slovenia":countryCode="si";break;
    	case "spagna":countryCode="es";break;
    	case "portogallo":countryCode="pt";break;
    	default: throw new NoCountryFoundException();
    	}
    	return countryCode;
    }
    
    /**
	 * Metodo che assoccia il paramentro String 'genere' al genere relativo	 
	 * @param genere
	 * @throws NoGenreFoundException	 
	 * @return genereSimple
	 */
    public static String assocciaGenere(String genere) throws NoGenreFoundException{
    	String genereSimple = "";
    	String genereTemp = genere.toLowerCase();
    	switch(genereTemp) {
    	case "sport": genereSimple="Sports";break;
    	case "altro": genereSimple="Miscellaneous";break;
    	case "musica": genereSimple="Music";break;
    	case "film": genereSimple="Film";break;
    	case "arte e teatro": genereSimple="Arts & Theatre";break;
    	case "arte": genereSimple="Arts & Theatre";break;
    	case "teatro": genereSimple="Arts & Theatre";break;
    	default: throw new  NoGenreFoundException();
    	}
    	return genereSimple;
    	}
			
}
