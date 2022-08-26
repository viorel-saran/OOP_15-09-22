package it.univpm.TicketMasterEventsApp.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class EventServiceIMPL implements EventService {

	public  JSONObject statsEUevents() {
		
		Downloadevent e = new Downloadevent();
		
		
		
		return null;		
		};
	
	
	
	
	public  JSONArray filterCountryEvents(String countryCode) {return null;};
	public  JSONArray filterGenreEvents(String genere) {return null;};
	
	
}
