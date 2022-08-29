package it.univpm.TicketMasterEventsApp.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface EventService {
	
	public abstract JSONArray statsEUevents();
	public abstract JSONArray filterCountryEvents(String countryCode) /*throws noCountryFoundException*/;
	public abstract JSONArray filterGenreEvents(String genere);

}
