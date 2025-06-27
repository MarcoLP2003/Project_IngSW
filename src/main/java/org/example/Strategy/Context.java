package org.example.Strategy;

import org.example.main.Libro;

import java.util.LinkedList;

public class Context {
    private Ricerca ricerca;

    //Client crea e manda ricerca, io lo salvo e lo applico quando richiesto

    public void scegliRicerca (Ricerca r){
        this.ricerca = r;
    }

    public LinkedList<Libro> richiamaRicerca (){
        return ricerca.cerca();
    }

}
