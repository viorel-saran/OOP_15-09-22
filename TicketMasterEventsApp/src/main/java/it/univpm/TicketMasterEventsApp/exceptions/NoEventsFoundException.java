package it.univpm.TicketMasterEventsApp.exceptions;

/**Metodo che lancia un eccezione quando la risposta e vuota in base al parametro inserito
 * @author Luca Marziliano
 * @author Viorel Saran
 */

public class NoEventsFoundException extends Exception {

	
		private static final long serialVersionUID = 1L;

		/**
		 * Costruttore
		 */
		public NoEventsFoundException() {
			super("Errore: eventi non trovati...");		
		}
		
		/**
		 * Metodo passato al controller per la bad request
		 * @return "Errore:\n Nessuno evento trovato per parametro di ricerca..."  come messaggio
		 */
		public String noEventsFoundExceptionError() {
			return("Errore:\n Nessuno evento trovato per parametro di ricerca...");
		}

	

}
