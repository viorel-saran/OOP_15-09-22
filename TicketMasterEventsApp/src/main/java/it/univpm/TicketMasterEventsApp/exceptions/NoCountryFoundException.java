package it.univpm.TicketMasterEventsApp.exceptions;

/**Metodo che lancia un eccezione quando il paese inserito non e' valido
 * @author Luca Marziliano
 * @author Viorel Saran
 */

public class NoCountryFoundException extends Exception {
		
	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore
	 */
	public NoCountryFoundException() {
		super("Errore: paese non rilevato...");		
	}
	
	/**
	 * Metodo passato al controller per la bad request
	 * @return "Errore:\n E' necessario inserire un paese europeo valido in lingua italiana..."  come messaggio
	 */
	public String noCountryFoundError() {
		return("Errore:\n E' necessario inserire un paese europeo valido in lingua italiana...");
	}
	
}
