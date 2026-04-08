package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

    private Stanza stanza;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        stanza = new Stanza("Aula");
        attrezzo = new Attrezzo("martello", 2);
    }

    // ---------------- addAttrezzo ----------------

    @Test
    public void testAddAttrezzoVuota() {
        assertTrue(stanza.addAttrezzo(attrezzo));
    }

    @Test
    public void testAddAttrezzoPresente() {
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.hasAttrezzo("martello"));
    }

    @Test
    public void testAddAttrezzoLimite() {
        for(int i = 0; i < 10; i++) {
            stanza.addAttrezzo(new Attrezzo("a"+i, 1));
        }
        assertFalse(stanza.addAttrezzo(new Attrezzo("extra", 1)));
    }

    // ---------------- getAttrezzo ----------------

    @Test
    public void testGetAttrezzoEsistente() {
        stanza.addAttrezzo(attrezzo);
        assertEquals(attrezzo, stanza.getAttrezzo("martello"));
    }

    @Test
    public void testGetAttrezzoNonEsistente() {
        assertNull(stanza.getAttrezzo("inesistente"));
    }

    @Test
    public void testGetAttrezzoConPiuAttrezzi() {
        Attrezzo altro = new Attrezzo("chiave", 1);
        stanza.addAttrezzo(attrezzo);
        stanza.addAttrezzo(altro);
        assertEquals(altro, stanza.getAttrezzo("chiave"));
    }

    // ---------------- hasAttrezzo ----------------

    @Test
    public void testHasAttrezzoTrue() {
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.hasAttrezzo("martello"));
    }

    @Test
    public void testHasAttrezzoFalse() {
        assertFalse(stanza.hasAttrezzo("martello"));
    }

    @Test
    public void testHasAttrezzoDopoAggiunta() {
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.hasAttrezzo("martello"));
    }

    // ---------------- stanze adiacenti ----------------

    @Test
    public void testStanzaAdiacenteEsistente() {
        Stanza biblioteca = new Stanza("Biblioteca");
        stanza.impostaStanzaAdiacente("nord", biblioteca);
        assertEquals(biblioteca, stanza.getStanzaAdiacente("nord"));
    }

    @Test
    public void testStanzaAdiacenteNonEsistente() {
        assertNull(stanza.getStanzaAdiacente("nord"));
    }

    @Test
    public void testStanzaAdiacenteSovrascritta() {
        Stanza prima = new Stanza("Prima");
        Stanza seconda = new Stanza("Seconda");
        stanza.impostaStanzaAdiacente("nord", prima);
        stanza.impostaStanzaAdiacente("nord", seconda);
        assertEquals(seconda, stanza.getStanzaAdiacente("nord"));
    }
}