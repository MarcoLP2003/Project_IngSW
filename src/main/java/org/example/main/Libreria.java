package org.example.main;

import java.util.LinkedList;

public class Libreria{

    LinkedList<Libro> libri = new LinkedList<>();
    public Libreria(){
        this.libri = new LinkedList<>();
    }
    public Libreria(LinkedList<Libro> libri){
        this.libri = libri;
    }

    //fare metodo salva dove aggiorna il file locale

    public void aggiorna(LinkedList<Libro> libr2){
        libri = libr2;
        System.out.println("Libreria aggiornata");
    }

    public LinkedList<Libro> getLibri() {
        return libri;
    }
}
