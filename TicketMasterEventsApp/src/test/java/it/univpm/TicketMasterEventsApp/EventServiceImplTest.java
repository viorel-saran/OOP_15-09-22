package it.univpm.TicketMasterEventsApp;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.TicketMasterEventsApp.exceptions.NoCountryFoundException;
import it.univpm.TicketMasterEventsApp.exceptions.NoEventsFoundException;
import it.univpm.TicketMasterEventsApp.exceptions.NoGenreFoundException;
import it.univpm.TicketMasterEventsApp.service.EventServiceImpl;

/**
 * @author Viorel Saran
 * @author Luca Marziliano
 */

@SpringBootTest

public class EventServiceImplTest {
					    
		private EventServiceImpl event;
		
		String genere;
		String paese;
	
		@BeforeEach
		void setUp() throws Exception {
			event = new EventServiceImpl();
		}
		
		@AfterEach
		void tearDown() throws Exception {
		}

	    @Test
		@DisplayName("Corretto lancio di NoCountryFoundException.")
		 void test1() {
	    	paese = "ITG";
			assertThrows(NoCountryFoundException.class, ()-> event.filterEventsPerCountry(paese));
		}
	    
	    @Test	    
		@DisplayName("Corretto lancio di NoEventsFoundException.")
		 void test2() {
			paese= "Turchia";
			assertThrows(NoEventsFoundException.class, ()-> event.filterEventsPerCountry(paese));
		}
	    
	    @Test	    
		@DisplayName("Corretto lancio di NoGenreFoundException.")
		 void test3() {
			genere = "musicca";
			assertThrows(NoGenreFoundException.class, ()-> event.filterEventsPerGenre(genere));
		}
}
