package it.univpm.TicketMasterEventsApp.service;

import org.json.simple.JSONArray;
import it.univpm.TicketMasterEventsApp.exceptions.*;

/**Interfaccia che contiene i metodi chiamati dal Controller
 * @author Luca Marziliano
 * @author Viorel Saran
 */
public interface EventService {
	
	public abstract JSONArray statsEUevents();
	public abstract JSONArray filterEventsPerCountry(String countryCode) throws NoCountryFoundException, NoEventsFoundException;
	public abstract JSONArray filterEventsPerGenre(String genere) throws NoGenreFoundException, NoEventsFoundException;

}
