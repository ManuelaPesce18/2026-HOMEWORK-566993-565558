package it.uniroma3.diadia;

import java.util.Scanner;

public class Comando {

    private String nome;
    private String parametro;

    public Comando(String istruzione) {
        Scanner s = new Scanner(istruzione);
        if (s.hasNext()) nome = s.next();
        if (s.hasNext()) parametro = s.next();
    }

    public String getNome() { return nome; }
    public String getParametro() { return parametro; }
}