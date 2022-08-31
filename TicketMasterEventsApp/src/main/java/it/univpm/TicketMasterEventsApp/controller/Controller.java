package it.univpm.TicketMasterEventsApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketMasterEventsApp.exceptions.*;
import it.univpm.TicketMasterEventsApp.service.EventService;

/**Metodo che gestisce le chiamate alle relative rotte
 * @author Luca Marziliano
 * @author Viorel Saran
 */

@RestController
public class Controller {
	
	@Autowired
	EventService serv;			

	/**
	 * Metodo che lancia una chiamata di tipo GET che ritorna un JSONArray con le statistiche relative agli eventi 	  
	 * @return un JSONArray di JSONObject contenente statistiche relativi agli eventi  	 
	 */
	@GetMapping("/StatsEvents")	
	public ResponseEntity<Object> statsEUevents() {				
		return new ResponseEntity<>(serv.statsEUevents(),HttpStatus.OK);
		
	}
	
	/**
	 * Metodo che lancia una chiamata di tipo GET che ritorna una lista di eventi filtrati per paese 	 
	 * @param paese	 
	 * @return un JSONArray contenente gli eventi relativi al paese  
	 * @throws NoCountryFoundException
	 * @throws NoEventsFoundException
	 */
	@GetMapping("/FilterByCountry/{paese}")	
	public ResponseEntity<Object> getEventsByCountry(@PathVariable(name="paese") String paese) throws NoCountryFoundException, NoEventsFoundException {		
				
		return new ResponseEntity<>(serv.filterEventsPerCountry(paese),HttpStatus.OK);	
		
	}
	
	/**
	 * Metodo che gestisce l'eccezione NoCountryFoundException e manda una risposta di tipo bad_request
	 * @param err
	 * @return un messaggio di errore
	 */
	@ExceptionHandler(NoCountryFoundException.class)
	public ResponseEntity<Object> handleIOException(NoCountryFoundException err){
		return new ResponseEntity<> (err.noCountryFoundError(),HttpStatus.BAD_REQUEST);
		
	}
	
	/**
	 * Metodo che lancia una chiamata di tipo GET che ritorna una lista di eventi filtrati per genere 	 
	 * @param genere	 
	 * @return un JSONArray contenente gli eventi relativi al genere  
	 * @throws NoGenreFoundException
	 * @throws NoEventsFoundException
	 */
	@GetMapping("/FilterByGenre/{genere}")	
	public ResponseEntity<Object> getEventsBygenre(@PathVariable(name="genere") String genere) throws NoGenreFoundException, NoEventsFoundException {		
				
		return new ResponseEntity<>(serv.filterEventsPerGenre(genere),HttpStatus.OK);	
		
	}
	
	/**
	 * Metodo che gestisce l'eccezione NoGenreFoundException e manda una risposta di tipo bad_request
	 * @param err
	 * @return un messaggio di errore
	 */
	@ExceptionHandler(NoGenreFoundException.class)
	public ResponseEntity<Object> handleIOException(NoGenreFoundException err){
		return new ResponseEntity<> (err.NoGenreFoundExceptionError(),HttpStatus.BAD_REQUEST);
		
	}
	
	/**
	 * Metodo che gestisce l'eccezione NoEventsFoundException e manda una risposta di tipo bad_request
	 * @param err
	 * @return un messaggio di errore
	 */
	@ExceptionHandler(NoEventsFoundException.class)
	public ResponseEntity<Object> handleIOException(NoEventsFoundException err){
		return new ResponseEntity<> (err.noEventsFoundExceptionError(),HttpStatus.BAD_REQUEST);
		
	}


}


