import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	@Test
	void testBorsaVuotaAllInizio() {
	    Borsa borsa = new Borsa();

	    assertTrue(borsa.isEmpty());
	}
	
	@Test
	void testBorsaNonVuotaDopoAdd() {
	    Borsa borsa = new Borsa();
	    Attrezzo martello = new Attrezzo("martello", 2);

	    borsa.addAttrezzo(martello);

	    assertFalse(borsa.isEmpty());
	}
	
	@Test
	void testHasAttrezzo() {
	    Borsa borsa = new Borsa();
	    Attrezzo martello = new Attrezzo("martello", 2);

	    borsa.addAttrezzo(martello);

	    assertTrue(borsa.hasAttrezzo("martello"));
	}
	
	@Test
	void testHasAttrezzoNonPresente() {
	    Borsa borsa = new Borsa();
	    Attrezzo martello = new Attrezzo("martello", 2);

	    borsa.addAttrezzo(martello);

	    assertFalse(borsa.hasAttrezzo("chiave"));
	}

}
