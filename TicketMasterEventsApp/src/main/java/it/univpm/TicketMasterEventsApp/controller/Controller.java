package it.univpm.TicketMasterEventsApp.controller;

<<<<<<< HEAD
import it.univpm.TicketMasterEventsApp.service.Downloadevent;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
>>>>>>> branch 'main' of https://github.com/viorel-saran/OOP_15-09-22

@RestController

<<<<<<< HEAD
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
=======
	/*
	@PostMapping(value="Europe")
	public ResponseEntity<Object> getNumberEurope(@RequestBody String body){
		
	}*/
>>>>>>> branch 'main' of https://github.com/viorel-saran/OOP_15-09-22
	
}


