package it.univpm.TicketMasterEventsApp.exceptions;

public class NoEventsFoundException extends Exception {

	
		private static final long serialVersionUID = 1L;

		public NoEventsFoundException() {
			super("Errore: eventi non trovati...");		
		}
		
		public String noEventsFoundExceptionError() {
			return("Errore:\n Nessuno evento trovato per parametro di ricerca...");
		}

	

}
