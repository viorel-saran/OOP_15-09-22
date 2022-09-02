package it.univpm.TicketMasterEventsApp.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import it.univpm.TicketMasterEventsApp.model.Events;


/**Classe che scarica gli eventi relativi ai countryCode e li istanzia
 * @author Luca Marziliano
 * @author Viorel Saran
 */
public class Downloadevent {
	
	// Unica istanza della classe
    private static Downloadevent instance = null;
    
    /**
   	 * Costruttore scarica e inizializza gli eventi
   	 * @see Downloadevent#initializeEvents()
   	 */	
    // Costruttore invisibile   
    private Downloadevent() {
    	initializeEvents();
    }
    
    /**
	 * Metodo che restituisce una lista di eventi
	 * @return eventsOBJs
	 */	
    public List<Events> getEventsOBJ() {
    	return eventsOBJs;
    }

    /**
	 * Metodo che crea l'oggetto solo se non esiste
	 * @return instance
	 */	
    public static Downloadevent getInstance() {       
        if (instance == null) {
            instance = new Downloadevent();
        }
        return instance;
    }
	
	/**
	 * Chiave di autenticazione dell'API
	 */
	private String apikey="&apikey=U5WWiFt5dP45LjbCYiS7LRp6Fx1P0VSA";
	
	/**
	 * Struttura dati in cui vengono inseriti tutti dati specificati nel model
	 * @see Events
	 */	
	public List<Events> eventsOBJs= new ArrayList<Events>();
	
	
	/**
	 *Metodo che richiede l'accesso al server di TicketMaster, scarica i dati relativi agli eventi 
	 *europei scelti tramite countryCode e restituisce un JSONArray che li contiene 	 
	 *@return all    è un JSONArray che contiene tutte informazioni di tutti gli
	 */		
	public JSONArray eventsAllStates() {
		
		//stringa inserita manualmente per dichiarare tutti i countryCode degli stati europei 
		//fonte stati appartenenti eu:  https://abbreviations.yourdictionary.com/articles/list-of-europe-country-codes.html
	    //stati appartenti continente europeo e presenti nella lista dell'api
		String stateCodes[] = {"AD","AT","BE","BG","HR",  "CY","CZ","DK","EE","FO",  "FI","FR","DE","GI","UK", " GR","HU","IS","IE","UA",
				               "IT","LV","LT","LU","MT",  "MC","ME","NL","NO","PL",  "PT","RO","RU","RS","SK",  "SI","ES","SE","CH","TR"}; 
		
		JSONArray all = new JSONArray();
		JSONObject totalobj = new JSONObject();				
		
		for(int i = 0; i<stateCodes.length; i++) {								
			String url="https://app.ticketmaster.com/discovery/v2/events.json?size=200&locale=*&countryCode="+ stateCodes[i]+ apikey;
			JSONArray allevents=new JSONArray();				
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
				continue;				
			}catch(Exception e) {
				continue;				
			}		
				
		all.addAll(allevents);
		
		}						
			return  all;// jsonarray dove si trovano tutti gli eventi in base ai countryCode		
	}
	
		
	  
	/**
	 * Metodo che compone la mia struttura dati e la restituisce 	 
	 * @see Downloadevent#eventsAllStates() 
	 * @return eventsOBJs
	 */
	public List<Events> initializeEvents() {
			
			JSONArray events= eventsAllStates();
			
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
			return eventsOBJs;			
			}
	
}
