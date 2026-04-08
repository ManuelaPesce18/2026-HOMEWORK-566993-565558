package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LabirintoTest {

    private Labirinto labirinto;

    @BeforeEach
    public void setUp() {
        labirinto = new Labirinto();
    }

    // -------- stanze --------

    @Test
    public void testStanzaInizialeNonNull() {
        assertNotNull(labirinto.getStanzaIniziale());
    }

    @Test
    public void testStanzaFinaleNonNull() {
        assertNotNull(labirinto.getStanzaFinale());
    }

    @Test
    public void testStanzaInizialeDiversaFinale() {
        assertNotEquals(labirinto.getStanzaIniziale(), labirinto.getStanzaFinale());
    }

    // -------- contenuto --------

    @Test
    public void testStanzaInizialeHaNome() {
        assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
    }

    @Test
    public void testStanzaFinaleHaNome() {
        assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());
    }

    @Test
    public void testStanzaInizialeContieneAttrezzo() {
        assertTrue(labirinto.getStanzaIniziale().hasAttrezzo("osso"));
    }
}