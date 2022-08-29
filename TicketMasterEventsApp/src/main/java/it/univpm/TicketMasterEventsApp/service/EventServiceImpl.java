package it.univpm.TicketMasterEventsApp.service;
import it.univpm.TicketMasterEventsApp.model.Events;
import it.univpm.TicketMasterEventsApp.service.Downloadevent;
import it.univpm.TicketMasterEventsApp.utils.*;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

	public  JSONArray statsEUevents() {
		
		Downloadevent e = new Downloadevent();
		e.eventsAllStates();//prendo eventi dalla api response
		Set<Events> eventsOBJs=e.initializeEvents();//istanzio oggetti event
		long numeroEventiTotale= e.numEventsAllStates();//prendo numero eventi totali in eu dalla api response 
		
		JSONArray statsALL = new JSONArray();		
		
		JSONObject numeroEventiTot = new JSONObject();
		numeroEventiTot.put("Numero eventi totali in europa", numeroEventiTotale);
		
		JSONObject numeroEventiRaggruppatiPerGenere = new JSONObject();
		numeroEventiRaggruppatiPerGenere.put("Numero eventi ragruppati per genere", Stats.getEventiPerGenere(eventsOBJs));//deve restituire un jsonobject
		
		
		JSONObject numeroMinMaxMedEventi = new JSONObject();
		numeroMinMaxMedEventi.put("Statistiche per eventi mensili", Stats.getMinMaxMedEventi(eventsOBJs));//deve restituire un jsonobject
		
		
		statsALL.add(numeroEventiTot);
		statsALL.add(numeroEventiRaggruppatiPerGenere);
		statsALL.add(numeroMinMaxMedEventi);
		return statsALL;		
		};
	
	
	
	
	public  JSONArray filterEventsPerCountry(String countryCode) {return null;};
	public  JSONArray filterEventsPerGenre(String genere) {return null;};
	
	
}
