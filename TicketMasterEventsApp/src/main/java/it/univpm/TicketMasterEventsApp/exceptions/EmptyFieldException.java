package it.univpm.TicketMasterEventsApp.exceptions;

public class EmptyFieldException extends Exception{
	/**
    * messaggio passato quando viene lanciata l'eccezione
    */
   String messaggio;

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   /**
    * 
    */
   public EmptyFieldException() {

   }
   
   /** costruttore con :
    * @param message
    */
   public EmptyFieldException(String messaggio) {
       this.messaggio=messaggio;

   }

   /**Messaggio di errore
    * @return  ritorna un messaggio di errore scritto dal programmatore per la gestione della rotta filter
    */

   public String Messaggio() {
       return "Errore:\n mancanza del parametro "+messaggio+" nel body della richiesta.\n Si richiede di compilare il body come di seguito: {\r\n"
       		+ "    \"filtri\":[\r\n"
       		+ "        {\r\n"
       		+ "            \"paese\": \"italia\"    \r\n"
       		+ "            \"genere\": \"musica\"\r\n"
       		+ "        },\r\n"
       		+ "        {\r\n"
       		+ "            \"paese\": \"germania\"\r\n"
       		+ "            \"genere\": \"arte\"\r\n"
       		+ "        },\r\n"
       		+ "    ]\r\n"
       		+ "}";
   }

}
