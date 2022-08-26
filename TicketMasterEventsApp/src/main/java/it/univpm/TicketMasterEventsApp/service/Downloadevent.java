package it.univpm.TicketMasterEventsApp.service;


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

import com.google.gson.*;


public class Downloadevent {
	
	private String apikey="&apikey=U5WWiFt5dP45LjbCYiS7LRp6Fx1P0VSA";
	

	//un set e' una collezione di oggetti senza ordine unici
	//non puo contenere un oggetto piu' di una volta e non si conosce la posizione del oggetto
	//HashSet: collezione non ordinata
	
	public Set<Events> eventsOBJs= new HashSet<Events>();
	

	/**
	 * Metodo che richiede l'accesso al server di TicketMaster, scarica i dati relativi agli eventi 
	 * europei scelti traminte countryCode e restituisce un JSONArray che li contiene 
	 * countryCodes(plurale perche' contieni codici di tutti gli stati eu) è il codice che identifica il paese con cui scarico i dati di quel stato
	 * events è un JSONArray che contiene tutte informazioni di tutti gli eventi che hanno luogo in quel stato
	 */
	
	JSONArray allevents=new JSONArray();
	
	
	public long numEventsAllStates() {
		
		//stringa inserita manualmente per dichiarare tutti gli stateCodes degli stati eu 
		//fonte stati appartenenti eu:  https://abbreviations.yourdictionary.com/articles/list-of-europe-country-codes.html
		String stateCodes = "AD,AT,BE,BG,HR,CY,CZ,DK,EE,FO,FI,FR,DE,GI,UK,GR,HU,IS,IE,"
				          + "IT,LV,LT,LU,MT,MC,ME,NL,NO,PL,PT,RO,RU,RS,SK,SI,ES,SE,CH,TR,UA"; //stati appartenti continente eu e presenti nell api
				          
		
		long numeroEventi = 0;
		
		
		
		
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
            JSONObject page = (JSONObject)(totalobj.get("page"));                                                        
            
            numeroEventi = (Long)page.get("totalElements");         
		
		
	} catch(ParseException e){
		e.printStackTrace();
	}
		catch(Exception e) {
	       e.printStackTrace();
	}		
		
		return  numeroEventi;// jsonarray dove si trovano i tutti gli eventi in base agli countryCodes		
}
	
	
	
	
	
  @SuppressWarnings("unchecked")
public JSONArray EventsAllStates() {
		
	  
		//stringa inserita manualmente per dichiarare tutti gli stateCodes degli stati eu 
		//fonte stati appartenenti eu:  https://abbreviations.yourdictionary.com/articles/list-of-europe-country-codes.html
	    //stati appartenti continente eu e presenti nell api
		String stateCodes[] = {"AD","AT","BE","BG","HR",  "CY","CZ","DK","EE","FO",  "FI","FR","DE","GI","UK", " GR","HU","IS","IE","UA",
				               "IT","LV","LT","LU","MT",  "MC","ME","NL","NO","PL",  "PT","RO","RU","RS","SK",  "SI","ES","SE","CH"/*,"TR"*/}; 
				
		 
		JSONArray all = new JSONArray();
		JSONObject totalobj = new JSONObject();
		
		
		
		for(int i = 0; i<stateCodes.length; i++) {
			
			
		
		String url="https://app.ticketmaster.com/discovery/v2/events.json?size=50&locale=*&countryCode="+ stateCodes[i]+ apikey;
		
		
		
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
             totalobj = (JSONObject)JSONValue.parseWithException(data);//contenuto della risposta api
                        
            JSONObject embedded = (JSONObject)(totalobj.get("_embedded")); 
            
            allevents = (JSONArray)(embedded.get("events")); 
                             		
		
	} catch(ParseException e){
		e.printStackTrace();
	}
		catch(Exception e) {
	       e.printStackTrace();
	}		
		
		
		all.addAll(allevents);
		}
						
		return  all;// jsonarray dove si trovano i tutti gli eventi in base agli countryCodes		
}
	
	
	
	
	
	 // Metodo che compone la mia struttura dati 
	 
		public void initializeEvents() {
			
			JSONArray events= EventsAllStates();
			
			for(Object o: events) { // scansiona ogni oggetto del JSONArrayarray events
				
				JSONObject evento= (JSONObject) o;				 
				Events e;
				String genereEvento = "non specificato";
				
				
				
				String nomeEvento=(String) evento.get("name");
				
				
				JSONArray classification = (JSONArray)(evento.get("classifications"));
				if(classification!=null) {				
				JSONObject presegment = (JSONObject)(classification.get(0));
				JSONObject segment = (JSONObject)(presegment.get("segment"));
				genereEvento=(String)segment.get("name");
				if(genereEvento==null) {genereEvento="non specificato";}
				}
				
				JSONObject dates = (JSONObject)(evento.get("dates")); 
				JSONObject start = (JSONObject)(dates.get("start"));	
				String dataDelEvento=(String)start.get("localDate");
				
				
				JSONObject _embedded = (JSONObject)(evento.get("_embedded")); 
				JSONArray venues = (JSONArray)(_embedded.get("venues"));
				JSONObject presegment = (JSONObject)(venues.get(0));
				JSONObject country = (JSONObject)(presegment.get("country"));
				String countryEvento=(String)country.get("name");
				String countryCode = (String)country.get("countryCode");
																							
				e = new Events(countryCode,nomeEvento, genereEvento, dataDelEvento,countryEvento);			
				eventsOBJs.add(e);
				
			}
			
		}
	
}
