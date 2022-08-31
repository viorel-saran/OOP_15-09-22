package it.univpm.TicketMasterEventsApp.exceptions;

/**Metodo che gestisce le chiamate alle relative rotte
 * @author Luca Marziliano
 * @author Viorel Saran
 */

public class NoCountryFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoCountryFoundException() {
		super("Errore: paese non rilevato...");		
	}
	
	public String noCountryFoundError() {
		return("Errore:\n E' necessario inserire un paese europeo valido in lingua italiana...");
	}
	
}
