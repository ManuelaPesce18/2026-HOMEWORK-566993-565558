import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	@Test
	void testCfuIniziali() {
	    Giocatore giocatore = new Giocatore();

	    assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	void testSetCfu() {
	    Giocatore giocatore = new Giocatore();

	    giocatore.setCfu(10);

	    assertEquals(10, giocatore.getCfu());
	}
	
	@Test
	void testBorsaNonNull() {
	    Giocatore giocatore = new Giocatore();

	    assertNotNull(giocatore.getBorsa());
	}
	
	@Test
	void testBorsaVuotaAllInizio() {
	    Giocatore giocatore = new Giocatore();

	    assertTrue(giocatore.getBorsa().isEmpty());
	}
}
