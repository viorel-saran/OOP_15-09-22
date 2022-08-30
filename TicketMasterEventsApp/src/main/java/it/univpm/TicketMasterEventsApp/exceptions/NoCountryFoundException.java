package it.univpm.TicketMasterEventsApp.exceptions;

public class NoCountryFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoCountryFoundException() {
		super("Errore: paese non rilevato...");		
	}
	
	public String NoCountryFoundError() {
		return("Errore:\n E' necessario inserire un paese europeo valido in lingua italiana...");
	}
	
}
