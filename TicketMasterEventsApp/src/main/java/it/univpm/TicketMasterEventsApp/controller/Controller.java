package it.univpm.TicketMasterEventsApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketMasterEventsApp.service.Downloadevent;
import it.univpm.TicketMasterEventsApp.service.EventService;


@RestController
public class Controller {
	
	@Autowired
	EventService serv;
		
	/**
	 * Metodo che lancia una chiamata di tipo GET 
	 * che ritorna una lista di eventi in base agli stateCodes		 
	 */
	
	@GetMapping("/StatsEvents")	
	public ResponseEntity<Object> statsEUevents() {		
		
		return new ResponseEntity<>(serv.statsEUevents(),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/numEventsEU")	
	public long printNumEvents() {		
		Downloadevent e = new Downloadevent();		
		return e.numEventsAllStates();		
	}


}


