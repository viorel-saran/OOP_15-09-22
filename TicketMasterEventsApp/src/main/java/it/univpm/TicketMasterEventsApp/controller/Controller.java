package it.univpm.TicketMasterEventsApp.controller;


import it.univpm.TicketMasterEventsApp.model.Events;
import it.univpm.TicketMasterEventsApp.service.Downloadevent;

import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
	
		
	/**
	 * Metodo che lancia una chiamata di tipo GET 
	 * che ritorna una lista di eventi in base agli stateCodes		 
	 */
	@GetMapping("/allEventsEU")	
	public void printEvents() {		
		Downloadevent e = new Downloadevent();		
		 e.initializeEvents();
		int i=0;
		for (Events s : e.eventsOBJs) {
			i++;		    
		}	
		System.out.println(i);
	}
	
	
	@GetMapping("/numEventsEU")	
	public long printNumEvents() {		
		Downloadevent e = new Downloadevent();		
		return e.numEventsAllStates();		
	}


}


