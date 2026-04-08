package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class DiaDia {

    static final private String MESSAGGIO_BENVENUTO = ""+
            "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
            "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
            "I locali sono popolati da strani personaggi, " +
            "alcuni amici, altri... chissa!\n"+
            "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
            "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
            "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
            "Per conoscere le istruzioni usa il comando 'aiuto'.";

    static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

    private Partita partita;
    private IOConsole io;

    public DiaDia(IOConsole io) {
        this.io = io;
        this.partita = new Partita();
    }

    public void gioca() {
        String istruzione;

        io.mostraMessaggio(MESSAGGIO_BENVENUTO);

        do
            istruzione = io.leggiRiga();
        while (!processaIstruzione(istruzione));
    }

    private boolean processaIstruzione(String istruzione) {
        Comando comando = new Comando(istruzione);

        if (comando.getNome() == null) {
            io.mostraMessaggio("Comando sconosciuto");
            return false;
        }

        if (comando.getNome().equals("fine")) {
            this.fine();
            return true;
        }
        else if (comando.getNome().equals("vai"))
            this.vai(comando.getParametro());
        else if (comando.getNome().equals("aiuto"))
            this.aiuto();
        else if (comando.getNome().equals("prendi"))
            this.prendi(comando.getParametro());
        else if (comando.getNome().equals("posa"))
            this.posa(comando.getParametro());
        else
            io.mostraMessaggio("Comando sconosciuto");

        if (this.partita.vinta()) {
            io.mostraMessaggio("Hai vinto!");
            return true;
        }

        if (this.partita.isFinita()) {
            io.mostraMessaggio("Hai finito i CFU!");
            return true;
        }

        return false;
    }

    private void aiuto() {
        for(String comando : elencoComandi)
            io.mostraMessaggio(comando);
    }

    private void vai(String direzione) {
        if(direzione == null) {
            io.mostraMessaggio("Dove vuoi andare?");
            return;
        }

        Stanza prossima = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);

        if (prossima == null) {
            io.mostraMessaggio("Direzione inesistente");
            return;
        }

        this.partita.setStanzaCorrente(prossima);

        int cfu = this.partita.getCfu();
        this.partita.setCfu(cfu - 1);

        io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
    }

    private void prendi(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
            io.mostraMessaggio("Cosa vuoi prendere?");
            return;
        }

        Stanza stanza = this.partita.getStanzaCorrente();
        Attrezzo attrezzo = stanza.getAttrezzo(nomeAttrezzo);

        if (attrezzo != null) {
            stanza.removeAttrezzo(attrezzo);
            this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
            io.mostraMessaggio("Hai preso " + nomeAttrezzo);
        } else {
            io.mostraMessaggio("Attrezzo non presente");
        }
    }

    private void posa(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
            io.mostraMessaggio("Cosa vuoi posare?");
            return;
        }

        Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

        if (attrezzo != null) {
            this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
            this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
            io.mostraMessaggio("Hai posato " + nomeAttrezzo);
        } else {
            io.mostraMessaggio("Attrezzo non presente nella borsa");
        }
    }

    private void fine() {
        io.mostraMessaggio("Grazie di aver giocato!");
    }

    public static void main(String[] args) {
        IOConsole io = new IOConsole();
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
    }
}