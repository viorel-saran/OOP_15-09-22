package it.univpm.TicketMasterEventsApp.service;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import it.univpm.TicketMasterEventsApp.exceptions.*;
import it.univpm.TicketMasterEventsApp.model.Events;
import it.univpm.TicketMasterEventsApp.utils.Filters;
import it.univpm.TicketMasterEventsApp.utils.Stats;


/**Classe che gestisce i metodi chiamati dalla classe Controller
 * @author Luca Marziliano
 * @author Viorel Saran
 */

@Service
public class EventServiceImpl implements EventService {
	
	/**Metodo che ritorna un jsonarray di jsonobject contenente le statistiche degli eventi 	
	 * @see Downloadevent#getEventsOBJ()
	 * @see Downloadevent#getInstance()
	 * @see Events#getNumeroEventiIstanziati()
	 * @see Stats#getEventiPerGenere(List<Events>)
	 * @see Stats#getMinMaxMedEventi(List<Events>)	 
	 * @return statsALL
	 */
	public  JSONArray statsEUevents() {
		
		Downloadevent e = Downloadevent.getInstance();		
		List<Events> eventsOBJs=e.getEventsOBJ();
		int numeroEventiTotale = eventsOBJs.size();//prendo numero eventi totali in eu dalla api response 
		
		JSONArray statsALL = new JSONArray();		
		
		JSONObject numeroEventiTot = new JSONObject();
		numeroEventiTot.put("Numero di eventi scaricati", numeroEventiTotale);
		
		JSONObject numeroEventiRaggruppatiPerGenere = new JSONObject();
		numeroEventiRaggruppatiPerGenere.put("Numero eventi ragruppati per genere", Stats.getEventiPerGenere(eventsOBJs));//deve restituire un jsonobject
		
		
		JSONObject numeroMinMaxMedEventi = new JSONObject();
		numeroMinMaxMedEventi.put("Statistiche per eventi mensili", Stats.getMinMaxMedEventi(eventsOBJs));//deve restituire un jsonobject		
		
		statsALL.add(numeroEventiTot);
		statsALL.add(numeroEventiRaggruppatiPerGenere);
		statsALL.add(numeroMinMaxMedEventi);
		return statsALL;		
		};
		
	/**Metodo che ritorna un jsonarray di jsonobject contenente gli eventi relativi al paese 
	 * @param paese
	 * @see Downloadevent#getEventsOBJ()
	 * @see Downloadevent#getInstance()		 
	 * @see Filters#getEventsByCountry(List<Events>,String) 
	 * @return eventsByCountry
	 */
	public  JSONArray filterEventsPerCountry(String paese) throws NoCountryFoundException, NoEventsFoundException {
		
		Downloadevent e = Downloadevent.getInstance();
		List<Events> eventsOBJs=e.getEventsOBJ();
		
		JSONArray eventsByCountry= Filters.getEventsByCountry(eventsOBJs,paese);
			
		if(eventsByCountry.isEmpty()) {throw new NoEventsFoundException();}
		return eventsByCountry;		
		}
		
	
	/**Metodo che ritorna un jsonarray di jsonobject contenente gli eventi relativi al genere 
	 * @param genere
	 * @see Downloadevent#getEventsOBJ()
	 * @see Downloadevent#getInstance()		 
	 * @see Filters#getEventsByGenre(List<Events>,String) 
	 * @return eventsByGenre
	 */	
	public  JSONArray filterEventsPerGenre(String genere) throws NoGenreFoundException, NoEventsFoundException {
		Downloadevent e = Downloadevent.getInstance();
		List<Events> eventsOBJs=e.getEventsOBJ();
		
		JSONArray eventsByGenre= Filters.getEventsByGenre(eventsOBJs,genere);
			
		if(eventsByGenre.isEmpty()) {throw new NoEventsFoundException();}
		return eventsByGenre;
		}		
}
