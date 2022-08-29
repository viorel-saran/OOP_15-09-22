package it.univpm.TicketMasterEventsApp.utils;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.univpm.TicketMasterEventsApp.model.Events;


public class Filters {
	
	public static JSONArray getEventsByCountry(List<Events> eventi,String countryCode) {
		
		JSONArray countryFiltered= new JSONArray();
		
		
		for(Events e: eventi) {
			if (e.getCountryCode().equalsIgnoreCase(countryCode)) {
				
				JSONObject currentEvent= e.toJSONObject();
				countryFiltered.add(currentEvent);
				
				
			}
			
		}		
		
		return  countryFiltered;
		
	}

}
