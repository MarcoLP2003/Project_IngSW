package org.example.Template;

import org.example.main.Libreria;
import org.example.main.Libro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ScritturaCSV extends AbstractTemplate{

    private String path;

    public ScritturaCSV(String path) {
        super(path);
        this.path = path;
    }

    @Override
    public Libreria leggi() {
        System.out.println("Classe sbagliata per leggere");
        return null;
    }

    @Override
    public void scrivi(Libro libro, Libreria libreria) {
        try(PrintWriter out = new PrintWriter(new FileWriter(this.path, true), true)){
            out.println(libro.getTitolo()+","+
                    libro.getAutore()+","+
                    libro.getIsbn()+","+
                    libro.getGenere()+","+
                    libro.getValutazione()+","+
                    libro.getStato());
        }catch (IOException e){
            throw new RuntimeException("Errore in scrittura su CSV",e);
        }
    }
}
