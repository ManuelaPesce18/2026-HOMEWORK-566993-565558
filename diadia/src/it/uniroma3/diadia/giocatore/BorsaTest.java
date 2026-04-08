package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

    private Borsa borsa;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        borsa = new Borsa(10);
        attrezzo = new Attrezzo("martello", 2);
    }

    // -------- addAttrezzo --------

    @Test
    public void testAddAttrezzoLeggero() {
        assertTrue(borsa.addAttrezzo(attrezzo));
    }

    @Test
    public void testAddAttrezzoTroppoPesante() {
        Attrezzo pesante = new Attrezzo("incudine", 20);
        assertFalse(borsa.addAttrezzo(pesante));
    }

    @Test
    public void testAddAttrezzoLimiteNumero() {
        for(int i=0; i<10; i++)
            borsa.addAttrezzo(new Attrezzo("a"+i,1));

        assertFalse(borsa.addAttrezzo(new Attrezzo("extra",1)));
    }

    // -------- getAttrezzo --------

    @Test
    public void testGetAttrezzoPresente() {
        borsa.addAttrezzo(attrezzo);
        assertEquals(attrezzo, borsa.getAttrezzo("martello"));
    }

    @Test
    public void testGetAttrezzoNonPresente() {
        assertNull(borsa.getAttrezzo("inesistente"));
    }

    @Test
    public void testGetAttrezzoConPiuElementi() {
        Attrezzo altro = new Attrezzo("chiave",1);
        borsa.addAttrezzo(attrezzo);
        borsa.addAttrezzo(altro);

        assertEquals(altro, borsa.getAttrezzo("chiave"));
    }

    // -------- removeAttrezzo --------

    @Test
    public void testRemoveAttrezzoEsistente() {
        borsa.addAttrezzo(attrezzo);
        Attrezzo rimosso = borsa.removeAttrezzo("martello");

        assertEquals(attrezzo, rimosso);
    }

    @Test
    public void testRemoveAttrezzoNonEsistente() {
        assertNull(borsa.removeAttrezzo("inesistente"));
    }

    @Test
    public void testRemoveAttrezzoRiducePeso() {
        borsa.addAttrezzo(attrezzo);
        borsa.removeAttrezzo("martello");

        assertEquals(0, borsa.getPeso());
    }
}