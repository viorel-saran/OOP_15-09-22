package it.univpm.TicketMasterEventsApp.exceptions;

/**Metodo che gestisce le chiamate alle relative rotte
 * @author Luca Marziliano
 * @author Viorel Saran
 */

public class NoGenreFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoGenreFoundException() {
		super("Errore: genere non rilevato...");		
	}
	
	public String NoGenreFoundExceptionError() {
		return("Errore:\n I generi consentiti sono: \n\n film,\n arte,\n teatro,\n sport,\n musica,\n arte e teatro,\n altro");
	}

}
