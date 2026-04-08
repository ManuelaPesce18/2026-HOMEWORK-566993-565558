package it.uniroma3.diadia.giocatore;

public class Giocatore {

    private int cfu;
    private Borsa borsa;

    public Giocatore() {
        this.cfu = 20;
        this.borsa = new Borsa();
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public Borsa getBorsa() {
        return borsa;
    }
}