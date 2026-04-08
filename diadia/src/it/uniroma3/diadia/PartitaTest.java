package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

    private Partita partita;

    @BeforeEach
    public void setUp() {
        partita = new Partita();
    }

    // ---------------- stanza corrente ----------------

    @Test
    public void testStanzaCorrenteNonNull() {
        assertNotNull(partita.getStanzaCorrente());
    }

    @Test
    public void testSetStanzaCorrente() {
        Stanza nuova = new Stanza("Nuova");
        partita.setStanzaCorrente(nuova);

        assertEquals(nuova, partita.getStanzaCorrente());
    }

    @Test
    public void testCambioStanzaCorrente() {
        Stanza nuova = new Stanza("Aula");
        partita.setStanzaCorrente(nuova);

        assertEquals("Aula", partita.getStanzaCorrente().getDescrizione());
    }

    // ---------------- CFU ----------------

    @Test
    public void testCfuIniziali() {
        assertEquals(20, partita.getCfu());
    }

    @Test
    public void testSetCfu() {
        partita.setCfu(10);
        assertEquals(10, partita.getCfu());
    }

    @Test
    public void testRiduzioneCfu() {
        partita.setCfu(5);
        partita.setCfu(partita.getCfu() - 1);

        assertEquals(4, partita.getCfu());
    }

    // ---------------- vinta ----------------

    @Test
    public void testPartitaVinta() {
        partita.setStanzaCorrente(partita.getStanzaVincente());

        assertTrue(partita.vinta());
    }

    @Test
    public void testPartitaNonVinta() {
        assertFalse(partita.vinta());
    }

    @Test
    public void testPartitaNonVintaConAltraStanza() {
        partita.setStanzaCorrente(new Stanza("Qualsiasi"));

        assertFalse(partita.vinta());
    }
}