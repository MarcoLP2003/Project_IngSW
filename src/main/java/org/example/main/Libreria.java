package org.example.main;

import org.example.Command.ComandoAggiunta;
import org.example.Command.Receiver;
import org.example.Template.ScritturaCSV;
import org.example.Template.ScritturaJSON;


import java.util.LinkedList;

public class Libreria{

    private LinkedList<Libro> libri = new LinkedList<>();
    private String path;
    private String tipo;

    public Libreria(String path, String tipo){
        if(!tipo.equalsIgnoreCase("json") && !tipo.equalsIgnoreCase("csv")){
            throw new IllegalArgumentException("Tipo file sbagliato");
        }
        this.libri = new LinkedList<>();
        this.path = path;
        this.tipo = tipo;
    }

    public Libreria(LinkedList<Libro> libri, String path, String tipo){
        this.libri = libri;
        this.path = path;
        this.tipo = tipo;
    }

    public void aggiorna(LinkedList<Libro> libr2){
        this.libri = libr2;
    }

    public void aggiungiLibro(Libro l){

        Receiver r = new Receiver(this);

        ComandoAggiunta comando = new ComandoAggiunta(l, r);
        comando.esegui();

        if(tipo.equalsIgnoreCase("json")){
            ScritturaJSON sj = new ScritturaJSON(path);
            sj.scrivi(l, this);

        } else if (tipo.equalsIgnoreCase("csv")) {
            ScritturaCSV sc =  new ScritturaCSV(path);
            sc.scrivi(l, this);
        }

        System.out.println("Libro aggiunto con successo");
    }

    public LinkedList<Libro> getLibri() {
        return libri;
    }

    @Override
    public String toString() {
        String s = "";
        for (Libro lib : libri) {
            s += lib.toString() + "\n";
        }
        return s;
    }
}
