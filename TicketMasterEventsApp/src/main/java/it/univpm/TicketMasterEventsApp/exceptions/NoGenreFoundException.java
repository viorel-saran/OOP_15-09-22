package it.univpm.TicketMasterEventsApp.exceptions;

/**Metodo che lancia un eccezione quando il genere inserito come parametro e' sbagliato
 * @author Luca Marziliano
 * @author Viorel Saran
 */

public class NoGenreFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore
	 */
	public NoGenreFoundException() {
		super("Errore: genere non rilevato...");		
	}
	
	/**
	 * Metodo passato al controller per la bad request
	 * @return "Errore:\n I generi consentiti sono: \n\n film,\n arte,\n teatro,\n sport,\n musica,\n arte e teatro,\n altro"
	 */
	public String NoGenreFoundExceptionError() {
		return("Errore:\n I generi consentiti sono: \n\n film,\n arte,\n teatro,\n sport,\n musica,\n arte e teatro,\n altro");
	}

}
