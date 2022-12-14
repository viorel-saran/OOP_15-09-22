package it.univpm.TicketMasterEventsApp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import it.univpm.TicketMasterEventsApp.model.Events;


/**Classe che calcola la statistiche 
 * @author Luca Marziliano
 * @author Viorel Saran
 */
public class Stats {
	
	
	/**Metodo che prende la lista di oggetti evento, itera e controlla il genere di ogni oggetto e aumenta il counter relativo
	 * @see Events#getGenereEvento()
	 * @param eventsOBJs
	 * @return statsEventiGen
	 */
	public static JSONObject getEventiPerGenere(List<Events> eventsOBJs) {
		
		int countmus=0;
		int countsport=0;
		int countmisc=0;
		int countaandt=0;
		int countfilm=0;
				
		for(Events o: eventsOBJs) {
			
			switch(o.getGenereEvento()) {
			case "Music": countmus++;break;
			case "Film": countfilm++;break;
			case "Sports": countsport++;break;
			case "Arts & Theatre": countaandt++;break;
			case "Miscellaneous": countmisc++;break;
			}			
		}
		
		JSONObject statsEventiGen= new JSONObject()  ;
		statsEventiGen.put("musica", countmus);
		statsEventiGen.put("mischio", countmisc);
		statsEventiGen.put("arte e teatro", countaandt);
		statsEventiGen.put("sport", countsport);
		statsEventiGen.put("film", countfilm);
		
		return statsEventiGen;
	}
	
	
	/**Metodo che prende la lista di oggetti evento, itera e controlla la data di ogni oggetto e aumenta il counter del mese relativo, e 
	 * ritorna un jsonobject con le stats min/med/max
	 * @see Events#getDataDelEvento()
	 * @see Stats#maxCounters(int...)
	 * @see Stats#minCounters(int...)
	 * @see Stats#mediaCounters(int...)
	 * @param eventsOBJs
	 * @return statsEventiMesi
	 */
	public static JSONObject getMinMaxMedEventi(List<Events> eventsOBJs) {
				
		int countGen=0;
		int countFeb=0;
		int countMar=0;
		int countApr=0;
		int countMag=0;
		int countGiu=0;
		int countLug=0;
		int countAgo=0;
		int countSet=0;
		int countOtt=0;
		int countNov=0;
		int countDec=0;
		
		JSONObject risposta= new JSONObject();
		
		for(Events o: eventsOBJs) {
			
			DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
			
			Date date;
			try {
				date = dateFormat.parse(o.getDataDelEvento());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				continue;
			}
			
			int mese=date.getMonth();
			
			switch(mese) {
			
			case 1:  countGen++;break;
			case 2:  countFeb++;break;
			case 3:  countMar++;break;
			case 4:  countApr++;break;
			case 5:  countMag++;break;
			case 6:  countGiu++;break;
			case 7:  countLug++;break;
			case 8:  countAgo++;break;
			case 9:  countSet++;break;
			case 10: countOtt++;break;
			case 11: countNov++;break;
			case 12: countDec++;break;
			
			}		
			
		}
		
		JSONObject statsEventiMesi= new JSONObject()  ;
		statsEventiMesi.put("Numero massimo di eventi mensili", maxCounters(countGen,countFeb,countMar,countApr,countMag,countGiu,
				                                                            countLug,countAgo,countSet,countOtt,countNov,countDec));
		statsEventiMesi.put("Numero minimo di eventi mensili", minCounters(countGen,countFeb,countMar,countApr,countMag,countGiu,
				                                                            countLug,countAgo,countSet,countOtt,countNov,countDec));
		statsEventiMesi.put("Numero medio di eventi mensili", mediaCounters(countGen,countFeb,countMar,countApr,countMag,countGiu,
				                                                            countLug,countAgo,countSet,countOtt,countNov,countDec));				
		return statsEventiMesi;	
	}
	
	
	/**Metodo che prende la serie di interi passatogli e restituisce il massimo	 
	 * @param counters    serie di int di numero indefinito    
	 * @return appoggio
	 */
	private static int maxCounters(int... counters) {
		int appoggio=0;
		for(int e: counters) {
			if (appoggio<e) appoggio=e;
		}
		return appoggio;
	}
	
	/**Metodo che prende la serie di interi passatogli e restituisce il minimo	 
	 * @param counters    serie di int di numero indefinito
	 * @see Stats#maxCounters(int...)    
	 * @return appoggio
	 */
	private static int minCounters(int... counters) {
		int appoggio=maxCounters(counters);
		for(int e: counters) {
			if (appoggio>e) appoggio=e;
		}
		return appoggio;
	}
	
	/**Metodo che prende la serie di interi passatogli e restituisce la media	 
	 * @param counters    serie di int di numero indefinito  
	 * @return media
	 */
	private static double mediaCounters(int... counters) {
		int numCounters=0;
		int somma=0;
		for (int e: counters) {
			numCounters++;
			somma +=e;
		}	
		
		double media= somma/numCounters;
		
		return media;
		
	}
		
}