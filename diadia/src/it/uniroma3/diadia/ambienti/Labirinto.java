package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

    private Stanza stanzaIniziale;
    private Stanza stanzaFinale;

    public Labirinto() {
        creaLabirinto();
    }

    private void creaLabirinto() {

        Attrezzo lanterna = new Attrezzo("lanterna",3);
        Attrezzo osso = new Attrezzo("osso",1);

        Stanza atrio = new Stanza("Atrio");
        Stanza aulaN11 = new Stanza("Aula N11");
        Stanza aulaN10 = new Stanza("Aula N10");
        Stanza laboratorio = new Stanza("Laboratorio");
        Stanza biblioteca = new Stanza("Biblioteca");

        atrio.impostaStanzaAdiacente("nord", biblioteca);
        atrio.impostaStanzaAdiacente("est", aulaN11);
        atrio.impostaStanzaAdiacente("sud", aulaN10);
        atrio.impostaStanzaAdiacente("ovest", laboratorio);

        aulaN10.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);

        this.stanzaIniziale = atrio;
        this.stanzaFinale = biblioteca;
    }

    public Stanza getStanzaIniziale() {
        return stanzaIniziale;
    }

    public Stanza getStanzaFinale() {
        return stanzaFinale;
    }
}