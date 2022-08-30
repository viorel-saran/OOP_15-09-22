package it.univpm.TicketMasterEventsApp.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.univpm.TicketMasterEventsApp.exceptions.*;



public interface EventService {
	
	public abstract JSONArray statsEUevents();
	public abstract JSONArray filterEventsPerCountry(String countryCode) throws NoCountryFoundException, NoEventsFoundException; /*throws noCountryFoundException*/;
	public abstract JSONArray filterEventsPerGenre(String genere) throws NoGenreFoundException, NoEventsFoundException;

}
