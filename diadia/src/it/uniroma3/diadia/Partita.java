package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Partita {

    static final private int CFU_INIZIALI = 20;

    private Stanza stanzaCorrente;
    private Stanza stanzaVincente;
    private boolean finita;
    private Giocatore giocatore;
    private Labirinto labirinto;
    
    public Partita(){
        this.labirinto = new Labirinto();
        this.stanzaCorrente = labirinto.getStanzaIniziale();
        this.stanzaVincente = labirinto.getStanzaFinale();
        this.finita = false;
        this.giocatore = new Giocatore();
    }

    public Stanza getStanzaVincente() {
        return stanzaVincente;
    }

    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }
    
    public boolean vinta() {
        return this.getStanzaCorrente() == this.getStanzaVincente();
    }

    public boolean isFinita() {
        return finita || vinta() || (this.giocatore.getCfu() == 0);
    }

    public void setFinita() {
        this.finita = true;
    }

    public int getCfu() {
        return this.giocatore.getCfu();
    }

    public void setCfu(int cfu) {
        this.giocatore.setCfu(cfu);  
 
    }  
    
    public Giocatore getGiocatore() {
        return this.giocatore;
    }
}
