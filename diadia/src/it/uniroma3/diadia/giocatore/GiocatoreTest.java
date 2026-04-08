package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {

    private Giocatore giocatore;

    @BeforeEach
    public void setUp() {
        giocatore = new Giocatore();
    }

    // -------- CFU --------

    @Test
    public void testCfuIniziali() {
        assertEquals(20, giocatore.getCfu());
    }

    @Test
    public void testSetCfu() {
        giocatore.setCfu(10);
        assertEquals(10, giocatore.getCfu());
    }

    @Test
    public void testCfuAggiornati() {
        giocatore.setCfu(5);
        assertEquals(5, giocatore.getCfu());
    }

    // -------- Borsa --------

    @Test
    public void testBorsaNonNull() {
        assertNotNull(giocatore.getBorsa());
    }

    @Test
    public void testBorsaVuotaAllInizio() {
        assertTrue(giocatore.getBorsa().isEmpty());
    }

    @Test
    public void testAggiuntaAttrezzoInBorsa() {
        Attrezzo a = new Attrezzo("osso",1);
        giocatore.getBorsa().addAttrezzo(a);

        assertTrue(giocatore.getBorsa().hasAttrezzo("osso"));
    }
}