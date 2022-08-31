package it.univpm.TicketMasterEventsApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.TicketMasterEventsApp.model.Events;
import it.univpm.TicketMasterEventsApp.service.Downloadevent;

public class DownloadEventTest {
	
	List<Events> eventi = null;	
	
	@BeforeEach
	void setUp() throws Exception {
		Downloadevent e = new Downloadevent();
		eventi = new ArrayList<Events>();				
		eventi = e.initializeEvents();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Corretto funzionamento di Downloadevent.")
	void test() {
		assertNotNull(eventi);
	}

}
