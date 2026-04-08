package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;

    public Borsa() {
        this.attrezzi = new Attrezzo[10];
        this.numeroAttrezzi = 0;
    }

    public boolean isEmpty() {
        return this.numeroAttrezzi == 0;
    }

    public void addAttrezzo(Attrezzo attrezzo) {
        this.attrezzi[numeroAttrezzi] = attrezzo;
        this.numeroAttrezzi++;
    }

    public boolean hasAttrezzo(String nome) {
        for (Attrezzo attrezzo : this.attrezzi) {
            if (attrezzo != null && attrezzo.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean removeAttrezzo(Attrezzo attrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++) {
            if (this.attrezzi[i].equals(attrezzo)) {

                // sposta a sinistra
                for (int j = i; j < this.numeroAttrezzi - 1; j++) {
                    this.attrezzi[j] = this.attrezzi[j + 1];
                }

                this.attrezzi[numeroAttrezzi - 1] = null;
                this.numeroAttrezzi--;

                return true;
            }
        }
        return false;
    }
    
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (Attrezzo attrezzo : this.attrezzi) {
            if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo)) {
                return attrezzo;
            }
        }
        return null;
    }

    public boolean removeAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < this.attrezzi.length; i++) {
            if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
                this.attrezzi[i] = null;
                return true;
            }
        }
        return false;
    }
}