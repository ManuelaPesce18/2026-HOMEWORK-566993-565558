import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;


public class PartitaTest {
	@Test
	void testPartitaNonFinitaAllInizio() {
	    Partita partita = new Partita();

	    assertFalse(partita.isFinita());
	}
	
	@Test
	void testPartitaVinta() {
	    Partita partita = new Partita();

	    partita.setStanzaCorrente(partita.getStanzaVincente());

	    assertTrue(partita.vinta());
	}
	
	@Test
	void testIsFinitaQuandoVinci() {
	    Partita partita = new Partita();

	    partita.setStanzaCorrente(partita.getStanzaVincente());

	    assertTrue(partita.isFinita());
	}
	
	@Test
	void testIsFinitaQuandoCFUZero() {
	    Partita partita = new Partita();

	    partita.setCfu(0);

	    assertTrue(partita.isFinita());
	} 

}
