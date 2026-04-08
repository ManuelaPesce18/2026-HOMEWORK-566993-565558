package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;

public class Partita {

    private Labirinto labirinto;
    private Giocatore giocatore;
    private boolean finita;
    private Stanza stanzaCorrente;

    public Partita() {
        this.labirinto = new Labirinto();
        this.giocatore = new Giocatore();
        this.finita = false;
        this.stanzaCorrente = labirinto.getStanzaIniziale();
    }

    public Stanza getStanzaCorrente() {
        return stanzaCorrente;
    }

    public void setStanzaCorrente(Stanza s) {
        this.stanzaCorrente = s;
    }

    public Stanza getStanzaVincente() {
        return labirinto.getStanzaFinale();
    }

    public Giocatore getGiocatore() {
        return giocatore;
    }

    public int getCfu() {
        return giocatore.getCfu();
    }

    public void setCfu(int cfu) {
        giocatore.setCfu(cfu);
    }

    public boolean vinta() {
        return stanzaCorrente == getStanzaVincente();
    }
}