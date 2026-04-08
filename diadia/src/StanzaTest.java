

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetNome() {
	    Stanza stanza = new Stanza("cucina");
	    assertEquals("cucina", stanza.getNome());
	}
	
	@Test
	void testAddAttrezzoEHasAttrezzo() {
	    Stanza stanza = new Stanza("cucina");
	    Attrezzo martello = new Attrezzo("martello", 2);

	    stanza.addAttrezzo(martello);

	    assertTrue(stanza.hasAttrezzo("martello"));
	}
	
	@Test
	void testHasAttrezzoNonPresente() {
	    Stanza stanza = new Stanza("cucina");
	    Attrezzo martello = new Attrezzo("martello", 2);

	    stanza.addAttrezzo(martello);

	    assertFalse(stanza.hasAttrezzo("chiave"));
	}

}
