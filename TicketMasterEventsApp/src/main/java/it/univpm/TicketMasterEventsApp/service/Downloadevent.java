package it.univpm.TicketMasterEventsApp.service;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import it.univpm.TicketMasterEventsApp.model.Events;
import it.univpm.TicketMasterEventsApp.service.Downloadevent;
=======
import org.json.simple.JSONArray;

>>>>>>> branch 'main' of https://github.com/viorel-saran/OOP_15-09-22


public class Downloadevent {
	
	private String apikey="&apikey=U5WWiFt5dP45LjbCYiS7LRp6Fx1P0VSA";
	
<<<<<<< HEAD
	//un set e' una collezione di oggetti senza ordine unici
	//non puo contenere un oggetto piu' di una volta e non si conosce la posizione del oggetto
	//HashSet: collezione non ordinata
	
	Set<Events> events= new HashSet<Events>();
=======
	public JSONArray Eventieuropei() {
		
		
		
	}
	
>>>>>>> branch 'main' of https://github.com/viorel-saran/OOP_15-09-22

	/**
	 * Metodo che richiede l'accesso al server di TicketMaster, scarica i dati relativi agli eventi 
	 * europei scelti traminte countryCode e restituisce un JSONArray che li contiene 
	 * countryCodes(plurale perche' contieni codici di tuti gli stati eu) è il codice che identifica il paese con cui scarico i dati di quel stato
	 * events è un JSONArray che contiene tutte informazioni di tutti gli eventi che hanno luogo in quel stato
	 */
	
	public JSONArray EventsAllStates() {
		
		//stringa inserita manualmente per dichiarare tutti gli stateCodes degli stati eu 
		//fonte stati appartenenti eu:  https://abbreviations.yourdictionary.com/articles/list-of-europe-country-codes.html
		String stateCodes = "AD,AT,BE,BG,HR,CY,CZ,DK,EE,FO,FI,FR,DE,GI,UK,GR,HU,IS,IE,"
				          + "IT,LV,LT,LU,MT,MC,ME,NL,NO,PL,PT,RO,RU,RS,SK,SI,ES,SE,CH,TR,UA"; //stati appartenti continente eu e presenti nell api
				          
		
		JSONArray allevents=new JSONArray();
		
		String url="https://app.ticketmaster.com/discovery/v2/events.json?size=200&locale=*&countryCode="+ stateCodes+ apikey;
		
		try {
		 HttpURLConnection connessione= (HttpURLConnection) new URL(url).openConnection();
         connessione.setRequestMethod("GET");
         connessione.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
         connessione.setRequestProperty("Content-Type", "application/json");
         
        
               InputStream in = connessione.getInputStream(); 
               String data = "";
               String line = "";
     
                System.out.println("Lettura dei dati...");
      
            try {
                 InputStreamReader inR = new InputStreamReader( in );
                 BufferedReader buf = new BufferedReader( inR );
         
                  while ( ( line = buf.readLine() ) != null ) {
                         data+= line;
                         System.out.println(line);
                       }
                  
                } finally {
                 in.close();
        }
            JSONObject totalobj = (JSONObject)JSONValue.parseWithException(data);
            JSONObject embedded = (JSONObject)(totalobj.get("_embedded"));
            
            allevents = (JSONArray)(embedded.get("events")); // jsonarray dove si trovano i dati
                      
		
		
	} catch(ParseException e){
		e.printStackTrace();
	}
		catch(Exception e) {
	       e.printStackTrace();
	}
		return  allevents; //JSONarray of data from API response
		
}
	/**
	 * Metodo che compone la mia struttura dati 
	 
		public void EventInfo(String stateCodes) {
			JSONArray event= EventsAllStates(stateCodes);
			for(Object o: event) { // scansiona ogni oggetto del JSONArrayarray event
				JSONObject n_eventi=(JSONObject) o;
				 
				Events e;
				String idEvento=(String) n_eventi.get("id");
				String nomeEvento=(String) n_eventi.get("name");
				String urlEvento=(String) n_eventi.get("url");
				/**
				String genereEvento=(String) n_eventi.get("");				
				if(genereEvento==null)
					genereEvento="Genere evento non specificato...";
				String dataDelEvento=(String) n_eventi.get("");
				if(dataDelEvento==null)
					dataDelEvento="data del evento non specificata...";
				String countryEvento=(String) n_eventi.get("");
				if(countryEvento==null)
					countryEvento="Paese del evento non specificato...";
				
				
				
				
				JSONObject d=(JSONObject) n_eventi.get("dates");
				JSONObject start= (JSONObject) d.get("start");
				String data=(String) start.get("localDate");
				
				e=new Events(idEvento, nomeEvento, urlEvento,"","","");			
				events.add(e);
			}
			
		}*/
	
}
