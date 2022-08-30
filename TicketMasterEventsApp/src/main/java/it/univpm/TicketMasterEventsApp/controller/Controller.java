package it.univpm.TicketMasterEventsApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketMasterEventsApp.exceptions.*;
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
	
	
	@GetMapping("/FilterByCountry/{paese}")	
	public ResponseEntity<Object> getEventsByCountry(@PathVariable(name="paese") String paese) throws NoCountryFoundException, NoEventsFoundException {		
				
		return new ResponseEntity<>(serv.filterEventsPerCountry(paese),HttpStatus.OK);	
		
	}
	@ExceptionHandler(NoCountryFoundException.class)
	public ResponseEntity<Object> handleIOException(NoCountryFoundException err){
		return new ResponseEntity<> (err.NoCountryFoundError(),HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/FilterByGenre/{genere}")	
	public ResponseEntity<Object> getEventsBygenre(@PathVariable(name="genere") String genere) throws NoGenreFoundException, NoEventsFoundException {		
				
		return new ResponseEntity<>(serv.filterEventsPerGenre(genere),HttpStatus.OK);	
		
	}
	@ExceptionHandler(NoGenreFoundException.class)
	public ResponseEntity<Object> handleIOException(NoGenreFoundException err){
		return new ResponseEntity<> (err.NoGenreFoundExceptionError(),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(NoEventsFoundException.class)
	public ResponseEntity<Object> handleIOException(NoEventsFoundException err){
		return new ResponseEntity<> (err.noEventsFoundExceptionError(),HttpStatus.BAD_REQUEST);
		
	}


}


