package it.univpm.TicketMasterEventsApp.exceptions;

/**Metodo che lancia un eccezione quando il body inserito non e' esistente
 * @author Luca Marziliano
 * @author Viorel Saran
 */


public class NoBodyException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore
	 */
	public NoBodyException() {
		super("Errore: body non rilevato...");		
	}
	
	/**
	 * Metodo passato al controller per la bad request
	 * @return "Errore:\n E' necessario inserire un body nella richiesta..."  come messaggio
	 */
	public String noBodyExceptionError() {
		return("Errore:\n E' necessario inserire un body valido nella richiesta:\n {\r\n"
				+ "    \"filtri\":[\r\n"
				+ "        {\r\n"
				+ "            \"paese\": \"italia\"\r\n"
				+ "            \"genere\": \"musica\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"paese\": \"germania\"\r\n"
				+ "            \"genere\": \"arte\"\r\n"
				+ "        },\r\n"
				+ "    ]\r\n"
				+ "}");
	}
	

}
