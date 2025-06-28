package org.example.Command;

import org.example.main.Libreria;
import org.example.main.Libro;

import java.util.Iterator;
import java.util.LinkedList;

public class Receiver {

    private Libreria libreria;

    public Receiver(Libreria libreria) {
        this.libreria = libreria;
    }

    public void aggiungiLibro(Libro libro) {
        LinkedList<Libro> lib = libreria.getLibri();
        boolean exists = false;
        for(Libro l : lib){
            if(l.equals(libro)){
                System.out.println("il libro "+libro+" è uguale a questo: "+l);
                exists = true;
                break;
            }
        }
        if(exists){

            throw new RuntimeException("Libro gia presente");
        }
        lib.add(libro);
        libreria.aggiorna(lib);
    }

    public void modificaLibro(Libro libro) {
        LinkedList<Libro> lib = libreria.getLibri();
        boolean exists = false;
        Iterator<Libro> it = lib.iterator();

        while (it.hasNext()) {
            Libro l = it.next();
            if(l.equals(libro)){
                exists = true;
                it.remove();
                lib.add(libro);
                break;
            }
        }
        if(!exists){
            throw new RuntimeException("Libro non trovato, modifica non effettuata");
        }
        libreria.aggiorna(lib);
    }

    public void rimuoviLibro(Libro libro) {
        LinkedList<Libro> lib = libreria.getLibri();
        boolean exists = false;
        Iterator<Libro> it = lib.iterator();

        while (it.hasNext()) {
            Libro l = it.next();
            if(l.equals(libro)){
                exists = true;
                it.remove();
                break;
            }
        }
        if(!exists){
            throw new RuntimeException("Libro non trovato, modifica non effettuata");
        }
        libreria.aggiorna(lib);
    }
}
