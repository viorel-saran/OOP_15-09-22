package it.univpm.TicketMasterEventsApp.utils;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.univpm.TicketMasterEventsApp.exceptions.NoCountryFoundException;
import it.univpm.TicketMasterEventsApp.exceptions.NoGenreFoundException;
import it.univpm.TicketMasterEventsApp.model.Events;


public class Filters {
	
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
