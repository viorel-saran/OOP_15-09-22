package it.univpm.TicketMasterEventsApp.controller;


import it.univpm.TicketMasterEventsApp.service.Downloadevent;

import org.json.simple.JSONArray;

import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
	
		
	/**
	 * Metodo che lancia una chiamata di tipo GET 
	 * che ritorna una lista di eventi in base agli stateCodes		 
	 */
	@GetMapping("/allEventsEU")	
	public JSONArray printEvents() {
		
		Downloadevent e = new Downloadevent();
		
		return e.EventsAllStates();		
	}


}


