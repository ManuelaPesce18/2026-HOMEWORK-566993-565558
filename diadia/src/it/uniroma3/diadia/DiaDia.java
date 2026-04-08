package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.io.IOConsole;

public class DiaDia {

    static final private String MESSAGGIO_BENVENUTO = "Benvenuto!";
    static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

    private Partita partita;
    private IOConsole io;

    public DiaDia(IOConsole io) {
        this.partita = new Partita();
        this.io = io;
    }

    public void gioca() {
        String istruzione;
        io.mostraMessaggio(MESSAGGIO_BENVENUTO);

        do {
            istruzione = io.leggiRiga();
        } while (!processaIstruzione(istruzione));
    }

    public boolean processaIstruzione(String istruzione) {
        Comando comando = new Comando(istruzione);

        if (comando.getNome() == null) {
            io.mostraMessaggio("Nessun comando");
            return false;
        }

        String nome = comando.getNome();
        String parametro = comando.getParametro();

        if (nome.equals("fine")) {
            fine();
            return true;
        } else if (nome.equals("vai")) {
            vai(parametro);
        } else if (nome.equals("aiuto")) {
            aiuto();
        } else if (nome.equals("prendi")) {
            prendi(parametro);
        } else if (nome.equals("posa")) {
            posa(parametro);
        } else {
            io.mostraMessaggio("Comando sconosciuto");
        }

        if (partita.vinta()) {
            io.mostraMessaggio("Hai vinto!");
            return true;
        }

        return false;
    }

    public void vai(String direzione) {
        if (direzione == null) {
            io.mostraMessaggio("Dove?");
            return;
        }

        Stanza prossima = partita.getStanzaCorrente().getStanzaAdiacente(direzione);

        if (prossima == null)
            io.mostraMessaggio("Direzione inesistente");
        else {
            partita.setStanzaCorrente(prossima);
            partita.setCfu(partita.getCfu() - 1);
        }

        io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
    }

    public void aiuto() {
        String msg = "";
        for (String c : elencoComandi)
            msg += c + " ";
        io.mostraMessaggio(msg);
    }

    public void prendi(String nome) {
        Stanza s = partita.getStanzaCorrente();
        Attrezzo a = s.getAttrezzo(nome);

        if (a == null) {
            io.mostraMessaggio("Non c'è");
            return;
        }

        if (partita.getGiocatore().getBorsa().addAttrezzo(a)) {
            s.removeAttrezzo(a);
            io.mostraMessaggio("Preso");
        } else {
            io.mostraMessaggio("Borsa piena");
        }
    }

    public void posa(String nome) {
        Borsa b = partita.getGiocatore().getBorsa();
        Attrezzo a = b.removeAttrezzo(nome);

        if (a == null) {
            io.mostraMessaggio("Non ce l'hai");
            return;
        }

        partita.getStanzaCorrente().addAttrezzo(a);
        io.mostraMessaggio("Posato");
    }

    public void fine() {
        io.mostraMessaggio("Fine gioco");
    }

    public static void main(String[] args) {
        IOConsole io = new IOConsole();
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
    }
}